package com.example.teamle.Guess.GuessTypes;

import com.example.teamle.Enums.TeamleEnums.AnswerTypes;
import com.example.teamle.Enums.TeamleEnums.Leagues;
import com.example.teamle.Enums.TeamleEnums.AnswerDirection;
import com.example.teamle.Enums.TeamleEnums.StatesAndProvinces.StatesAndProvinces;
import com.example.teamle.Guess.Team;
import org.yaml.snakeyaml.util.Tuple;

public class GuessResponse {
    private Leagues league;
    private AnswerTypes leagueAnswerType;

    private int numberChampionships;
    private AnswerTypes numberChampionshipsAnswerType;
    private AnswerDirection numberChampionshipsDirection;


    private int lastChampionship;
    private AnswerTypes lastChampionshipAnswerType;
    private AnswerDirection lastChampionshipDirection;


    private int yearFounded;
    private AnswerTypes yearFoundedAnswerType;
    private AnswerDirection yearFoundedDirection;

    private String state;
    private AnswerTypes stateAnswerType;

    // getters and setters

    //leagues
    public void setLeague(Leagues guessLeague, Leagues correctLeague) {
        this.league = guessLeague;
        this.leagueAnswerType = correctLeague == guessLeague ? AnswerTypes.CORRECT : AnswerTypes.WRONG;

    }

    public Leagues getLeague() {
        return league;
    }

    public AnswerTypes getLeagueAnswerType() {
        return leagueAnswerType;
    }


    //number championships
    public void setNumberChampionships(int guessNumberChampionships, int correctNumberChampionships) {
        this.numberChampionships = guessNumberChampionships;
        Tuple<AnswerTypes, AnswerDirection> result = calculateAnswerTypeAndDirection(guessNumberChampionships, correctNumberChampionships, GuessConstants.NUMBER_CHAMPIONSHIPS_NEARMAX);
        this.numberChampionshipsAnswerType = result._1();
        this.numberChampionshipsDirection = result._2();
    }

    public int getNumberChampionships() {
        return numberChampionships;
    }

    public AnswerTypes getNumberChampionshipsAnswerType() {
        return numberChampionshipsAnswerType;
    }

    public AnswerDirection getNumberChampionshipsDirection() {
        return numberChampionshipsDirection;
    }

    // last championship
    public void setLastChampionship(int guessLastChampionship, int correctLastChampionship) {
        this.numberChampionships = guessLastChampionship;
        Tuple<AnswerTypes, AnswerDirection> result = calculateAnswerTypeAndDirection(guessLastChampionship, correctLastChampionship, GuessConstants.LAST_CHAMPIONSHIPS_NEARMAX);
        this.lastChampionshipAnswerType = result._1();
        this.lastChampionshipDirection = result._2();
    }

    public int getLastChampionship() {
        return lastChampionship;
    }

    public AnswerTypes getLastChampionshipAnswerType() {
        return lastChampionshipAnswerType;
    }

    public AnswerDirection getLastChampionshipDirection() {
        return lastChampionshipDirection;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    // year founded
    public void setYearFounded(int guessYearFounded, int corectYearFounded) {
        this.yearFounded = guessYearFounded;
        Tuple<AnswerTypes, AnswerDirection> result = calculateAnswerTypeAndDirection(guessYearFounded, corectYearFounded, GuessConstants.YEAR_FOUNDED_NEARMAX);
        this.yearFoundedAnswerType = result._1();
        this.yearFoundedDirection = result._2();
    }

    public AnswerTypes getYearFoundedAnswerType() {
        return yearFoundedAnswerType;
    }

    public AnswerDirection getYearFoundedDirection() {
        return yearFoundedDirection;
    }

    // state
    public void setState(StatesAndProvinces guessState, StatesAndProvinces correctState) {
        this.state = guessState.toString();
        this.stateAnswerType = guessState == correctState ? AnswerTypes.CORRECT : AnswerTypes.WRONG;
    }

    public String getState() {
        return state;
    }

    public AnswerTypes getStateAnswerType() {
        return stateAnswerType;
    }

    // end getter and setter region

    public void teamGuessedCorrectly(){
        this.lastChampionshipAnswerType = AnswerTypes.CORRECT;
        this.numberChampionshipsAnswerType = AnswerTypes.CORRECT;
        this.yearFoundedAnswerType = AnswerTypes.CORRECT;
        this.leagueAnswerType = AnswerTypes.CORRECT;
        this.stateAnswerType = AnswerTypes.CORRECT;

        this.lastChampionshipDirection = AnswerDirection.CORRECT;
        this.numberChampionshipsDirection = AnswerDirection.CORRECT;
        this.yearFoundedDirection = AnswerDirection.CORRECT;
    }

    public void copyValuesFromTeam(Team t){
        this.numberChampionships = t.getNumberChampionships();
        this.lastChampionship = t.getLastChampionship();
        this.yearFounded = t.getYearFounded();
        this.state = t.getState().toString();
        this.league = t.getLeague();
    }

    //private functions

    private Tuple<AnswerTypes, AnswerDirection> calculateAnswerTypeAndDirection(int guess, int correct, int maxNearby){
        int distance = correct - guess;
        AnswerTypes answerType;
        if(distance == 0){
            return new Tuple<>(AnswerTypes.CORRECT, AnswerDirection.CORRECT);
        }
        answerType = Math.abs(distance) <= maxNearby ? AnswerTypes.NEAR : AnswerTypes.WRONG;
        if (distance < 0){
            return new Tuple<>(answerType, AnswerDirection.LOWER);
        }
        return new Tuple<>(answerType, AnswerDirection.HIGHER);
    }
}
