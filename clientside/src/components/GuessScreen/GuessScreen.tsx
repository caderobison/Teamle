import { Col, Row, Table } from "antd";
import React, { useEffect, useState } from "react";
import { GuessResponse, TeamSkeleton } from "./GuessScreenTypes";
import { TeamsHandler } from "../../Handlers/TeamsHandler";
import { InputSection } from "../InputSection/InputSection";
import { GuessTable } from "./GuessTable";

class GuessTableState {
  responses: GuessResponse[];
  allTeams: TeamSkeleton[];
}

export function GuessScreen() {
  const [state, setState] = useState<GuessTableState>({
    responses: [],
    allTeams: [],
  });
  const receiveResponse = (resp: GuessResponse) => {
    setState((prevState) => ({
      ...prevState,
      responses: [...prevState.responses, resp],
    }));
  };

  const getAllTeams = async () => {
    const handler = new TeamsHandler();
    const resp = await handler.getAllTeams();
    setState((prevState) => ({
      ...prevState,
      allTeams: resp,
    }));
  };

  useEffect(() => {
    getAllTeams();
  }, []);
  if (state.allTeams)
    return (
      <>
        <Col span={16} offset={4}>
          <GuessTable guessData={state.responses} />
        </Col>
        <Row>
          <InputSection
            allTeams={state.allTeams}
            onGuessResponse={receiveResponse}
          />
        </Row>
      </>
    );
}
