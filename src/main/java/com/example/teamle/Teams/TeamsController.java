package com.example.teamle.Teams;

import com.example.teamle.Guess.GuessManager;
import com.example.teamle.Guess.GuessTypes.GuessResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamsController {

    @GetMapping("/allTeams")
    @ResponseBody
    public List<TeamSkeleton> GetAllTeams(){
        return TeamsManager.GetAllTeams();
    }
}
