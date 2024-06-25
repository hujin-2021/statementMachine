package com.example.statemachine.service;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;

import com.example.statemachine.context.BaseContext;
import com.example.statemachine.context.VerificationInvoiceContext;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;

/**
 * @author hujin
 */
public interface VerificationInvoiceService {
    Condition<BaseContext> verificationSuccessCondition();

    Condition<BaseContext> verificationFailCondition();


    void verifyInvoice(String param);

    Action<States, Events, BaseContext> verificationSuccessAction();

    Action<States, Events, BaseContext> verificationFailAction();
}
