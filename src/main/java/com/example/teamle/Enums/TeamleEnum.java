package com.example.teamle.Enums;

import com.fasterxml.jackson.annotation.JsonValue;

public interface TeamleEnum {
    @JsonValue
    int getEnumValue();
}


