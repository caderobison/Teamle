import React, {
  JSXElementConstructor,
  ReactElement,
  useEffect,
  useState,
} from "react";
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
  submitted: boolean;
}
class InputBarState {
  options: AutoCompleteProps["options"];
  selectedTeam: TeamSkeleton | null;
  optionsOpen: boolean;
  searchText: string;
}

export function InputBar(props: IInputBarProps) {
  const { allTeams, onSelect, onClear, value } = props;
  const [state, setState] = useState<InputBarState>({
    options: allTeams,
    selectedTeam: null,
    optionsOpen: false,
    searchText: "",
  });
  const getShownOptions = (input: string): AutoCompleteProps["options"] => {
    let teams = allTeams;
    if (input && input.trim().length !== 0) {
      teams = allTeams.filter((t) =>
        t.teamName.toLowerCase().includes(input.toLowerCase()),
      );
    }
    return teams.map((team) => ({
      value: team.teamName, // Display the team name in the dropdown
      label: renderOption(team), // Set the label to the team name as well
      data: team, // Store the full team object in the `data` property
    }));
  };

  useEffect(() => {
    setState((prevState) => ({
      options: allTeams,
      selectedTeam: null,
      optionsOpen: false,
      searchText: "",
    }));
  }, []);

  useEffect(() => {
    setState((prevState) => ({
      ...prevState,
      options: allTeams,
      submitted: !props.submitted,
    }));
  }, [props.submitted]);

  useEffect(() => {
    setState((prevState) => ({
      ...prevState,
      options: allTeams,
    }));
  }, [props.allTeams]);

  const setOpen = (isOpen: boolean) => {
    setState((prevState) => ({ ...prevState, optionsOpen: isOpen }));
  };

  const renderOption = (teamOption: TeamSkeleton): ReactElement => {
    const parts = teamOption.teamName.split(
      new RegExp(`(${state.searchText})`, "gi"),
    );
    if (state.searchText.length === 0) return <>{teamOption.teamName}</>;
    return (
      <>
        {parts.map((part) =>
          part.toLowerCase() === state.searchText.toLowerCase() ? (
            <b>{part}</b>
          ) : (
            <>{part}</>
          ),
        )}
      </>
    );
  };

  return (
    <AutoComplete
      style={{ width: "100%" }}
      options={getShownOptions(state.searchText)}
      open={state.optionsOpen}
      onSearch={(text) =>
        setState((prevState) => ({
          ...prevState,
          options: getShownOptions(text),
          searchText: text,
        }))
      }
      value={value}
      onSelect={onSelect}
      allowClear={true}
      onClear={onClear}
      onChange={props.onChange}
      onFocus={() => setOpen(true)}
      onBlur={() => setOpen(false)}
    />
  );
}
