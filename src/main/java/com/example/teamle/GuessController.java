package com.example.teamle;
import com.example.teamle.GuessTypes.GuessResponse;
import com.example.teamle.GuessTypes.Leagues;
import com.example.teamle.GuessTypes.StatesAndProvinces.States;
import com.example.teamle.GuessTypes.Team;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guess")
public class GuessController {

    @PostMapping("/{teamId}")
    @ResponseBody
    public GuessResponse CompareGuess(@PathVariable int teamId){
        GuessResponse g = new GuessResponse();
        Team t = new Team(Leagues.MLB, 1, 1988, 1912, States.ALASKA);

        return g;
    }
}