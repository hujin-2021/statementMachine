package com.example.statemachine;

import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;

public class Start {
    public static void main(String[] args) {
        StateMachineBuilder<States, Events, Context> builder = StateMachineBuilderFactory.create();
        builder.externalTransition()
                .from(States.States1)
                .to()
    }
}
