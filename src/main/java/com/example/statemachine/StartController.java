package com.example.statemachine;

import com.alibaba.cola.statemachine.StateMachine;
import com.example.statemachine.context.BaseContext;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;
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

    @Autowired
    StateMachine<States, Events, BaseContext> stateMachine;

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

    @GetMapping("/uml")
    public String testRequisition() {
        String plantUML = stateMachine.generatePlantUML();
        return plantUML;
    }
}
