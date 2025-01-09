export interface IResultCardProps {
    answerType: AnswerType
}

export interface INumberResultCardProps extends IResultCardProps{
    guess : number,
    answerDirection : AnswerDirection
}

export enum AnswerType {
    Wrong = 0,
    Near = 1,
    Correct = 2
}

export enum AnswerDirection{
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
        return AnswerDirection.Higher
    }
    else if (guessNumber < 0){
        return AnswerDirection.Lower
    }
    else return AnswerDirection.Correct
}