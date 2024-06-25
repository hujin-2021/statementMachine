package com.example.statemachine.service;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;

import com.example.statemachine.context.AutomaticRequisitionInvoiceContext;
import com.example.statemachine.context.BaseContext;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;

/**
 * @author hujin
 */
public interface AutomaticRequisitionInvoiceService {
    Condition<BaseContext> AutomaticRequisitionSuccessCondition();

    Condition<BaseContext> AutomaticRequisitionFailCondition();

    Action<States, Events, BaseContext> automaticRequisitionSuccessAction();
}
