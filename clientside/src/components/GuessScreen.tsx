import {Col, Table} from "antd";
import React from "react";
import {ResultCard} from "./ResultCard/ResultCard";
import {AnswerType} from "./ResultCard/AnswerType";

export function GuessTable() {
  const columns = [
    {
      title: "League",
      key: "league",
      render: () => <ResultCard answerType={AnswerType.Near}/>,
    },
    {
      title: "State",
      key: "state",
      render: () => <ResultCard answerType={AnswerType.Near}/>,
    },
    {
      title: "Distance",
      key: "distance",
      render: () => <ResultCard answerType={AnswerType.Near}/>,
    },
    {
      title: "Card",
      key: "card",
      render: () => <ResultCard answerType={AnswerType.Near}/>,
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
