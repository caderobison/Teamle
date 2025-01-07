package com.example.teamle.GuessTypes;

public enum Leagues {
    NFL(0),
    NBA(1),
    MLB(2),
    NHL(3);

    private final int leagueValue;
    Leagues(int i) {
        this.leagueValue = i;
    }

    public int getLeagueValue() {
        return leagueValue;
    }
}
