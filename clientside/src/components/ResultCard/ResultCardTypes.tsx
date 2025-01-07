export interface INumberResultCardProps {
    distanceFromCorrect : number
}
export interface IEnumResultCardProps {
    guessIsCorrect: boolean
}

export enum AnswerType {
    Wrong = 0,
    Near = 1,
    Correct = 2
}

export enum DirectionToAnswer{
    Lower = 0,
    Higher = 1,
    Correct = 2
}

export enum Leagues{
    NFL = 0,
    NBA = 1,
    MLB = 2,
    NHL = 3
}

export const CaluclateDirectionFromNumber = (guessNumber : number) => {
    if (guessNumber > 0) {
        return DirectionToAnswer.Higher
    }
    else if (guessNumber < 0){
        return DirectionToAnswer.Lower
    }
    else return DirectionToAnswer.Correct
}