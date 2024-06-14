package com.example.statemachine.enums;

public enum Events {

    VerificationInvoice(1,"发票校验"),
    MatchingInvoiceTaxpayerInvoice(2,"匹配税号"),
    AutomaticRequisitionInvoice(3,"自动领用"),
    CancelInvoiceRequisition(4,"取消领用")

    ;

    Events(int value,String name){
        this.value=value;
        this.name=name;
    }
    private int value;
    private String name;
}
