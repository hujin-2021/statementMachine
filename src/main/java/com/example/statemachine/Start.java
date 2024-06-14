package com.example.statemachine;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;
import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;

public class Start {
    public static void main(String[] args) {
        Start start1=new Start();
        start1.start();
    }

    private void start(){
        StateMachineBuilder<States, Events, Context> builder = StateMachineBuilderFactory.create();
        builder.externalTransition()
                .from(States.ToBeVerified)
                .to(States.ToBeMatched)
                .on(Events.VerificationInvoice)
                .when(checkCondition())
                .perform(doAction());
    }

    private Condition<Context> checkCondition() {
        return new Condition<Context>() {
            @Override
            public boolean isSatisfied(Context context) {
                System.out.println("Check condition : " + context);
                return true;
            }
        };
    }

    private Action<States, Events, Context> doAction() {
        return (from, to, event, ctx) -> {
            System.out.println(
                    ctx.operator + " is operating " + ctx.entityId + " from:" + from + " to:" + to + " on:" + event);
        };
    }

}
