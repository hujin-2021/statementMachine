package com.example.statemachine.service;

import com.alibaba.cola.statemachine.Condition;

import com.example.statemachine.context.AutomaticRequisitionInvoiceContext;
import com.example.statemachine.context.BaseContext;

/**
 * @author hujin
 */
public interface AutomaticRequisitionInvoiceService {
    Condition<BaseContext> AutomaticRequisitionSuccessCondition();

    Condition<BaseContext> AutomaticRequisitionFailCondition();
}
