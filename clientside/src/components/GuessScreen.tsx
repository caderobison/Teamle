import {Col, Table} from "antd";
import React from "react";
import {ResultCard} from "./ResultCard/ResultCard";
import {AnswerType, Leagues} from "./ResultCard/ResultCardTypes";
import {LeagueResultCard} from "./ResultCard/LeagueResultCard/LeagueResultCard";
import {NumberChampionshipsCard} from "./ResultCard/NumberChampionshipsCard";

export function GuessTable() {
  const columns = [
    {
      title: "League",
      key: "league",
      render: () => <LeagueResultCard guess={Leagues.NBA} guessIsCorrect={false}/>,
    },
    {
      title: "Number of Championships",
      key: "championships",
      render: () => <NumberChampionshipsCard guess={7} distanceFromCorrect={2}/>,
    },
    {
      title: "Last Championship",
      key: "lastChampionship",
      render: () => <LeagueResultCard guess={Leagues.NBA} guessIsCorrect={false}/>,
    },
    {
      title: "Year founded",
      key: "foundedDate",
      render: () => <LeagueResultCard guess={Leagues.NBA} guessIsCorrect={false}/>,
    },
    {
      title: "State or Province",
      key: "state",
      render: () => <LeagueResultCard guess={Leagues.NBA} guessIsCorrect={false}/>,
    },
  ];
  const dataSource = [
    {
      key: "1",
      name: "Mike",
      age: 32,
      address: "10 Downing Street",
    },
    {
      key: "2",
      name: "John",
      age: 42,
      address: "10 Downing Street",
    },
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
