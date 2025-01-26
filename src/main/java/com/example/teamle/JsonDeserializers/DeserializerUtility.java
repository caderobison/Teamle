package com.example.teamle.JsonDeserializers;

import com.example.teamle.Enums.TeamleEnums.Leagues;
import com.example.teamle.Enums.TeamleEnums.StatesAndProvinces.StatesAndProvinces;
import com.example.teamle.Guess.Team;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Optional;

public class DeserializerUtility {

    public static Team GetTeam(JsonNode selectedTeam, Leagues league, Integer teamId){
        if (selectedTeam != null){
            int stateId = selectedTeam.get("stateId").asInt();
            Class<? extends StatesAndProvinces> stateClass = StatesAndProvinces.getCorrectType(stateId);
            StatesAndProvinces state;
            try {
                state = (StatesAndProvinces) stateClass.getMethod("getStateOrProvinceFromValue", int.class).invoke(null, stateId);
            } catch (Exception e){
                state = null;
            }
            int numberOfChampionships = selectedTeam.has("numberOfChampionships") ? selectedTeam.get("numberOfChampionships").asInt(0) : 0;
            int lastChampionship = selectedTeam.has("lastChampionship") ? selectedTeam.get("lastChampionship").asInt(0) : 0;
            return new Team(
                    teamId == null ? selectedTeam.get("teamId").asInt() : teamId,
                    selectedTeam.get("teamName").asText(),
                    league,
                    numberOfChampionships, //TODO: implement NumberChips
                    lastChampionship,  //TODO: implement lastChip
                    selectedTeam.get("yearFounded").asInt(),
                    state);
        }
        return null;
    }
}
