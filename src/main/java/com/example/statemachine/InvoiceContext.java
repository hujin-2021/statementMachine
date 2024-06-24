package com.example.statemachine;

public class InvoiceContext {
    private String verificationCondition;

    private String matchingInvoiceTaxpayerCondition;

    private String automaticRequisitionCondition;

    public InvoiceContext(String verificationCondition, String matchingInvoiceTaxpayerCondition,String automaticRequisitionCondition) {
        this.verificationCondition = verificationCondition;
        this.matchingInvoiceTaxpayerCondition = matchingInvoiceTaxpayerCondition;
        this.automaticRequisitionCondition=automaticRequisitionCondition;
    }

    public String getVerificationCondition() {
        return verificationCondition;
    }

    public void setVerificationCondition(String verificationCondition) {
        this.verificationCondition = verificationCondition;
    }

    public String getMatchingInvoiceTaxpayerCondition() {
        return matchingInvoiceTaxpayerCondition;
    }

    public void setMatchingInvoiceTaxpayerCondition(String matchingInvoiceTaxpayerCondition) {
        this.matchingInvoiceTaxpayerCondition = matchingInvoiceTaxpayerCondition;
    }

    public String getAutomaticRequisitionCondition() {
        return automaticRequisitionCondition;
    }

    public void setAutomaticRequisitionCondition(String automaticRequisitionCondition) {
        this.automaticRequisitionCondition = automaticRequisitionCondition;
    }
}
