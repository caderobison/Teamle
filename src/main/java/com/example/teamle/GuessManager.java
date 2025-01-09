package com.example.teamle;

import com.example.teamle.GuessTypes.GuessResponse;
import com.example.teamle.Enums.TeamleEnums.Leagues;
import com.example.teamle.Enums.TeamleEnums.StatesAndProvinces.States;
import com.example.teamle.GuessTypes.Team;

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

    public static Team GetTeam(int teamId){
        // not implemented
        return new Team(teamId, Leagues.NFL, 2, 1967, 1970, States.NEW_JERSEY);
    }

    public static Team GetCorrectTeam(){
        return new Team(1, Leagues.NFL, 0, 0, 1928, States.MICHIGAN);
    }
}
