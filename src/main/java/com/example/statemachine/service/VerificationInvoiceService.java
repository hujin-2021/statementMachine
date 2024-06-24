package com.example.statemachine.service;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;
import com.example.statemachine.InvoiceContext;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;

/**
 * @author hujin
 */
public interface VerificationInvoiceService {
    Condition<InvoiceContext> verificationSuccessCondition();

    Condition<InvoiceContext> verificationFailCondition();

    void verifyInvoice(String param);

    Action<States, Events, InvoiceContext> verifySuccessAction();
}
