package com.example.teamle.Teams;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

public class TeamSkeleton {
    private int TeamId;
    private String TeamName;

    @JsonDeserialize(using = CommentIgnoringDeserializer.class) // Custom deserializer
    private String Comment;

    public int getTeamId() {
        return TeamId;
    }

    public String getTeamName() {
        return TeamName;
    }

    public TeamSkeleton(int teamId, String teamName) {
        TeamId = teamId;
        TeamName = teamName;
    }

    private class CommentIgnoringDeserializer extends JsonDeserializer<String> {
        @Override
        public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            // Ignore the "Comment" field
            return null;
        }
    }
}
