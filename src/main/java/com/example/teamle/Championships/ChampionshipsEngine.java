package com.example.teamle.Championships;
import com.example.teamle.Enums.TeamleEnums.Leagues;
import com.example.teamle.JsonDeserializers.LeagueDeserializer;
import com.example.teamle.JsonDeserializers.TeamSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.jsoup.Jsoup;
import com.example.teamle.Guess.Team;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class ChampionshipsEngine {
    public static List<Integer> GetTeamChampionships(Team t){
        Document d;
        try {
            d = Jsoup.connect("https://en.wikipedia.org/wiki/" + GetTeamUrl(t)).get();
        }
        catch (IOException e){
            return new ArrayList<>();
        }
        Elements infobox = d.select(".infobox");
        Leagues teamLeague = t.getLeague();
        switch (teamLeague){
            case MLB -> {
                return GetChampionshipsForMLB(infobox);
            }
            case NHL -> {
                return GetChampionshipsForNHL(infobox);
            }
            case NBA -> {
                return GetChampionshipsForNBA(infobox);
            }
            case NFL -> {
                return GetChampionshipsForNFL(infobox);
            }
            default -> {
                return new ArrayList<>();
            }
        }
    }

    public static void UpdateLeague(File db, Leagues league){
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(List.class, new LeagueDeserializer(league));
        module.addSerializer(Team.class, new TeamSerializer());
        mapper.registerModule(module);

        TypeReference<List<Team>> listType = new TypeReference<>() {};
        List<Team> teams;
        JsonNode rootNode;
        ArrayNode arrayNode = mapper.createArrayNode();
        try {
            teams = mapper.readValue(db, listType);
            rootNode = mapper.readTree(db);
        }
        catch (IOException e){
            return;
        }
        List<Callable<Void>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        for (Team t: teams) {
            futures.add(() ->
            {
                GetTeamChampionships(t, arrayNode, mapper);
                return null;
            });
        }
        try {
            executorService.invokeAll(futures);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ((ObjectNode) rootNode).set("data", arrayNode);
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(db, rootNode);
        }
        catch (IOException e){
            return;
        }
    }

    private static void GetTeamChampionships(Team t, ArrayNode arrayNode, ObjectMapper mapper) {
        List<Integer> championships = GetTeamChampionships(t);
        if (championships.isEmpty()){
            t.setNumberChampionships(0);
            t.setLastChampionship(0);
        }
        int lastChampionship = Collections.max(championships);
        int numberChampionships = championships.size();
        if(t.getLastChampionship() < lastChampionship){
            t.setLastChampionship(Collections.max(championships));
        }
        if(t.getNumberChampionships() < numberChampionships){
            t.setNumberChampionships(championships.size());
        }

        try {
            arrayNode.add(mapper.readTree(mapper.writeValueAsString(t)));
        } catch (JsonProcessingException e) {
            return;
        }
    }
    private static List<Integer> GetChampionshipsForNBA(Elements infobox){
        Elements championshipsLabel = infobox.select(":containsOwn(Championships)");
        Element parent = championshipsLabel.first().parent();
        Elements years = GetYearLinkElements(parent);
        if (years.isEmpty()){
            return new ArrayList<>();
        }
        String yearsText = years.text();
        return Arrays.stream(yearsText.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<Integer> GetChampionshipsForNFL(Elements infobox){
        Elements championshipsLabel = infobox.select(":containsOwn(Super Bowl championships)");
        if (championshipsLabel.isEmpty()){
            return new ArrayList<>();
        }
        Element parent = championshipsLabel.first().parent().parent();
        Elements links = parent.select("a");
        Elements filteredLinks = links.stream()
                .filter(link -> !link.attr("href").toLowerCase().contains("super_bowl"))
                .collect(Collectors.toCollection(Elements::new));
        if (filteredLinks.isEmpty()){
            return new ArrayList<>();
        }
        String yearsText = filteredLinks.text();
        return Arrays.stream(yearsText.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<Integer> GetChampionshipsForMLB(Elements infobox){
        Elements championshipsLabel = infobox.select(":containsOwn(World Series titles)");
        Element parent = championshipsLabel.first().parent().parent();
        Elements years = GetYearLinkElements(parent);
        if (years.isEmpty()){
            return new ArrayList<>();
        }
        String yearsText = years.text();
        return Arrays.stream(yearsText.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<Integer> GetChampionshipsForNHL(Elements infobox){
        Elements championshipsLabel = infobox.select(":containsOwn(Stanley Cups)");
        Element parent = championshipsLabel.first().parent().parent();
        Elements years = GetYearLinkElements(parent);
        if (years.isEmpty()){
            return new ArrayList<>();
        }
        String yearsText = years.text();
        String[] yearsArray = yearsText.split(" ");
        ArrayList<Integer> yearsList = new ArrayList<>();
        for (String year : yearsArray) {
            String[] yearParts = year.split("–"); //this is a special dash from wikipedia. DO NOT CHANGE
            String firstYear = yearParts[0].substring(0,2);
            String secondYear = yearParts[1];
            yearsList.add(Integer.parseInt(firstYear.concat(secondYear)));
        }
        return yearsList;
    }

    private static Elements GetYearLinkElements(Element parent){
        Elements championShips = parent.select(".infobox-data");
        return championShips.select("a");
    }

    private static String GetTeamUrl(Team t){
        return t.getTeamName().replace(" ", "_");
    }
}
