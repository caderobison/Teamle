package com.example.teamle.JsonDeserializers;

import com.example.teamle.Guess.Team;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class TeamSerializer extends StdSerializer<Team> {
    protected TeamSerializer(Class<Team> t) {
        super(t);
    }

    public TeamSerializer() {
        this(null);
    }

    @Override
    public void serialize(Team team, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("teamId", String.valueOf(team.getTeamId()));
        jsonGenerator.writeStringField("teamName", team.getTeamName());
        jsonGenerator.writeStringField("yearFounded", String.valueOf(team.getYearFounded()));
        jsonGenerator.writeStringField("stateId", String.valueOf(team.getState().getEnumValue()));
        jsonGenerator.writeStringField("numberOfChampionships", String.valueOf(team.getNumberChampionships()));
        jsonGenerator.writeStringField("lastChampionship", String.valueOf(team.getLastChampionship()));
        jsonGenerator.writeEndObject();
    }
}
