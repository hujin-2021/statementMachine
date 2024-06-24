package com.example.statemachine.service;

import com.alibaba.cola.statemachine.Condition;
import com.example.statemachine.InvoiceContext;

/**
 * @author hujin
 */
public interface AutomaticRequisitionInvoiceService {
    Condition<InvoiceContext> AutomaticRequisitionSuccessCondition();

    Condition<InvoiceContext> AutomaticRequisitionFailCondition();
}
