package com.example.statemachine.job;

/**
 * @author hujin
 */
public class AutomaticRequisitionInvoiceScanJob extends BaseInvoiceJob{

    @Override
    public void execute(String param,String refId){
        requisitionInvoice(param,refId);
    }

    public void requisitionInvoice(String param,String refId){

    }
}
