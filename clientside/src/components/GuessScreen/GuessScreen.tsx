import {Col, Table} from "antd";
import React, {useEffect, useState} from "react";
import {LeagueResultCard} from "../ResultCard/ResultCardVariations/LeagueResultCard";
import {NumberResultCard} from "../ResultCard/ResultCardVariations/NumberResultCard";
import {StateResultCard} from "../ResultCard/ResultCardVariations/StateResultCard";
import {GuessResponse, IGuessDataRowProps, TeamSkeleton} from "./GuessScreenTypes";
import {GuessHandler} from "../../Handlers/GuessHandler";
import {TeamsHandler} from "../../Handlers/TeamsHandler";

class GuessTableState{
  constructor() {
    this.response = null;
    this.allTeams = null
  }
  response : GuessResponse | null;
  allTeams : TeamSkeleton[] | null;
}

export function GuessTable() {

  const[state, setState] = useState<GuessTableState>(new GuessTableState())
  const getData = async () => {
    const handler = new GuessHandler();
    const resp = await handler.compareGuess(3);
    setState((prevState) => ({
      ...prevState,
      response: resp,
    }));
  }

  const getAllTeams = async () => {
    const handler = new TeamsHandler();
    const resp = await handler.getAllTeams();
    setState((prevState) => ({
      ...prevState,
      allTeams: resp,
    }));
  }

  useEffect(() => {
    getData();
    getAllTeams();
  }, [])

  const columns = [
    {
      title: "League",
      key: "league",
      render: (record: IGuessDataRowProps) => <LeagueResultCard guess={record.league} answerType={record.leagueAnswerType}/>,
    },
    {
      title: "Number of Championships",
      key: "championships",
      render: (record : IGuessDataRowProps) => <NumberResultCard guess={record.numberChampionships} answerType={record.numberChampionshipsAnswerType} answerDirection={record.numberChampionshipsDirection}/>,
    },
    {
      title: "Last Championship",
      key: "lastChampionship",
      render: (record : IGuessDataRowProps) => <NumberResultCard guess={record.lastChampionship} answerType={record.lastChampionshipAnswerType} answerDirection={record.lastChampionshipDirection}/>,
    },
    {
      title: "Year founded",
      key: "foundedDate",
      render: (record : IGuessDataRowProps) => <NumberResultCard guess={record.yearFounded} answerType={record.yearFoundedAnswerType} answerDirection={record.yearFoundedDirection}/>,
    },
    {
      title: "State or Province",
      key: "state",
      render: (record : IGuessDataRowProps) => <StateResultCard guess={record.state} answerType={record.stateAnswerType}/>,
    },
  ];
if(state.response) {

  const dataSource = [
    {
      key: "1",
      league: state.response.league,
      leagueAnswerType: state.response.leagueAnswerType,

      state: state.response.state,
      stateAnswerType: state.response.stateAnswerType,

      numberChampionships: state.response.numberChampionships,
      numberChampionshipsAnswerType: state.response.numberChampionshipsAnswerType,
      numberChampionshipsDirection: state.response.numberChampionshipsDirection,

      lastChampionship: state.response.lastChampionship,
      lastChampionshipAnswerType: state.response.lastChampionshipAnswerType,
      lastChampionshipDirection: state.response.lastChampionshipDirection,

      yearFounded: state.response.yearFounded,
      yearFoundedAnswerType: state.response.yearFoundedAnswerType,
      yearFoundedDirection: state.response.yearFoundedDirection,
    } as IGuessDataRowProps,
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
}
