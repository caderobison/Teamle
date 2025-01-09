import {AnswerType, AnswerDirection, Leagues} from "../ResultCard/ResultCardTypes";

export interface IGuessDataRowProps extends IGuessResponseProps{
    key: string;

    league: Leagues;
    leagueAnswerType: AnswerType;

    state: string;
    stateAnswerType: AnswerType;

    numberChampionships : number;
    numberChampionshipsAnswerType : AnswerType;
    numberChampionshipsDirection : AnswerDirection;

    lastChampionship : number;
    lastChampionshipAnswerType : AnswerType;
    lastChampionshipDirection : AnswerDirection;

    yearFounded : number;
    yearFoundedAnswerType : AnswerType;
    yearFoundedDirection : AnswerDirection;
}

export interface IGuessResponseProps {
    league: Leagues;
    leagueAnswerType: AnswerType;

    state: string;
    stateAnswerType: AnswerType;

    numberChampionships : number;
    numberChampionshipsAnswerType : AnswerType;
    numberChampionshipsDirection : AnswerDirection;

    lastChampionship : number;
    lastChampionshipAnswerType : AnswerType;
    lastChampionshipDirection : AnswerDirection;

    yearFounded : number;
    yearFoundedAnswerType : AnswerType;
    yearFoundedDirection : AnswerDirection;
}

export class GuessResponse{
    constructor(data: Partial<IGuessResponseProps>) {
        this.league =  data.league;
        this.leagueAnswerType = data.leagueAnswerType;

        this.state = data.state;
        this.stateAnswerType = data.stateAnswerType;

        this.numberChampionships = data.numberChampionships;
        this.numberChampionshipsAnswerType = data.numberChampionshipsAnswerType;
        this.numberChampionshipsDirection = data.numberChampionshipsDirection;

        this.lastChampionship = data.lastChampionship;
        this.lastChampionshipAnswerType = data.lastChampionshipAnswerType;
        this.lastChampionshipDirection = data.lastChampionshipDirection;

        this.yearFounded = data.yearFounded;
        this.yearFoundedAnswerType = data.yearFoundedAnswerType;
        this.yearFoundedDirection = data.yearFoundedDirection;
    }
    league: Leagues;
    leagueAnswerType: AnswerType;

    state: string;
    stateAnswerType: AnswerType;

    numberChampionships : number;
    numberChampionshipsAnswerType : AnswerType;
    numberChampionshipsDirection : AnswerDirection;

    lastChampionship : number;
    lastChampionshipAnswerType : AnswerType;
    lastChampionshipDirection : AnswerDirection;

    yearFounded : number;
    yearFoundedAnswerType : AnswerType;
    yearFoundedDirection : AnswerDirection;
}