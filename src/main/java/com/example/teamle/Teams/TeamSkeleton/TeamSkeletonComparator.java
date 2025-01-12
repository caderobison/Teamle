package com.example.teamle.Teams.TeamSkeleton;

import java.util.Comparator;

public class TeamSkeletonComparator implements Comparator<TeamSkeleton> {
    @Override
    public int compare(TeamSkeleton o1, TeamSkeleton o2) {
        return o1.getTeamName().compareTo(o2.getTeamName());
    }
}
