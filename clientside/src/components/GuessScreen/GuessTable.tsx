import { GuessResponse, IGuessDataRowProps } from "./GuessScreenTypes";
import { LeagueResultCard } from "../ResultCard/ResultCardVariations/LeagueResultCard";
import { NumberResultCard } from "../ResultCard/ResultCardVariations/NumberResultCard";
import { StateResultCard } from "../ResultCard/ResultCardVariations/StateResultCard";
import React, { useEffect, useState } from "react";
import { Col, Table } from "antd";

interface IGuessTableProps {
  guessData: GuessResponse[];
}

class GuessTableState {
  dataRows: IGuessDataRowProps[];
}

export function GuessTable(props: IGuessTableProps) {
  const [state, setState] = useState<GuessTableState>({ dataRows: [] });
  const columns = [
    {
      title: "League",
      key: "league",
      render: (record: IGuessDataRowProps) => (
        <LeagueResultCard
          guess={record.league}
          answerType={record.leagueAnswerType}
        />
      ),
    },
    {
      title: "Number of Championships",
      key: "championships",
      render: (record: IGuessDataRowProps) => (
        <NumberResultCard
          guess={record.numberChampionships}
          answerType={record.numberChampionshipsAnswerType}
          answerDirection={record.numberChampionshipsDirection}
        />
      ),
    },
    {
      title: "Last Championship",
      key: "lastChampionship",
      render: (record: IGuessDataRowProps) => (
        <NumberResultCard
          guess={record.lastChampionship}
          answerType={record.lastChampionshipAnswerType}
          answerDirection={record.lastChampionshipDirection}
        />
      ),
    },
    {
      title: "Year founded",
      key: "foundedDate",
      render: (record: IGuessDataRowProps) => (
        <NumberResultCard
          guess={record.yearFounded}
          answerType={record.yearFoundedAnswerType}
          answerDirection={record.yearFoundedDirection}
        />
      ),
    },
    {
      title: "State or Province",
      key: "state",
      render: (record: IGuessDataRowProps) => (
        <StateResultCard
          guess={record.state}
          answerType={record.stateAnswerType}
        />
      ),
    },
  ];

  useEffect(() => {
    const rows = props.guessData.map((g, index) => {
      return {
        key: index.toString(),
        league: g.league,
        leagueAnswerType: g.leagueAnswerType,

        state: g.state,
        stateAnswerType: g.stateAnswerType,

        numberChampionships: g.numberChampionships,
        numberChampionshipsAnswerType: g.numberChampionshipsAnswerType,
        numberChampionshipsDirection: g.numberChampionshipsDirection,

        lastChampionship: g.lastChampionship,
        lastChampionshipAnswerType: g.lastChampionshipAnswerType,
        lastChampionshipDirection: g.lastChampionshipDirection,

        yearFounded: g.yearFounded,
        yearFoundedAnswerType: g.yearFoundedAnswerType,
        yearFoundedDirection: g.yearFoundedDirection,
      } as IGuessDataRowProps;
    });
    setState((prevState) => ({ ...prevState, dataRows: rows }));
  }, [props.guessData]);

  return (
    <Table
      dataSource={state.dataRows}
      columns={columns}
      tableLayout="fixed"
      pagination={false}
    />
  );
}
