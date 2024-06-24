package com.example.statemachine;

public class MatchingInvoiceTaxpayerContext {
    private String condition;
    public MatchingInvoiceTaxpayerContext(String condition){
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }
}
