package com.example.teamle.Enums.TeamleEnums;

import com.example.teamle.Enums.TeamleEnum;

public enum AnswerTypes implements TeamleEnum {
    WRONG(0),
    NEAR(1),
    CORRECT(2);

    private int value;
    AnswerTypes(int value){
        this.value = value;
    }
    @Override
    public int getEnumValue(){
        return this.value;
    }
}
