package com.example.statemachine.service;

import com.alibaba.cola.statemachine.Condition;

import com.example.statemachine.context.BaseContext;
import com.example.statemachine.context.MatchingInvoiceTaxpayerInvoiceContext;

/**
 * @author hujin
 */
public interface MatchingInvoiceTaxpayerInvoiceService {
    Condition<BaseContext> matchingInvoiceTaxpayerSuccessCondition();

    Condition<BaseContext> matchingInvoiceTaxpayerFailCondition();
}
