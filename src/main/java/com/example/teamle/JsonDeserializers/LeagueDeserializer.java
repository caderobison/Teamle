package com.example.teamle.JsonDeserializers;

import com.example.teamle.Enums.TeamleEnums.Leagues;
import com.example.teamle.Guess.Team;
import com.example.teamle.Teams.TeamSkeleton.TeamSkeleton;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeagueDeserializer extends JsonDeserializer<List<Team>> {

    private Leagues league;
    public LeagueDeserializer(Leagues league){
        this.league = league;
    }

    @Override
    public List<Team> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        List<Team> teams = new ArrayList<>();
        ArrayNode data = (ArrayNode) node.get("data");
        for (JsonNode teamData: data) {
            teams.add(DeserializerUtility.GetTeam(teamData, league, null));
        }
        return teams;
    }
}
