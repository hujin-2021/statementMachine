package com.example.statemachine.context;

/**
 * @author hujin
 */
public class MatchingInvoiceTaxpayerInvoiceContext extends BaseContext{
    private String matchingInvoiceTaxpayerCondition;

    public MatchingInvoiceTaxpayerInvoiceContext(String matchingInvoiceTaxpayerCondition) {
        this.matchingInvoiceTaxpayerCondition = matchingInvoiceTaxpayerCondition;
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
