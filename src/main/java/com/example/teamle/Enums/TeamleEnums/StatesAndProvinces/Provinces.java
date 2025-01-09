package com.example.teamle.Enums.TeamleEnums.StatesAndProvinces;

import org.springframework.util.StringUtils;

import static com.example.teamle.Enums.TeamleEnums.StatesAndProvinces.StatesUtility.CapitalizeStateOrProvince;

public enum Provinces implements StatesAndProvinces{
    ALBERTA,
    BRITISH_COLUMBIA,
    MANITOBA,
    NEW_BRUNSWICK,
    NEWFOUNDLAND_LABRADOR,
    NOVA_SCOTIA,
    ONTARIO,
    PRINCE_EDWARD_ISLAND,
    QUEBEC,
    SASKATCHEWAN,
    NORTHWEST_TERRITORIES,
    NUNAVUT,
    YUKON,
    ;

    @Override
    public String toString() {
        if (this != NEWFOUNDLAND_LABRADOR){
            return CapitalizeStateOrProvince(this.name());
        }
        else{
            return "Newfoundland and Labrador";
        }
    }

    @Override
    public int getEnumValue() {
        return this.ordinal();
    }
}
