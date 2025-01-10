package com.example.teamle.Guess;
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