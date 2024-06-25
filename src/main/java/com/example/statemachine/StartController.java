package com.example.statemachine;

import com.example.statemachine.job.VerificationInvoiceScanJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author hujin
 */
@RestController
@RequestMapping("/verification")
public class StartController {
    @Autowired
    VerificationInvoiceScanJob verificationInvoiceScanJob;

    @GetMapping("/test")
    public String testVerify(@RequestParam String param,@RequestParam String refId) {
        verificationInvoiceScanJob.execute(param,refId);
        return "success";
    }
}
