import { Col } from "antd";
import { InputBar, TeamSkeletonOption } from "./InputBar";
import { EnterButton } from "./EnterButton";
import React, { useState } from "react";
import { GuessResponse, TeamSkeleton } from "../GuessScreen/GuessScreenTypes";
import { GuessHandler } from "../../Handlers/GuessHandler";

interface IInputSectionProps {
  allTeams: TeamSkeleton[];
  onGuessResponse: (response: GuessResponse) => void;
}

class InputSectionState {
  selectedTeam?: TeamSkeleton;
  searchValue?: TeamSkeleton;
  submitted: boolean;
}

export function InputSection(props: IInputSectionProps) {
  const [state, setState] = useState<InputSectionState>({
    selectedTeam: null,
    searchValue: null,
    submitted: false,
  });
  const { allTeams, onGuessResponse } = props;
  const handler = new GuessHandler();
  const handleSelect = (
    value: TeamSkeleton,
    option: { data: TeamSkeleton },
  ) => {
    setState((prevState) => ({ ...prevState, selectedTeam: option.data }));
  };

  const handleClear = () => {
    setState((prevState) => ({
      ...prevState,
      selectedTeam: null,
      searchValue: null,
    }));
  };

  const handleChange = (_value: TeamSkeleton, _option?: TeamSkeletonOption) => {
    setState((prevState) => ({
      ...prevState,
      selectedTeam: null,
      searchValue: _value,
    }));
  };

  const handleSubmit = async (
    _event: React.MouseEvent<HTMLElement, MouseEvent>,
  ) => {
    const resp = await handler.compareGuess(state.selectedTeam.teamId);
    setState((prevState) => ({
      ...prevState,
      selectedTeam: null,
      searchValue: null,
      submitted: !prevState.submitted,
    }));
    onGuessResponse(resp);
  };

  return (
    <>
      <Col span={11} offset={5}>
        <InputBar
          allTeams={allTeams}
          onSelect={handleSelect}
          onClear={handleClear}
          onChange={handleChange}
          value={state.searchValue}
          submitted={state.submitted}
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
