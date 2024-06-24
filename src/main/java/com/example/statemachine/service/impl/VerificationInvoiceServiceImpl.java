package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;
import com.alibaba.cola.statemachine.StateMachine;
import com.example.statemachine.InvoiceContext;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;
import com.example.statemachine.service.VerificationInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hujin
 */
@Service
public class VerificationInvoiceServiceImpl implements VerificationInvoiceService {
    @Autowired
    private StateMachine<States, Events,InvoiceContext> stateMachine;
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

    @Override
    public void verifyInvoice(String param) {
        stateMachine.fireEvent(States.ToBeVerified, Events.VerificationInvoice, new InvoiceContext());
    }


    public Action<States, Events, InvoiceContext> verifySuccessAction() {
        return (from, to, event, ctx) -> {
            System.out.println(
                    " from:" + from + " to:" + to + " on:" + event);
        };
    }
}
