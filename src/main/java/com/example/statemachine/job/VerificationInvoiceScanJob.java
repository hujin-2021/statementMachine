package com.example.statemachine.job;

import com.example.statemachine.enums.States;

/**
 * @author hujin
 */
public class VerificationInvoiceScanJob extends BaseInvoiceJob{
    @Override
    public void execute(String param){
        States target = stateMachine.fireEvent(States.STATE2, Events.EVENT1, new Context());

        verifyInvoice(param);
    }

    public void verifyInvoice(String param){

    }

}
