package com.example.statemachine.service;

import com.alibaba.cola.statemachine.Condition;
import com.example.statemachine.InvoiceContext;

/**
 * @author hujin
 */
public interface VerificationInvoiceService {
    Condition<InvoiceContext> verificationSuccessCondition();

    Condition<InvoiceContext> verificationFailCondition();
}
