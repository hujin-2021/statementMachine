package com.example.statemachine.job;

/**
 * @author hujin
 */
public class MatchingInvoiceTaxpayerInvoiceScanJob extends BaseInvoiceJob{

    @Override
    public void execute(String param){
        matchingInvoiceInvoice(param);
    }

    public void matchingInvoiceInvoice(String param){

    }
}
