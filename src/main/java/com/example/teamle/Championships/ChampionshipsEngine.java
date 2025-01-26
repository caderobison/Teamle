package com.example.teamle.Championships;
import org.jsoup.Jsoup;
import com.example.teamle.Guess.Team;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChampionshipsEngine {
    public static void GetTeamChampionships(Team t){
        Document d;
        try {
            d = Jsoup.connect("https://en.wikipedia.org/wiki/Houston_Texans").get();
        }
        catch (IOException e){
            return;
        }
        Elements infobox = d.select(".infobox");
        List<Integer> championships = GetChampionshipsForNFL(infobox);

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
}
