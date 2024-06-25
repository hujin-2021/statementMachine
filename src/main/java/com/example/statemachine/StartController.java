package com.example.statemachine;

import com.example.statemachine.job.AutomaticRequisitionInvoiceScanJob;
import com.example.statemachine.job.MatchingInvoiceTaxpayerInvoiceScanJob;
import com.example.statemachine.job.VerificationInvoiceScanJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author hujin
 */
@RestController
@RequestMapping("/start")
public class StartController {
    @Autowired
    VerificationInvoiceScanJob verificationInvoiceScanJob;

    @Autowired
    MatchingInvoiceTaxpayerInvoiceScanJob matchingInvoiceTaxpayerInvoiceScanJob;

    @Autowired
    AutomaticRequisitionInvoiceScanJob automaticRequisitionInvoiceScanJob;

    @GetMapping("/testverify")
    public String testVerify(@RequestParam String param,@RequestParam String refId) {
        verificationInvoiceScanJob.execute(param,refId);
        return "1";
    }

    @GetMapping("/matching")
    public String testMatching(@RequestParam String param,@RequestParam String refId) {
        matchingInvoiceTaxpayerInvoiceScanJob.execute(param,refId);
        return "1";
    }

    @GetMapping("/requisition")
    public String testRequisition(@RequestParam String param,@RequestParam String refId) {
        automaticRequisitionInvoiceScanJob.execute(param,refId);
        return "1";
    }

}
