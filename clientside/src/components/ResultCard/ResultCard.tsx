import {Card} from "antd";
import React from "react";
import "./ResultCard.css"
import classNames from "classnames";
import {AnswerType, DirectionToAnswer} from "./ResultCardTypes";

interface IResultCardProps {
  answerType : AnswerType
  directionToAnswer?: DirectionToAnswer
  guessText: string
}
export function ResultCard(props : IResultCardProps) {
  const {answerType, guessText} = props;
  const colorClass = classNames('big-circle', {
    'correct-answer': answerType === AnswerType.Correct,
    'wrong-answer': answerType === AnswerType.Wrong,
    'near-answer': answerType === AnswerType.Near,
  });
  return <Card className={colorClass}>{guessText}</Card>;
}
