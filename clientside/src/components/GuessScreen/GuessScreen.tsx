import {Col, Table} from "antd";
import React from "react";
import {ResultCard} from "../ResultCard/ResultCard";
import {AnswerType, Leagues} from "../ResultCard/ResultCardTypes";
import {LeagueResultCard} from "../ResultCard/LeagueResultCard/LeagueResultCard";
import {NumberChampionshipsCard} from "../ResultCard/NumberChampionshipsCard";
import {LastChampionshipCard} from "../ResultCard/LastChampionshipCard";
import {StateResultCard} from "../ResultCard/StateResultCard";
import {DataRowProps} from "./GuessScreenTypes";

export function GuessTable() {
  const columns = [
    {
      title: "League",
      key: "league",
      render: (record: DataRowProps) => <LeagueResultCard guess={record.league} guessIsCorrect={record.leagueCorrect}/>,
    },
    {
      title: "Number of Championships",
      key: "championships",
      render: (record : DataRowProps) => <NumberChampionshipsCard guess={record.numberChampionships} distanceFromCorrect={record.numberChampionshipsDistance}/>,
    },
    {
      title: "Last Championship",
      key: "lastChampionship",
      render: (record : DataRowProps) => <LastChampionshipCard guess={record.lastChampionship} distanceFromCorrect={record.lastChampionshipDistance}/>,
    },
    {
      title: "Year founded",
      key: "foundedDate",
      render: (record : DataRowProps) => <NumberChampionshipsCard guess={record.yearFounded} distanceFromCorrect={record.yearFoundedDistance}/>,
    },
    {
      title: "State or Province",
      key: "state",
      render: (record : DataRowProps) => <StateResultCard guess={record.state} guessIsCorrect={record.stateCorrect}/>,
    },
  ];
  const dataSource = [
    {
      key: "1",
      league: Leagues.MLB,
      leagueCorrect: true,
      lastChampionship: 1967,
      lastChampionshipDistance: 8,
      numberChampionships: 1,
      numberChampionshipsDistance: 3,
      yearFounded: 1923,
      yearFoundedDistance: 12,
      state: "Wisconsin",
      stateCorrect: false
    } as DataRowProps,
  ];
  return (
    <Col span={16} offset={4}>
      <Table
        dataSource={dataSource}
        columns={columns}
        tableLayout="fixed"
        pagination={false}
      />
    </Col>
  );
}
