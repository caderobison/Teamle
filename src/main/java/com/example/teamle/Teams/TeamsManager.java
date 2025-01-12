package com.example.teamle.Teams;

import com.example.teamle.JsonDeserializers.TeamSkeletonDeserializer;
import com.example.teamle.Teams.TeamSkeleton.TeamSkeleton;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class TeamsManager {
    public static List<TeamSkeleton> GetAllTeams(){
        File mlbDb, nflDb, nbaDb, nhlDb;
        try {
            mlbDb = GetDBFile("src/main/java/com/example/teamle/Database/MLBTeamSkeletons.Json");
            nflDb = GetDBFile("src/main/java/com/example/teamle/Database/NFLTeamSkeletons.Json");
            nbaDb = GetDBFile("src/main/java/com/example/teamle/Database/NBATeamSkeletons.Json");
            nhlDb = GetDBFile("src/main/java/com/example/teamle/Database/NHLTeamSkeletons.Json");
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
        return allTeams;
    }

    private static File GetDBFile(String path) throws FileNotFoundException {
        File dbFile = new File(path);
        if(!dbFile.exists()){
            throw new FileNotFoundException("Given file path \"" + path + "\"");
        }
        return dbFile;
    }
}
