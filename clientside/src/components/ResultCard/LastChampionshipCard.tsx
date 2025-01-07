import React from "react";
import {AnswerType, CaluclateDirectionFromNumber, INumberResultCardProps} from "./ResultCardTypes";
import {NearbyValues} from "./ResultCardConstants";
import {ResultCard} from "./ResultCard";

interface ILastChampionshipCardProps extends INumberResultCardProps{
    guess: number
}
export function LastChampionshipCard (props: ILastChampionshipCardProps) {
    const {distanceFromCorrect, guess} = props
    const getAnswerType = (guess : number) : AnswerType => {
        if (distanceFromCorrect === 0){
            return AnswerType.Correct;
        }
        if (Math.abs(distanceFromCorrect) <= NearbyValues.LATEST_CHAMPIONSHIP){
            return AnswerType.Near;
        }
        return AnswerType.Wrong;
    }
    const answerType = getAnswerType(guess)
    return <ResultCard answerType={answerType} guessText={guess.toString()} directionToAnswer={CaluclateDirectionFromNumber(guess)}/>

}