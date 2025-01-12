package com.example.teamle.Enums.TeamleEnums.StatesAndProvinces;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.teamle.Enums.TeamleEnums.StatesAndProvinces.StatesUtility.CapitalizeStateOrProvince;

public enum States implements StatesAndProvinces{
    ALABAMA(1),
    ALASKA(2),
    ARIZONA(3),
    ARKANSAS(4),
    CALIFORNIA(5),
    COLORADO(6),
    CONNECTICUT(7),
    DELAWARE(8),
    FLORIDA(9),
    GEORGIA(10),
    HAWAII(11),
    IDAHO(12),
    ILLINOIS(13),
    INDIANA(14),
    IOWA(15),
    KANSAS(16),
    KENTUCKY(17),
    LOUISIANA(18),
    MAINE(19),
    MARYLAND(20),
    MASSACHUSETTS(21),
    MICHIGAN(22),
    MINNESOTA(23),
    MISSISSIPPI(24),
    MISSOURI(25),
    MONTANA(26),
    NEBRASKA(27),
    NEVADA(28),
    NEW_HAMPSHIRE(29),
    NEW_JERSEY(30),
    NEW_MEXICO(31),
    NEW_YORK(32),
    NORTH_CAROLINA(33),
    NORTH_DAKOTA(34),
    OHIO(35),
    OKLAHOMA(36),
    OREGON(37),
    PENNSYLVANIA(38),
    RHODE_ISLAND(39),
    SOUTH_CAROLINA(40),
    SOUTH_DAKOTA(41),
    TENNESSEE(42),
    TEXAS(43),
    UTAH(44),
    VERMONT(45),
    VIRGINIA(46),
    WASHINGTON(47),
    WEST_VIRGINIA(48),
    WISCONSIN(49),
    WYOMING(50),
    DC(51);

    private final int stateValue;
    private static Map<Integer, States> valueStateMap;
    States(int i){
        stateValue = i;
    }

    @Override
    public String toString() {
        if (this != DC){
            return CapitalizeStateOrProvince(this.name());
        }
        else{
            return "Washington D.C.";
        }
    }

    @Override
    public int getEnumValue() {
        return this.stateValue;
    }

    public static States getStateOrProvinceFromValue(int stateValue){
        if (valueStateMap == null){
            valueStateMap = Arrays.stream(States.values()).collect(Collectors.toMap(States::getEnumValue, state -> state));
        }
        return valueStateMap.get(stateValue);
    }

}