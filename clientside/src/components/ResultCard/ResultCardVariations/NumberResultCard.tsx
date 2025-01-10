import React from "react";
import { INumberResultCardProps } from "../ResultCardTypes";
import { ResultCard } from "../ResultCard";

export function NumberResultCard(props: INumberResultCardProps) {
  const { guess, answerType, answerDirection } = props;
  return (
    <ResultCard
      answerType={answerType}
      guessText={guess.toString()}
      directionToAnswer={answerDirection}
    />
  );
}
