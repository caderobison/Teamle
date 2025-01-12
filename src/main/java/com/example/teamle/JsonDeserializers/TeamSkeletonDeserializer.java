package com.example.teamle.JsonDeserializers;

import com.example.teamle.Teams.TeamSkeleton.TeamSkeleton;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeamSkeletonDeserializer extends JsonDeserializer<List<TeamSkeleton>> {
    @Override
    public List<TeamSkeleton> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        List<TeamSkeleton> teams = new ArrayList<>();
        ArrayNode data = (ArrayNode) node.get("data");
        for (JsonNode teamData: data) {
            int id = teamData.get("teamId").asInt();
            String name = teamData.get("teamName").asText();
            teams.add(new TeamSkeleton(id, name));
        }

        return teams;
    }
}
