package com.example.teamle.GuessTypes;

public class GuessResponse {
    private Leagues league;
    private boolean leagueCorrect;

    private int numberChampionships;
    private int numberChampionshipsDistance;

    private int lastChampionship;
    private int lastChampionshipDistance;

    private int yearFounded;
    private int yearFoundedDistance;

    private String state;
    private boolean stateCorrect;

    public Leagues getLeague() {
        return league;
    }

    public void setLeague(Leagues league) {
        this.league = league;
    }

    public boolean isLeagueCorrect() {
        return leagueCorrect;
    }

    public void setLeagueCorrect(boolean leagueCorrect) {
        this.leagueCorrect = leagueCorrect;
    }

    public int getNumberChampionships() {
        return numberChampionships;
    }

    public void setNumberChampionships(int numberChampionships) {
        this.numberChampionships = numberChampionships;
    }

    public int getNumberChampionshipsDistance() {
        return numberChampionshipsDistance;
    }

    public void setNumberChampionshipsDistance(int numberChampionshipsDistance) {
        this.numberChampionshipsDistance = numberChampionshipsDistance;
    }

    public int getLastChampionship() {
        return lastChampionship;
    }

    public void setLastChampionship(int lastChampionship) {
        this.lastChampionship = lastChampionship;
    }

    public int getLastChampionshipDistance() {
        return lastChampionshipDistance;
    }

    public void setLastChampionshipDistance(int lastChampionshipDistance) {
        this.lastChampionshipDistance = lastChampionshipDistance;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public int getYearFoundedDistance() {
        return yearFoundedDistance;
    }

    public void setYearFoundedDistance(int yearFoundedDistance) {
        this.yearFoundedDistance = yearFoundedDistance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isStateCorrect() {
        return stateCorrect;
    }

    public void setStateCorrect(boolean stateCorrect) {
        this.stateCorrect = stateCorrect;
    }
}
