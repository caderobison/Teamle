import React from "react";
import {AnswerType, IEnumResultCardProps} from "./ResultCardTypes";
import {ResultCard} from "./ResultCard";

interface IStateResultCardProps extends IEnumResultCardProps{
    guess: string
}
export function StateResultCard (props: IStateResultCardProps) {
    const {guessIsCorrect, guess} = props
    const answerType = guessIsCorrect ? AnswerType.Correct : AnswerType.Wrong
    return <ResultCard answerType={answerType} guessText={guess} />

}