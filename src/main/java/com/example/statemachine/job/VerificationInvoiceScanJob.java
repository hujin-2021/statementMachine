package com.example.statemachine.job;

/**
 * @author hujin
 */
public class VerificationInvoiceScanJob extends BaseInvoiceJob{
    @Override
    public void execute(String param){
        verifyInvoice(param);
    }

    public void verifyInvoice(String param){

    }

}
