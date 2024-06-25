package com.example.statemachine.job;

import com.alibaba.cola.statemachine.StateMachine;
import com.example.statemachine.context.BaseContext;
import com.example.statemachine.context.VerificationInvoiceContext;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;
import com.example.statemachine.service.VerificationInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hujin
 */
@Component
public class VerificationInvoiceScanJob extends BaseInvoiceJob{
    @Autowired
    StateMachine<States, Events, BaseContext> stateMachine;

    @Autowired
    VerificationInvoiceService verificationInvoiceService;
    @Override
    public void execute(String param,String refId){
        VerificationInvoiceContext verifiyCtx=new VerificationInvoiceContext(param,refId);
        //为verifiyCtx设置更多需要用到的属性..包括这次校验的发票infoIdList
        stateMachine.fireEvent(States.ToBeVerified, Events.VerificationInvoice, verifiyCtx);
    }

}
