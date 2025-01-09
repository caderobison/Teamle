import {GuessResponse} from "../components/GuessScreen/GuessScreenTypes";

export class GuessHandler {
  compareGuess(teamId : number): Promise<GuessResponse> {
    return fetch(`/guess/${teamId}`, {method: `POST`}).then(async (response) => new GuessResponse(await response.json()));
  }
}
