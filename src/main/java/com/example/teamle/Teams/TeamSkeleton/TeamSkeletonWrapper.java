package com.example.teamle.Teams.TeamSkeleton;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.util.List;

public class TeamSkeletonWrapper {
    @JsonDeserialize(using = CommentIgnoringDeserializer.class) // Custom deserializer
    private String comment;
    private List<TeamSkeleton> data;

    public List<TeamSkeleton> getData() {
        return data;
    }


    private static class CommentIgnoringDeserializer extends JsonDeserializer<String> {
        CommentIgnoringDeserializer() {
            super();
        }

        @Override
        public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            // Ignore the "Comment" field
            return null;
        }
    }
}
