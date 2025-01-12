package com.example.teamle.Teams;

import com.example.teamle.Enums.TeamleEnums.Leagues;
import com.example.teamle.Guess.Team;
import com.example.teamle.JsonDeserializers.TeamDeserializer;
import com.example.teamle.JsonDeserializers.TeamSkeletonDeserializer;
import com.example.teamle.Teams.TeamSkeleton.TeamSkeleton;
import com.example.teamle.Teams.TeamSkeleton.TeamSkeletonComparator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class TeamsEngine {

    public static List<TeamSkeleton> GetAllTeams(){
        File mlbDb, nflDb, nbaDb, nhlDb;
        try {
            mlbDb = GetDBFile(TeamConstants.MLB_DB_PATH);
            nflDb = GetDBFile(TeamConstants.NFL_DB_PATH);
            nbaDb = GetDBFile(TeamConstants.NBA_DB_PATH);
            nhlDb = GetDBFile(TeamConstants.NHL_DB_PATH);
        }
        catch (FileNotFoundException e){
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(List.class, new TeamSkeletonDeserializer());
        mapper.registerModule(module);

        List<TeamSkeleton> mlbTeams, nflTeams, nbaTeams, nhlTeams;
        TypeReference<List<TeamSkeleton>> listType = new TypeReference<>() {};
        try{
            mlbTeams = mapper.readValue(mlbDb, listType);
            nflTeams = mapper.readValue(nflDb, listType);
            nbaTeams = mapper.readValue(nbaDb, listType);
            nhlTeams = mapper.readValue(nhlDb, listType);
        }
        catch (IOException e){
            return null;
        }
        List<TeamSkeleton> allTeams = nflTeams;
        allTeams.addAll(nbaTeams);
        allTeams.addAll(mlbTeams);
        allTeams.addAll(nhlTeams);
        allTeams.sort(new TeamSkeletonComparator());
        return allTeams;
    }

    public static Team GetTeam(int teamId){
        Leagues league = GetLeagueFromId(teamId);
        String dbPath;
        switch (Objects.requireNonNull(league)){
            case MLB -> dbPath = TeamConstants.MLB_DB_PATH;
            case NBA -> dbPath = TeamConstants.NBA_DB_PATH;
            case NHL -> dbPath = TeamConstants.NHL_DB_PATH;
            case NFL -> dbPath = TeamConstants.NFL_DB_PATH;
            default -> dbPath = "";
        }
        File dbFile;
        try {
            dbFile = GetDBFile(dbPath);
        }
        catch (FileNotFoundException e){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Team.class, new TeamDeserializer(teamId, league));

        mapper.registerModule(module);
        Team selectedTeam = null;
        try{
            selectedTeam = mapper.readValue(dbFile, Team.class);
        }
        catch (IOException e){
            return null;
        }
        return selectedTeam;
    }

    private static File GetDBFile(String path) throws FileNotFoundException {
        File dbFile = new File(path);
        if(!dbFile.exists()){
            throw new FileNotFoundException("Given file path \"" + path + "\"");
        }
        return dbFile;
    }

    private static Leagues GetLeagueFromId(int teamId){
        if (TeamConstants.NFL_MIN_ID < teamId && teamId < TeamConstants.NFL_MAX_ID){
            return Leagues.NFL;
        }
        else if (TeamConstants.NBA_MIN_ID < teamId && teamId < TeamConstants.NBA_MAX_ID){
            return Leagues.NBA;
        }
        else if (TeamConstants.MLB_MIN_ID < teamId && teamId < TeamConstants.MLB_MAX_ID){
            return Leagues.MLB;
        }
        else if (TeamConstants.NHL_MIN_ID < teamId && teamId < TeamConstants.NHL_MAX_ID){
            return Leagues.NHL;
        }
        else return null;
    }

}
