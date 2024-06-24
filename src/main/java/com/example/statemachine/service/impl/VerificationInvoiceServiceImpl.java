package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;
import com.example.statemachine.InvoiceContext;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;
import com.example.statemachine.service.VerificationInvoiceService;

/**
 * @author hujin
 */
public class VerificationInvoiceServiceImpl implements VerificationInvoiceService {

    @Override
    public Condition<InvoiceContext> verificationSuccessCondition() {
        return new Condition<InvoiceContext>() {
            @Override
            public boolean isSatisfied(InvoiceContext invoiceContext) {
                return "success".equals(invoiceContext.getVerificationCondition());
            }
        };
    }

    @Override
    public Condition<InvoiceContext> verificationFailCondition() {
        return new Condition<InvoiceContext>() {
            @Override
            public boolean isSatisfied(InvoiceContext invoiceContext) {
                return "fail".equals(invoiceContext.getVerificationCondition());
            }
        };
    }

    private Action<States, Events, InvoiceContext> doAction() {
        return (from, to, event, ctx) -> {
            System.out.println(
                    " from:" + from + " to:" + to + " on:" + event);
        };
    }
}
