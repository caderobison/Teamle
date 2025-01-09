package com.example.teamle.Enums.TeamleEnums.StatesAndProvinces;

import org.springframework.util.StringUtils;

public enum States implements StatesAndProvinces{
    ALABAMA,
    ALASKA,
    ARIZONA,
    ARKANSAS,
    CALIFORNIA,
    COLORADO,
    CONNECTICUT,
    DELAWARE,
    FLORIDA,
    GEORGIA,
    HAWAII,
    IDAHO,
    ILLINOIS,
    INDIANA,
    IOWA,
    KANSAS,
    KENTUCKY,
    LOUISIANA,
    MAINE,
    MARYLAND,
    MASSACHUSETTS,
    MICHIGAN,
    MINNESOTA,
    MISSISSIPPI,
    MISSOURI,
    MONTANA,
    NEBRASKA,
    NEVADA,
    NEW_HAMPSHIRE,
    NEW_JERSEY,
    NEW_MEXICO,
    NEW_YORK,
    NORTH_CAROLINA,
    NORTH_DAKOTA,
    OHIO,
    OKLAHOMA,
    OREGON,
    PENNSYLVANIA,
    RHODE_ISLAND,
    SOUTH_CAROLINA,
    SOUTH_DAKOTA,
    TENNESSEE,
    TEXAS,
    UTAH,
    VERMONT,
    VIRGINIA,
    WASHINGTON,
    WEST_VIRGINIA,
    WISCONSIN,
    WYOMING,
    DC;

    @Override
    public String toString() {
        if (this != DC){
            String noUnderscores = this.name().replace('_', ' ');
            return StringUtils.capitalize(noUnderscores);
        }
        else{
            return "Washington D.C.";
        }
    }

    @Override
    public int getEnumValue() {
        return this.ordinal();
    }
}