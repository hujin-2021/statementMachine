package com.example.statemachine.service;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;

import com.example.statemachine.context.BaseContext;
import com.example.statemachine.context.MatchingInvoiceTaxpayerInvoiceContext;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;

/**
 * @author hujin
 */
public interface MatchingInvoiceTaxpayerInvoiceService {
    Condition<BaseContext> matchingInvoiceTaxpayerSuccessCondition();

    Condition<BaseContext> matchingInvoiceTaxpayerFailCondition();

    Action<States, Events, BaseContext> matchingSuccessAction();

    Action<States, Events, BaseContext> matchingFailAction();
}
