package com.example.teamle.Teams;

import com.example.teamle.Teams.TeamSkeleton.TeamSkeleton;
import com.example.teamle.Teams.TeamSkeleton.TeamSkeletonWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class TeamsManager {
    public static List<TeamSkeleton> GetAllTeams(){
        File mlbDb, nflDb, nbaDb, nhlDb;
        String currentDirectory = System.getProperty("user.dir");
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
        TeamSkeletonWrapper mlbTeams, nflTeams, nbaTeams, nhlTeams;
        try{
            mlbTeams = mapper.readValue(mlbDb, TeamSkeletonWrapper.class);
            nflTeams = mapper.readValue(nflDb, TeamSkeletonWrapper.class);
            nbaTeams = mapper.readValue(nbaDb, TeamSkeletonWrapper.class);
            nhlTeams = mapper.readValue(nhlDb, TeamSkeletonWrapper.class);
        }
        catch (IOException e){
            return null;
        }
        List<TeamSkeleton> allTeams = new ArrayList<>(nflTeams.getData());
        allTeams.addAll(nbaTeams.getData());
        allTeams.addAll(mlbTeams.getData());
        allTeams.addAll(nhlTeams.getData());
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
