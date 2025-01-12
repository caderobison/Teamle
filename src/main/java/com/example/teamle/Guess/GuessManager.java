package com.example.teamle.Guess;

import com.example.teamle.Enums.TeamleEnums.Leagues;
import com.example.teamle.Enums.TeamleEnums.StatesAndProvinces.States;
import com.example.teamle.Teams.TeamsEngine;

public class GuessManager {
    public static GuessResponse CalculateGuessValues(int guessTeamId){
        GuessResponse response = new GuessResponse();
        Team correctTeam = GetCorrectTeam();
        if(guessTeamId == correctTeam.getTeamId()){
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

    private static Team GetTeam(int teamId){
        return TeamsEngine.GetTeam(teamId);
    }

    private static Team GetCorrectTeam(){
        return new Team(1, "Detroit Lions", Leagues.NFL, 0, 0, 1928, States.MICHIGAN);
    }
}
