package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Condition;
import com.example.statemachine.InvoiceContext;
import com.example.statemachine.service.MatchingInvoiceTaxpayerInvoiceService;

/**
 * @author hujin
 */
public class MatchingInvoiceTaxpayerInvoiceServiceImpl implements MatchingInvoiceTaxpayerInvoiceService {
    @Override
    public Condition<InvoiceContext> matchingInvoiceTaxpayerSuccessCondition() {
        return new Condition<InvoiceContext>() {
            @Override
            public boolean isSatisfied(InvoiceContext invoiceContext) {
                return "success".equals(invoiceContext.getMatchingInvoiceTaxpayerCondition());
            }
        };
    }

    @Override
    public Condition<InvoiceContext> matchingInvoiceTaxpayerFailCondition() {
        return new Condition<InvoiceContext>() {
            @Override
            public boolean isSatisfied(InvoiceContext invoiceContext) {
                return "fail".equals(invoiceContext.getMatchingInvoiceTaxpayerCondition());
            }
        };
    }
}
