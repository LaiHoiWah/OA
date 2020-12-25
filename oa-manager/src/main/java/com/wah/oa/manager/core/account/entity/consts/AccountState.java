package com.wah.oa.manager.core.account.entity.consts;

import com.google.gson.annotations.SerializedName;
import com.wah.oa.manager.commons.security.exception.UnknownEnumException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum AccountState{

    @SerializedName("0")
    NORMAL(0, "正常"),

    @SerializedName("1")
    LOCKED(1, "锁定"),

    @SerializedName("2")
    FROZEN(2, "冻结"),

    @SerializedName("3")
    ABNORMAL(3, "异常"),

    ;

    private int    id;
    private String description;

    public static AccountState getById(int id){
        for(AccountState state : AccountState.values()){
            if(state.id == id){
                return state;
            }
        }

        throw new UnknownEnumException("未知的账户状态ID : [{0}]", id);
    }

    public static Map<Integer, String> asMap(){
        return Arrays.stream(AccountState.values())
                     .collect(Collectors.toMap(AccountState::getId, AccountState::getDescription));
    }

    public static List<AccountState> asList(){
        return Arrays.stream(AccountState.values())
                     .collect(Collectors.toList());
    }
}
