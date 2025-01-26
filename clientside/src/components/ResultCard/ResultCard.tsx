import { Card } from "antd";
import React from "react";
import "./ResultCard.css";
import classNames from "classnames";
import { AnswerDirection, AnswerType } from "./ResultCardTypes";
import { CaretDownOutlined, CaretUpOutlined } from "@ant-design/icons";

interface IResultCardProps {
  answerType: AnswerType;
  directionToAnswer?: AnswerDirection;
  guessText: string;
}
export function ResultCard(props: IResultCardProps) {
  const { answerType, guessText } = props;
  const colorClass = classNames("big-circle", {
    "correct-answer": answerType === AnswerType.Correct,
    "wrong-answer": answerType === AnswerType.Wrong,
    "near-answer": answerType === AnswerType.Near,
  });

  const renderCorrectArrow = () => {
    if (props.directionToAnswer === AnswerDirection.Higher) {
      return <CaretUpOutlined style={{ alignContent: "center" }} />;
    }
    if (props.directionToAnswer === AnswerDirection.Lower) {
      return <CaretDownOutlined style={{ alignContent: "center" }} />;
    }
  };
  return (
    <Card className={colorClass}>
      <div className={"card-body"}>
        <div className={"card-body card-arrow"}>{renderCorrectArrow()}</div>
        <div className={"card-body card-number"}>{guessText}</div>
        <div className={"card-body card-arrow"}>{renderCorrectArrow()} </div>
      </div>
    </Card>
  );
}
