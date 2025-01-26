package com.example.teamle.Teams;

import com.example.teamle.Championships.ChampionshipsEngine;
import com.example.teamle.Enums.TeamleEnums.Leagues;
import com.example.teamle.Teams.TeamSkeleton.TeamSkeleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TeamsManager {
    public static List<TeamSkeleton> GetAllTeams(){
        return TeamsEngine.GetAllTeams();
    }

    public static void UpdateLeagueChampionships(Leagues league){
        String dbPath = TeamsEngine.GetLeagueDbPath(league);
        File db;
        try {
            db = TeamsEngine.GetDBFile(dbPath);
        }
        catch (FileNotFoundException e){
            return;
        }
        ChampionshipsEngine.UpdateLeague(db, league);
    }

    public static void UpdateAllLeagueChampionships(){
        List<Callable<Void>> futures = new ArrayList<>();
        futures.add(() -> {UpdateLeagueChampionships(Leagues.NFL); return null;});
        futures.add(() -> {UpdateLeagueChampionships(Leagues.MLB); return null;});
        futures.add(() -> {UpdateLeagueChampionships(Leagues.NBA); return null;});
        futures.add(() -> {UpdateLeagueChampionships(Leagues.NHL); return null;});
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            executorService.invokeAll(futures);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


