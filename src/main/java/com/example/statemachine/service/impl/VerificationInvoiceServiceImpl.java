package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;
import com.alibaba.cola.statemachine.StateMachine;
import com.example.statemachine.InvoiceContext;
import com.example.statemachine.context.BaseContext;
import com.example.statemachine.context.VerificationInvoiceContext;
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
    public Condition<BaseContext> verificationSuccessCondition() {
        return new Condition<BaseContext>() {
            @Override
            public boolean isSatisfied(BaseContext ctx) {
                if(ctx instanceof VerificationInvoiceContext){
                    return "verificationSuccess".equals(ctx.getCondition());
                }else{
                    return false;
                }
            }
        };
    }

    @Override
    public Condition<BaseContext> verificationFailCondition() {
        return new Condition<BaseContext>() {
            @Override
            public boolean isSatisfied(BaseContext ctx) {
                if(ctx instanceof VerificationInvoiceContext){
                    return "verificationSuccess".equals(ctx.getCondition());
                }else{
                    return false;
                }
            }
        };
    }

    @Override
    public void verifyInvoice(String param) {
        stateMachine.fireEvent(States.ToBeVerified, Events.VerificationInvoice, new InvoiceContext());
    }


    public Action<States, Events, VerificationInvoiceContext> verifySuccessAction() {
        return (from, to, event, ctx) -> {
            System.out.println(
                    " from:" + from + " to:" + to + " on:" + event);
        };
    }
}
