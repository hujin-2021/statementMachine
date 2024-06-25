package com.example.statemachine.context;

/**
 * @author hujin
 */
public class MatchingInvoiceTaxpayerInvoiceContext extends BaseContext{
    private String matchingInvoiceTaxpayerCondition;

    private String matchingReferenceId;

    public String getMatchingReferenceId() {
        return matchingReferenceId;
    }

    public void setMatchingReferenceId(String matchingReferenceId) {
        this.matchingReferenceId = matchingReferenceId;
    }

    public MatchingInvoiceTaxpayerInvoiceContext(String matchingInvoiceTaxpayerCondition,String matchingReferenceId) {
        this.matchingInvoiceTaxpayerCondition = matchingInvoiceTaxpayerCondition;
        this.matchingReferenceId=matchingReferenceId;
    }

    public String getMatchingInvoiceTaxpayerCondition() {
        return matchingInvoiceTaxpayerCondition;
    }

    public void setMatchingInvoiceTaxpayerCondition(String matchingInvoiceTaxpayerCondition) {
        this.matchingInvoiceTaxpayerCondition = matchingInvoiceTaxpayerCondition;
    }

    @Override
    public String getCondition() {
        return getMatchingInvoiceTaxpayerCondition();
    }
}
