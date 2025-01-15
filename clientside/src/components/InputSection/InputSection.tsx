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
  guessIds: number[];
}

export function InputSection(props: IInputSectionProps) {
  const [state, setState] = useState<InputSectionState>({
    selectedTeam: null,
    searchValue: null,
    submitted: false,
    guessIds: [],
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
      guessIds: [...prevState.guessIds, resp.teamId],
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
          guessIds={state.guessIds}
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
