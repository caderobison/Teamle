import React from "react";
import {AnswerType, IResultCardProps} from "../ResultCardTypes";
import {ResultCard} from "../ResultCard";

interface IStateResultCardProps extends IResultCardProps{
    guess: string
}
export function StateResultCard (props: IStateResultCardProps) {
    const {answerType, guess} = props
    return <ResultCard answerType={answerType} guessText={guess} />
}