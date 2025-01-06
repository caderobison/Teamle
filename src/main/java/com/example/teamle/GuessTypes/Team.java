package com.example.teamle.GuessTypes;

public class Team {
    private Leagues league;
    private int numberChampionships;
    private int lastChampionship;
    private int yearFounded;
    private States state;

    public Team(Leagues league, int numberChampionships, int lastChampionship, int yearFounded, States state) {
        this.league = league;
        this.numberChampionships = numberChampionships;
        this.lastChampionship = lastChampionship;
        this.yearFounded = yearFounded;
        this.state = state;
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

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }
}
