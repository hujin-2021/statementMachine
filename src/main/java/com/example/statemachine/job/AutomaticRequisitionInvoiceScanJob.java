package com.example.statemachine.job;

import com.alibaba.cola.statemachine.StateMachine;
import com.example.statemachine.context.AutomaticRequisitionInvoiceContext;
import com.example.statemachine.context.BaseContext;
import com.example.statemachine.context.MatchingInvoiceTaxpayerInvoiceContext;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hujin
 */

@Component
public class AutomaticRequisitionInvoiceScanJob extends BaseInvoiceJob{

    @Autowired
    StateMachine<States, Events, BaseContext> stateMachine;
    @Override
    public void execute(String param,String refId){
        AutomaticRequisitionInvoiceContext matchingCtx=new AutomaticRequisitionInvoiceContext(param,refId);
        //为verifiyCtx设置更多需要用到的属性..包括这次校验的发票infoIdList
        stateMachine.fireEvent(States.ToBeAutoUsed, Events.AutomaticRequisitionInvoice, matchingCtx);

    }


}
