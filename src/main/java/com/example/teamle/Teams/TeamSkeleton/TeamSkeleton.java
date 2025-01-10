package com.example.teamle.Teams.TeamSkeleton;

public class TeamSkeleton {
    private int teamId;
    private String teamName;


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
