import React, { useState } from "react";
import { TeamSkeleton } from "./GuessScreen/GuessScreenTypes";
import { AutoComplete, AutoCompleteProps } from "antd";

interface IInputBarProps {
  allTeams: TeamSkeleton[];
}
class InputBarState {
  options: AutoCompleteProps["options"];
  selectedTeam: TeamSkeleton | null;
}

export function InputBar(props: IInputBarProps) {
  const { allTeams } = props;
  const [state, setState] = useState<InputBarState>({
    options: [],
    selectedTeam: null,
  });
  const getShownOptions = (input: string): AutoCompleteProps["options"] => {
    const teams = allTeams.filter((t) =>
      t.teamName.toLowerCase().includes(input.toLowerCase()),
    );
    return teams.map((team) => ({
      value: team.teamName, // Display the team name in the dropdown
      label: team.teamName, // Set the label to the team name as well
      data: team, // Store the full team object in the `data` property
    }));
  };

  const handleSelect = (value: TeamSkeleton, option) => {
    setState((prevState) => ({ ...prevState, selectedTeam: option.data }));
  };

  const handleClear = () => {
    setState({
      selectedTeam: null,
      options: allTeams,
    });
  };

  return (
    <AutoComplete
      style={{ width: 200 }}
      options={state.options}
      onSearch={(text) =>
        setState((prevState) => ({
          ...prevState,
          options: getShownOptions(text),
        }))
      }
      onSelect={handleSelect}
      allowClear={true}
      onClear={handleClear}
    />
  );
}
