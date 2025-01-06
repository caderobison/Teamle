import React from "react";
import {AnswerType, CaluclateDirectionFromNumber, INumberResultCardProps} from "./ResultCardTypes";
import {NearbyValues} from "./ResultCardConstants";
import {ResultCard} from "./ResultCard";

interface IYearFoundedProps extends INumberResultCardProps{
    guess: number
}
export function YearFoundedCard (props: IYearFoundedProps) {
    const {distanceFromCorrect, guess} = props
    const getAnswerType = (guess : number) : AnswerType => {
        if (distanceFromCorrect === 0){
            return AnswerType.Correct;
        }
        if (Math.abs(distanceFromCorrect) <= NearbyValues.YEAR_FOUNDED){
            return AnswerType.Near;
        }
        return AnswerType.Wrong;
    }
    const answerType = getAnswerType(guess)
    return <ResultCard answerType={answerType} guessText={guess.toString()} directionToAnswer={CaluclateDirectionFromNumber(guess)}/>

}