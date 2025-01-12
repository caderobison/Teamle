package com.example.teamle.Teams;

import com.example.teamle.JsonDeserializers.TeamSkeletonDeserializer;
import com.example.teamle.Teams.TeamSkeleton.TeamSkeleton;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class TeamsManager {
    public static List<TeamSkeleton> GetAllTeams(){
        return TeamsEngine.GetAllTeams();
    }
}
