package com.example.statemachine.job;

/**
 * @author hujin
 */
public class AutomaticRequisitionInvoiceScanJob extends BaseInvoiceJob{

    @Override
    public void execute(String param){
        requisitionInvoice(param);
    }

    public void requisitionInvoice(String param){

    }
}
