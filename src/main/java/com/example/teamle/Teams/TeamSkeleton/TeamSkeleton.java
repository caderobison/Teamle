package com.example.teamle.Teams.TeamSkeleton;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class TeamSkeleton {
    private int teamId;
    private String teamName;

    private int yearFounded;

    public int getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public TeamSkeleton(int teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public TeamSkeleton(){
        teamId = 0;
        teamName = "NO NAME";
    }
}
