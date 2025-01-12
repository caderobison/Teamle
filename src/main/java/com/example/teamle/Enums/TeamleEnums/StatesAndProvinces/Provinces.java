package com.example.teamle.Enums.TeamleEnums.StatesAndProvinces;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.teamle.Enums.TeamleEnums.StatesAndProvinces.StatesUtility.CapitalizeStateOrProvince;

public enum Provinces implements StatesAndProvinces{
    ALBERTA(52),
    BRITISH_COLUMBIA(53),
    MANITOBA(54),
    NEW_BRUNSWICK(55),
    NEWFOUNDLAND_LABRADOR(56),
    NORTHWEST_TERRITORIES(57),
    NOVA_SCOTIA(58),
    NUNAVUT(59),
    ONTARIO(60),
    PRINCE_EDWARD_ISLAND(61),
    QUEBEC(62),
    SASKATCHEWAN(63),
    YUKON(64);


    private static Map<Integer, Provinces> valueProvinceMap;
    private final int provinceValue;
    Provinces(int i){
        provinceValue = i;
    }

    @Override
    public String toString() {
        if(this == NEWFOUNDLAND_LABRADOR) {
            return "Newfoundland and Labrador";
        }
        if (this == QUEBEC){
            return "Québec";
        }
        return CapitalizeStateOrProvince(this.name());
    }

    @Override
    public int getEnumValue() {
        return this.provinceValue;
    }

    public static Provinces getStateOrProvinceFromValue(int provinceValue){
        if (valueProvinceMap == null){
            valueProvinceMap = Arrays.stream(Provinces.values()).collect(Collectors.toMap(Provinces::getEnumValue, province -> province));
        }
        return valueProvinceMap.get(provinceValue);
    }
}
