import {Col, Table} from "antd";
import React from "react";
import {ResultCard} from "./ResultCard/ResultCard";
import {AnswerType, Leagues} from "./ResultCard/ResultCardTypes";
import {LeagueResultCard} from "./ResultCard/LeagueResultCard/LeagueResultCard";
import {NumberChampionshipsCard} from "./ResultCard/NumberChampionshipsCard";
import {LastChampionshipCard} from "./ResultCard/LastChampionshipCard";
import {StateResultCard} from "./ResultCard/StateResultCard";

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
      render: () => <LastChampionshipCard guess={1967} distanceFromCorrect={3}/>,
    },
    {
      title: "Year founded",
      key: "foundedDate",
      render: () => <NumberChampionshipsCard guess={1923} distanceFromCorrect={2}/>,
    },
    {
      title: "State or Province",
      key: "state",
      render: () => <StateResultCard guess={"Michigan"} guessIsCorrect={false}/>,
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
