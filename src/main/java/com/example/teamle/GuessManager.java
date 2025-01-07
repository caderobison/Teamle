package com.example.teamle;

import com.example.teamle.GuessTypes.GuessResponse;
import com.example.teamle.GuessTypes.Leagues;
import com.example.teamle.GuessTypes.StatesAndProvinces.States;
import com.example.teamle.GuessTypes.Team;

public class GuessManager {
    public GuessResponse CompareTeams(int guessTeamId, int correctTeamId){
        GuessResponse response = new GuessResponse();
        Team correctTeam = GetTeam(correctTeamId);
        if(guessTeamId == correctTeamId){
            response.copyValuesFromTeam(correctTeam);
            response.teamGuessedCorrectly();
            return response;
        }
        Team guessTeam = GetTeam(guessTeamId);
        response.copyValuesFromTeam(guessTeam);
        response.setLeague(guessTeam.getLeague(), correctTeam.getLeague());
        response.setState(guessTeam.getState(), correctTeam.getState());
        response.setLastChampionship(guessTeam.getLastChampionship(), correctTeam.getLastChampionship());
        response.setNumberChampionships(guessTeam.getNumberChampionships(), correctTeam.getNumberChampionships());
        response.setYearFounded(guessTeam.getYearFounded(), correctTeam.getYearFounded());
        return response;
    }

    public Team GetTeam(int teamId){
        // not implemented
        return new Team(teamId, Leagues.NFL, 2, 1967, 1970, States.DC);
    }
}
