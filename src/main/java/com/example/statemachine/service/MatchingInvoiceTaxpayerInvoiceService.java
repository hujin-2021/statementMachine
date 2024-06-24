package com.example.statemachine.service;

import com.alibaba.cola.statemachine.Condition;
import com.example.statemachine.InvoiceContext;

/**
 * @author hujin
 */
public interface MatchingInvoiceTaxpayerInvoiceService {
    Condition<InvoiceContext> matchingInvoiceTaxpayerSuccessCondition();

    Condition<InvoiceContext> matchingInvoiceTaxpayerFailCondition();
}
