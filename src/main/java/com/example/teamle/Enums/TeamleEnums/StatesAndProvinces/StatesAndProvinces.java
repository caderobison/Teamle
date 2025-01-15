package com.example.teamle.Enums.TeamleEnums.StatesAndProvinces;

import com.example.teamle.Enums.TeamleEnum;
import com.example.teamle.Teams.TeamConstants;

public interface StatesAndProvinces extends TeamleEnum {
    static Class<? extends StatesAndProvinces> getCorrectType(int stateOrProvinceId){
        if (TeamConstants.MIN_STATE_ID <= stateOrProvinceId && stateOrProvinceId <= TeamConstants.MAX_STATE_ID){
            return States.class;
        } else if (TeamConstants.MIN_PROVINCE_ID <= stateOrProvinceId && stateOrProvinceId <= TeamConstants.MAX_PROVINCE_ID) {
            return Provinces.class;
        }
        return StatesAndProvinces.class;
    }
    static StatesAndProvinces getStateOrProvinceFromValue(int value) {
        return null;
    }
}
