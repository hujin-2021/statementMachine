package com.example.statemachine.job;

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
    VerificationInvoiceService verificationInvoiceService;
    @Override
    public void execute(String param){
        verificationInvoiceService.verifyInvoice(param);
    }

}
