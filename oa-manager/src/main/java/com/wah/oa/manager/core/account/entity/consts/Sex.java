package com.wah.oa.manager.core.account.entity.consts;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum Sex{

    @SerializedName("0")
    FEMALE(0, "女性"),

    @SerializedName("1")
    MALE(1, "男性"),

    @SerializedName("2")
    SECRECY(2, "保密"),

    ;

    private int    id;
    private String description;

    public static Sex getById(int id){
        for(Sex sex : Sex.values()){
            if(sex.id == id){
                return sex;
            }
        }

        return SECRECY;
    }

    public static Map<Integer, String> asMap(){
        return Arrays.stream(Sex.values())
                     .collect(Collectors.toMap(Sex::getId, Sex::getDescription));
    }

    public static List<Sex> asList(){
        return Arrays.stream(Sex.values())
                     .collect(Collectors.toList());
    }
}
