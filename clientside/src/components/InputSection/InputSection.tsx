import { Col } from "antd";
import { InputBar, TeamSkeletonOption } from "./InputBar";
import { EnterButton } from "./EnterButton";
import React, { useState } from "react";
import { TeamSkeleton } from "../GuessScreen/GuessScreenTypes";
import { GuessHandler } from "../../Handlers/GuessHandler";

interface IInputSectionProps {
  allTeams: TeamSkeleton[];
}

class InputSectionState {
  selectedTeam?: TeamSkeleton;
}

export function InputSection(props: IInputSectionProps) {
  const [state, setState] = useState<InputSectionState>({ selectedTeam: null });
  const { allTeams } = props;
  const handler = new GuessHandler();
  const handleSelect = (
    value: TeamSkeleton,
    option: { data: TeamSkeleton },
  ) => {
    setState((prevState) => ({ ...prevState, selectedTeam: option.data }));
  };

  const handleClear = () => {
    setState({
      selectedTeam: null,
    });
  };

  const handleChange = (_value: TeamSkeleton, _option?: TeamSkeletonOption) => {
    setState((prevState) => ({ ...prevState, selectedTeam: null }));
  };

  const handleSubmit = (_event: React.MouseEvent<HTMLElement, MouseEvent>) => {
    const resp = handler.compareGuess(state.selectedTeam.teamId);
    setState((prevState) => ({
      ...prevState,
      selectedTeam: null,
    }));
  };

  return (
    <>
      <Col span={11} offset={5}>
        <InputBar
          allTeams={allTeams}
          onSelect={handleSelect}
          onClear={handleClear}
          onChange={handleChange}
        />
      </Col>
      <Col span={3}>
        <EnterButton
          value="Submit"
          fillWidth={true}
          disabled={state.selectedTeam === null}
          onClick={handleSubmit}
        />
      </Col>
    </>
  );
}
