package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Condition;
import com.example.statemachine.context.BaseContext;
import com.example.statemachine.context.MatchingInvoiceTaxpayerInvoiceContext;
import com.example.statemachine.service.MatchingInvoiceTaxpayerInvoiceService;
import org.springframework.stereotype.Service;

/**
 * @author hujin
 */
@Service
public class MatchingInvoiceTaxpayerInvoiceServiceImpl implements MatchingInvoiceTaxpayerInvoiceService {
    @Override
    public Condition<BaseContext> matchingInvoiceTaxpayerSuccessCondition() {
        return new Condition<BaseContext>() {
            @Override
            public boolean isSatisfied(BaseContext ctx) {
                if(ctx instanceof MatchingInvoiceTaxpayerInvoiceContext){
                    return "matchingInvoiceTaxpayerSuccess".equals(ctx.getCondition());
                }else {
                    return false;
                }
            }
        };
    }

    @Override
    public Condition<BaseContext> matchingInvoiceTaxpayerFailCondition() {
        return new Condition<BaseContext>() {
            @Override
            public boolean isSatisfied(BaseContext ctx) {
                if(ctx instanceof MatchingInvoiceTaxpayerInvoiceContext){
                    return "matchingInvoiceTaxpayerSuccess".equals(ctx.getCondition());
                }else {
                    return false;
                }
            }
        };
    }
}
