package com.example.statemachine;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;
import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;

import java.sql.SQLOutput;

public class Start {
    public static void main(String[] args) {
        Start start1=new Start();
        start1.start();
    }

    private void start(){
        StateMachineBuilder<States, Events, InvoiceContext> builder = StateMachineBuilderFactory.create();
        //待验证->待匹配
        builder.externalTransition()
                .from(States.ToBeVerified)
                .to(States.ToBeMatched)
                .on(Events.VerificationInvoice)
                .when(checkVerificationSuccessCondition())
                .perform(doAction());

        //待验证->验证失败
        builder.externalTransition()
                .from(States.ToBeVerified)
                .to(States.VerificationFailed)
                .on(Events.VerificationInvoice)
                .when(checkVerificationFailCondition())
                .perform(doAction());

        //待匹配->待自动领用
        builder.externalTransition()
                .from(States.ToBeMatched)
                .to(States.ToBeAutoUsed)
                .on(Events.MatchingInvoiceTaxpayerInvoice)
                .when(checkMatchingInvoiceTaxpayerSuccessCondition())
                .perform(doAction());

        //待匹配->待手工领用
        builder.externalTransition()
                .from(States.ToBeMatched)
                .to(States.ToBeManuallyUsed)
                .on(Events.MatchingInvoiceTaxpayerInvoice)
                .when(checkMatchingInvoiceTaxpayerFailCondition())
                .perform(doAction());


        //待自动领用->完全领用
        builder.externalTransition()
                .from(States.ToBeAutoUsed)
                .to(States.FullyUsed)
                .on(Events.AutomaticRequisitionInvoice)
                .when(checkAutomaticRequisitionCondition())
                .perform(doAction());

        StateMachine<States, Events, InvoiceContext> stateMachine=builder.build("testMachine1");
        stateMachine.showStateMachine();
//        System.out.println(stateMachine.generatePlantUML());


    }

    private Condition<InvoiceContext> checkVerificationSuccessCondition() {
        return new Condition<InvoiceContext>() {
            @Override
            public boolean isSatisfied(InvoiceContext invoiceContext) {
                return "success".equals(invoiceContext.getVerificationCondition());
            }
        };
    }
    private Condition<InvoiceContext> checkVerificationFailCondition() {
        return new Condition<InvoiceContext>() {
            @Override
            public boolean isSatisfied(InvoiceContext invoiceContext) {
                return "fail".equals(invoiceContext.getVerificationCondition());
            }
        };
    }

    private Condition<InvoiceContext> checkMatchingInvoiceTaxpayerSuccessCondition() {
        return new Condition<InvoiceContext>() {
            @Override
            public boolean isSatisfied(InvoiceContext invoiceContext) {
                return "success".equals(invoiceContext.getMatchingInvoiceTaxpayerCondition());
            }
        };
    }

    private Condition<InvoiceContext> checkMatchingInvoiceTaxpayerFailCondition() {
        return new Condition<InvoiceContext>() {
            @Override
            public boolean isSatisfied(InvoiceContext invoiceContext) {
                return "fail".equals(invoiceContext.getMatchingInvoiceTaxpayerCondition());
            }
        };
    }
    private Condition<InvoiceContext> checkAutomaticRequisitionCondition() {
        return new Condition<InvoiceContext>() {
            @Override
            public boolean isSatisfied(InvoiceContext invoiceContext) {
                return "fail".equals(invoiceContext.getAutomaticRequisitionCondition());
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
