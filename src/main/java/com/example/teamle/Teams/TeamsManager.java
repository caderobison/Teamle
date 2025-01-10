package com.example.teamle.Teams;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.asm.TypeReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class TeamsManager {
    public static List<TeamSkeleton> GetAllTeams(){
        String foo = "com/example/teamle/Database/MLBTeamSkeletons.Json";
        File mlbDb, nflDb, nbaDb, nhlDb;
        try {
            mlbDb = GetDBFile("com/example/teamle/Database/MLBTeamSkeletons.Json");
            nflDb = GetDBFile("com/example/teamle/Database/NFLTeamSkeletons.Json");
            nbaDb = GetDBFile("com/example/teamle/Database/NBATeamSkeletons.Json");
            nhlDb = GetDBFile("com/example/teamle/Database/NHLTeamSkeletons.Json");
        }
        catch (FileNotFoundException e){
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        List<TeamSkeleton> mlbTeams, nflTeams, nbaTeams, nhlTeams;
        try{
            mlbTeams = Arrays.asList(mapper.readValue(mlbDb, TeamSkeleton[].class));
            nflTeams = Arrays.asList(mapper.readValue(nflDb, TeamSkeleton[].class));
            nbaTeams = Arrays.asList(mapper.readValue(nbaDb, TeamSkeleton[].class));
            nhlTeams = Arrays.asList(mapper.readValue(nhlDb, TeamSkeleton[].class));
        }
        catch (IOException e){
            return null;
        }
        List<TeamSkeleton> allTeams = new ArrayList<>(mlbTeams);
        allTeams.addAll(nflTeams);
        allTeams.addAll(nbaTeams);
        allTeams.addAll(nhlTeams);
        return allTeams;
    }

    private static File GetDBFile(String path) throws FileNotFoundException {
        File dbFile = new File(path);
        if(dbFile == null){
            throw new FileNotFoundException("Given file path \"" + path + "\"");
        }
        return dbFile;
    }
}
