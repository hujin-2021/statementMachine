package com.example.statemachine.config;


import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import com.example.statemachine.InvoiceContext;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;
import com.example.statemachine.service.AutomaticRequisitionInvoiceService;
import com.example.statemachine.service.MatchingInvoiceTaxpayerInvoiceService;
import com.example.statemachine.service.VerificationInvoiceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hujin
 */
@Configuration
public class StateMachineConfig {
    private VerificationInvoiceService verificationInvoiceService;

    private MatchingInvoiceTaxpayerInvoiceService matchingInvoiceTaxpayerInvoiceService;

    private AutomaticRequisitionInvoiceService automaticRequisitionInvoiceService;
    @Bean
    public StateMachine<States, Events,InvoiceContext> stateMachine() {
        StateMachineBuilder<States, Events, InvoiceContext> builder = StateMachineBuilderFactory.create();
        // 在这里配置状态机的状态和事件
        builder.externalTransition()
                .from(States.ToBeVerified)
                .to(States.ToBeMatched)
                .on(Events.VerificationInvoice)
                .when(verificationInvoiceService.verificationSuccessCondition())
                .perform(doAction());

        //待验证->验证失败
        builder.externalTransition()
                .from(States.ToBeVerified)
                .to(States.VerificationFailed)
                .on(Events.VerificationInvoice)
                .when(verificationInvoiceService.verificationFailCondition())
                .perform(doAction());

        //待匹配->待自动领用
        builder.externalTransition()
                .from(States.ToBeMatched)
                .to(States.ToBeAutoUsed)
                .on(Events.MatchingInvoiceTaxpayerInvoice)
                .when(matchingInvoiceTaxpayerInvoiceService.matchingInvoiceTaxpayerSuccessCondition())
                .perform(doAction());

        //待匹配->待手工领用
        builder.externalTransition()
                .from(States.ToBeMatched)
                .to(States.ToBeManuallyUsed)
                .on(Events.MatchingInvoiceTaxpayerInvoice)
                .when(matchingInvoiceTaxpayerInvoiceService.matchingInvoiceTaxpayerFailCondition())
                .perform(doAction());


        //待自动领用->完全领用
        builder.externalTransition()
                .from(States.ToBeAutoUsed)
                .to(States.FullyUsed)
                .on(Events.AutomaticRequisitionInvoice)
                .when(automaticRequisitionInvoiceService.AutomaticRequisitionSuccessCondition())
                .perform(doAction());

        StateMachine<States, Events, InvoiceContext> stateMachine=builder.build("stateMachine1");
        stateMachine.showStateMachine();
        return stateMachine;
    }
}
