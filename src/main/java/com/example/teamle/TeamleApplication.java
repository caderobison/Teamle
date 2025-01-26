package com.example.teamle;

import com.example.teamle.Championships.ChampionshipsEngine;
import com.example.teamle.Enums.TeamleEnums.Leagues;
import com.example.teamle.Teams.TeamsEngine;
import com.example.teamle.Teams.TeamsManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TeamleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamleApplication.class, args);
    }

}
