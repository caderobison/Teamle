import {AnswerType, IEnumResultCardProps, Leagues} from "../ResultCardTypes";
import {ResultCard} from "../ResultCard";
import React from "react";

interface ILeagueResultCardProps extends IEnumResultCardProps{
    guess: Leagues
}
export function LeagueResultCard (props: ILeagueResultCardProps) {
    const getNameOfLeague = (guess: Leagues) => {
        switch (guess){
            case Leagues.MLB:
                return "MLB";
            case Leagues.NBA:
                return "NBA";
            case Leagues.NFL:
                return "NFL";
            case Leagues.NHL:
                return "NHL";
            default:
                return ""
        }
    }
    const {guessIsCorrect, guess} = props
    const answerType = guessIsCorrect ? AnswerType.Correct : AnswerType.Wrong
    return <ResultCard answerType={answerType} guessText={getNameOfLeague(guess)} />

}