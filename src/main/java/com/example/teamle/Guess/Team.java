package com.example.teamle.Guess;

import com.example.teamle.Enums.TeamleEnums.Leagues;
import com.example.teamle.Enums.TeamleEnums.StatesAndProvinces.StatesAndProvinces;

public class Team {
    private int teamId;

    private String teamName;
    private Leagues league;
    private int numberChampionships;
    private int lastChampionship;
    private int yearFounded;
    private StatesAndProvinces state;

    public Team(int teamId, String teamName, Leagues league, int numberChampionships, int lastChampionship, int yearFounded, StatesAndProvinces state) {
        this.teamId = teamId;
        this.league = league;
        this.numberChampionships = numberChampionships;
        this.lastChampionship = lastChampionship;
        this.yearFounded = yearFounded;
        this.state = state;
        this.teamName = teamName;
    }

    public Leagues getLeague() {
        return league;
    }

    public void setLeague(Leagues league) {
        this.league = league;
    }

    public int getNumberChampionships() {
        return numberChampionships;
    }

    public void setNumberChampionships(int numberChampionships) {
        this.numberChampionships = numberChampionships;
    }

    public int getLastChampionship() {
        return lastChampionship;
    }

    public void setLastChampionship(int lastChampionship) {
        this.lastChampionship = lastChampionship;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public StatesAndProvinces getState() {
        return state;
    }

    public void setState(StatesAndProvinces state) {
        this.state = state;
    }
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
