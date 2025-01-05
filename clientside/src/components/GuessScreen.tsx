import { Col, Table } from "antd";
import React from "react";
import Column from "antd/es/table/Column";

export function GuessTable() {
  const columns = [
    {
      title: "Name",
      dataIndex: "name",
      key: "name",
    },
    {
      title: "Age",
      dataIndex: "age",
      key: "age",
    },
    {
      title: "Address",
      dataIndex: "address",
      key: "address",
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
