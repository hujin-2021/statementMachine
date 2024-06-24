package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Condition;
import com.example.statemachine.InvoiceContext;
import com.example.statemachine.service.AutomaticRequisitionInvoiceService;

/**
 * @author hujin
 */
public class AutomaticRequisitionInvoiceServiceImpl implements AutomaticRequisitionInvoiceService {
    @Override
    public Condition<InvoiceContext> AutomaticRequisitionSuccessCondition() {
        return new Condition<InvoiceContext>() {
            @Override
            public boolean isSatisfied(InvoiceContext invoiceContext) {
                return "success".equals(invoiceContext.getAutomaticRequisitionCondition());
            }
        };
    }

    @Override
    public Condition<InvoiceContext> AutomaticRequisitionFailCondition() {
        return new Condition<InvoiceContext>() {
            @Override
            public boolean isSatisfied(InvoiceContext invoiceContext) {
                return "fail".equals(invoiceContext.getAutomaticRequisitionCondition());
            }
        };
    }
}
