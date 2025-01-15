import {
  AnswerType,
  AnswerDirection,
  Leagues,
} from "../ResultCard/ResultCardTypes";

export interface IGuessDataRowProps
  extends IGuessResponseProps,
    IDataRowProps {}

export interface IDataRowProps {
  key: string;
  isTitle: boolean;
  teamName: string;
}

export interface ITitleRowProps extends IDataRowProps {
  guessNumber: number;
}

export interface IGuessResponseProps {
  league: Leagues;
  leagueAnswerType: AnswerType;

  state: string;
  stateAnswerType: AnswerType;

  numberChampionships: number;
  numberChampionshipsAnswerType: AnswerType;
  numberChampionshipsDirection: AnswerDirection;

  lastChampionship: number;
  lastChampionshipAnswerType: AnswerType;
  lastChampionshipDirection: AnswerDirection;

  yearFounded: number;
  yearFoundedAnswerType: AnswerType;
  yearFoundedDirection: AnswerDirection;
  teamName: string;
  teamId: number;
}

export class GuessResponse {
  constructor(data: Partial<IGuessResponseProps>) {
    this.league = data.league;
    this.leagueAnswerType = data.leagueAnswerType;

    this.state = data.state;
    this.stateAnswerType = data.stateAnswerType;

    this.numberChampionships = data.numberChampionships;
    this.numberChampionshipsAnswerType = data.numberChampionshipsAnswerType;
    this.numberChampionshipsDirection = data.numberChampionshipsDirection;

    this.lastChampionship = data.lastChampionship;
    this.lastChampionshipAnswerType = data.lastChampionshipAnswerType;
    this.lastChampionshipDirection = data.lastChampionshipDirection;

    this.yearFounded = data.yearFounded;
    this.yearFoundedAnswerType = data.yearFoundedAnswerType;
    this.yearFoundedDirection = data.yearFoundedDirection;
    this.teamName = data.teamName;
    this.teamId = data.teamId;
  }
  league: Leagues;
  leagueAnswerType: AnswerType;

  state: string;
  stateAnswerType: AnswerType;

  numberChampionships: number;
  numberChampionshipsAnswerType: AnswerType;
  numberChampionshipsDirection: AnswerDirection;

  lastChampionship: number;
  lastChampionshipAnswerType: AnswerType;
  lastChampionshipDirection: AnswerDirection;

  yearFounded: number;
  yearFoundedAnswerType: AnswerType;
  yearFoundedDirection: AnswerDirection;

  teamName: string;
  teamId: number;
}

interface ITeamSkeletonProps {
  teamId: number;
  teamName: string;
}
export class TeamSkeleton {
  constructor(data: ITeamSkeletonProps) {
    this.teamId = data.teamId;
    this.teamName = data.teamName;
  }
  teamId: number;
  teamName: string;
}
