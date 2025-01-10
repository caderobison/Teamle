package com.example.teamle.Teams;

import com.example.teamle.Teams.TeamSkeleton.TeamSkeleton;
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
