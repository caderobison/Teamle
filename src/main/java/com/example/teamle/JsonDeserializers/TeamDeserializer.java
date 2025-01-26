package com.example.teamle.JsonDeserializers;

import com.example.teamle.Enums.TeamleEnums.Leagues;
import com.example.teamle.Enums.TeamleEnums.StatesAndProvinces.StatesAndProvinces;
import com.example.teamle.Guess.Team;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class TeamDeserializer extends JsonDeserializer<Team> {

    private final int teamId;
    private final Leagues league;

    public TeamDeserializer(int teamId, Leagues league){
        this.teamId = teamId;
        this.league = league;
    }
    @Override
    public Team deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        ArrayNode data = (ArrayNode) node.get("data");
        List<JsonNode> jsonTeams = data.findParents("teamId");
        Optional<JsonNode> selectedTeam = jsonTeams.stream().filter(n -> n.get("teamId").asInt() == this.teamId).findFirst();
        return DeserializerUtility.GetTeam(selectedTeam.orElse(null), league, teamId);
    }

}
