package com.example.teamle.Guess;
import com.example.teamle.Guess.GuessTypes.GuessResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guess")
public class GuessController {

    @PostMapping("/{teamId}")
    @ResponseBody
    public GuessResponse CompareGuess(@PathVariable int teamId){
        return GuessManager.CalculateGuessValues(teamId);
    }
}