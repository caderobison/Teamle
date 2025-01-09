package com.example.teamle.Enums.TeamleEnums;

import com.example.teamle.Enums.TeamleEnum;

// this is the direction TO the correct answer
// so if the guess was 1967 and the correct answer is 2000, the direction would be HIGHER
public enum AnswerDirection implements TeamleEnum {
    LOWER(0),
    HIGHER(1),
    CORRECT(2);

    private int value;
    AnswerDirection(int value){
        this.value = value;
    }
    @Override
    public int getEnumValue(){
        return this.value;
    }
}


