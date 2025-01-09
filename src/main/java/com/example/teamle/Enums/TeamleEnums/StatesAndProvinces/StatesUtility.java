package com.example.teamle.Enums.TeamleEnums.StatesAndProvinces;

import org.springframework.util.StringUtils;

public class StatesUtility {
    public static String CapitalizeStateOrProvince(String name){
        String[] stringSplit = name.split("_");
        StringBuilder finalWord = new StringBuilder();
        for (String word: stringSplit) {
            word = StringUtils.capitalize(word.toLowerCase());
            finalWord.append(word).append(" ");
        }
        finalWord.deleteCharAt(finalWord.lastIndexOf(" "));
        return finalWord.toString();
    }
}
