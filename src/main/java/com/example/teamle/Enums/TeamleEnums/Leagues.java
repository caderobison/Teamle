package com.example.teamle.Enums.TeamleEnums;

import com.example.teamle.Enums.TeamleEnum;

public enum Leagues implements TeamleEnum {
    NFL(0),
    NBA(1),
    MLB(2),
    NHL(3);

    private final int leagueValue;
    Leagues(int i) {
        this.leagueValue = i;
    }

    @Override
    public int getEnumValue() {
        return leagueValue;
    }
}
