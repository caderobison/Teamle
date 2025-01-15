import {
  GuessResponse,
  IDataRowProps,
  IGuessDataRowProps,
} from "./GuessScreenTypes";
import { LeagueResultCard } from "../ResultCard/ResultCardVariations/LeagueResultCard";
import { NumberResultCard } from "../ResultCard/ResultCardVariations/NumberResultCard";
import { StateResultCard } from "../ResultCard/ResultCardVariations/StateResultCard";
import React, { useEffect, useState } from "react";
import { Table, TableProps } from "antd";
import classNames from "classnames";
import "./GuessTable.css";

interface IGuessTableProps {
  guessData: GuessResponse[];
}

class GuessTableState {
  dataRows: IDataRowProps[];
  titleRowKeys: string[];
}

export function GuessTable(props: IGuessTableProps) {
  const [state, setState] = useState<GuessTableState>({
    dataRows: [],
    titleRowKeys: [],
  });
  const columns = [
    {
      title: "League",
      key: "league",
      render: (record: IGuessDataRowProps) =>
        !record.isTitle && (
          <LeagueResultCard
            guess={record.league}
            answerType={record.leagueAnswerType}
          />
        ),
    },
    {
      title: "Number of Championships",
      key: "championships",
      render: (record: IGuessDataRowProps) =>
        !record.isTitle && (
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
      render: (record: IGuessDataRowProps) =>
        !record.isTitle && (
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
      render: (record: IGuessDataRowProps) =>
        !record.isTitle && (
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
      render: (record: IGuessDataRowProps) =>
        !record.isTitle && (
          <StateResultCard
            guess={record.state}
            answerType={record.stateAnswerType}
          />
        ),
    },
  ];

  useEffect(() => {
    const newGuessIndex = props.guessData.length - 1;
    const newGuess = props.guessData[newGuessIndex];
    if (newGuess) {
      const newTitle = {
        key: `${newGuessIndex.toString()}-expanded`,
        isTitle: true,
        teamName: newGuess.teamName,
      } as IDataRowProps;
      const guessRow = {
        key: newGuessIndex.toString(),
        league: newGuess.league,
        leagueAnswerType: newGuess.leagueAnswerType,

        state: newGuess.state,
        stateAnswerType: newGuess.stateAnswerType,

        numberChampionships: newGuess.numberChampionships,
        numberChampionshipsAnswerType: newGuess.numberChampionshipsAnswerType,
        numberChampionshipsDirection: newGuess.numberChampionshipsDirection,

        lastChampionship: newGuess.lastChampionship,
        lastChampionshipAnswerType: newGuess.lastChampionshipAnswerType,
        lastChampionshipDirection: newGuess.lastChampionshipDirection,

        yearFounded: newGuess.yearFounded,
        yearFoundedAnswerType: newGuess.yearFoundedAnswerType,
        yearFoundedDirection: newGuess.yearFoundedDirection,
        isTitle: false,
      } as IGuessDataRowProps;
      setState((prevState) => ({
        ...prevState,
        dataRows: [...prevState.dataRows, newTitle, guessRow],
        titleRowKeys: [...prevState.titleRowKeys, newTitle.key],
      }));
    }
  }, [props.guessData]);

  const expandableProps: TableProps<IDataRowProps>["expandable"] = {
    expandedRowRender: (record: IDataRowProps) => {
      return (
        <div className={"team-title"}>
          <h3>{record.teamName}</h3> {/* Display username above the row */}
        </div>
      );
    },
    rowExpandable: (_record: IDataRowProps) => true,
    expandedRowKeys: state.titleRowKeys,
    expandedRowClassName: "title-row",
    onExpand: () => {},
    showExpandColumn: false,
  };

  const customClass = classNames("hidden-row");

  return (
    <>
      <Table
        dataSource={state.dataRows}
        columns={columns}
        tableLayout="fixed"
        pagination={false}
        locale={{ emptyText: null }}
        expandable={expandableProps}
        rowClassName={(record) => (record.isTitle ? "hidden-row" : "")}
      />
    </>
  );
}
