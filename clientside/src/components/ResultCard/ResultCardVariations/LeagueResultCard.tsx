import { AnswerType, IResultCardProps, Leagues } from "../ResultCardTypes";
import { ResultCard } from "../ResultCard";
import React from "react";

interface ILeagueResultCardProps extends IResultCardProps {
  guess: Leagues;
}
export function LeagueResultCard(props: ILeagueResultCardProps) {
  const getNameOfLeague = (guess: Leagues) => {
    switch (guess) {
      case Leagues.MLB:
        return "MLB";
      case Leagues.NBA:
        return "NBA";
      case Leagues.NFL:
        return "NFL";
      case Leagues.NHL:
        return "NHL";
      default:
        return "";
    }
  };
  const { answerType, guess } = props;
  return (
    <ResultCard answerType={answerType} guessText={getNameOfLeague(guess)} />
  );
}
