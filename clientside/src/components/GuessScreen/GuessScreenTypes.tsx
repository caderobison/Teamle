import {Leagues} from "../ResultCard/ResultCardTypes";

export interface DataRowProps {
    league: Leagues,
    leagueCorrect: boolean,

    numberChampionships: number,
    numberChampionshipsDistance: number,

    lastChampionship: number,
    lastChampionshipDistance: number,

    yearFounded: number,
    yearFoundedDistance: number,

    state: string,
    stateCorrect: boolean,

}