import {Card} from "antd";
import React from "react";
import "./ResultCard.css"
import classNames from "classnames";
import {AnswerType} from "./AnswerType";

class ResultCardProps {
  answerType : AnswerType
}
export function ResultCard(props : ResultCardProps) {
  const {answerType} = props;
  // let colorClass : string = "big-circle"
  // if (answerType === AnswerType.Correct){
  //   colorClass += "correct-answer";
  // }
  // else if (answerType === AnswerType.Wrong){
  //   colorClass += "wrong-answer";
  // }
  // else if (answerType === AnswerType.Near){
  //   colorClass += "near-answer";
  // }
  const colorClass = classNames('big-circle', {
    'correct-answer': answerType === AnswerType.Correct,
    'wrong-answer': answerType === AnswerType.Wrong,
    'near-answer': answerType === AnswerType.Near,
  });
  return <Card className={colorClass}>Hello</Card>;
}
