package com.example.statemachine.enums;

public enum States {
    ToBeVerified(0, "待验证"),
    VerificationFailed(1, "验证失败"),
    ToBeMatched(2, "待匹配"),
    MatchFailed(3, "匹配失败"),
    ToBeAutoUsed(4, "待自动领用"),

    ToBeManuallyUsed(5, "待手工领用"),
    PartialUse(6, "部分领用"),
    FullyUsed(7, "完全领用")

    ;

    private int value;
    private String name;

    States(int value,String name){
        this.value=value;
        this.name=name;
    }
    public int getValue(){
        return value;
    }

    public String getName(){
        return name;
    }

}
