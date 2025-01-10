import {TeamSkeleton} from "../components/GuessScreen/GuessScreenTypes";

export class TeamsHandler {
    getAllTeams(): Promise<TeamSkeleton[]> {
        return fetch(`/teams/allTeams`).then(async (response) => (await response.json()).map((team) => new TeamSkeleton(team)));
    }
}
