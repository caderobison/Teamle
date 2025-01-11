import React, { useState } from "react";
import { TeamSkeleton } from "../GuessScreen/GuessScreenTypes";
import { AutoComplete, AutoCompleteProps } from "antd";

export type TeamSkeletonOption = {
  data: TeamSkeleton;
};
interface IInputBarProps {
  allTeams: TeamSkeleton[];
  onSelect: (value: TeamSkeleton, option: TeamSkeletonOption) => void;
  onClear: () => void;
  onChange: (value: TeamSkeleton, option?: TeamSkeletonOption) => void;
  value: TeamSkeleton | null;
}
class InputBarState {
  options: AutoCompleteProps["options"];
  selectedTeam: TeamSkeleton | null;
}

export function InputBar(props: IInputBarProps) {
  const { allTeams, onSelect, onClear, value } = props;
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

  return (
    <AutoComplete
      style={{ width: "100%" }}
      options={state.options}
      onSearch={(text) =>
        setState((prevState) => ({
          ...prevState,
          options: getShownOptions(text),
        }))
      }
      value={value}
      onSelect={onSelect}
      allowClear={true}
      onClear={onClear}
      onChange={props.onChange}
    />
  );
}
