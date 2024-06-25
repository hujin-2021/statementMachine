package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Condition;
import com.example.statemachine.context.AutomaticRequisitionInvoiceContext;
import com.example.statemachine.context.BaseContext;
import com.example.statemachine.service.AutomaticRequisitionInvoiceService;
import org.springframework.stereotype.Service;

/**
 * @author hujin
 */
@Service
public class AutomaticRequisitionInvoiceServiceImpl implements AutomaticRequisitionInvoiceService {
    @Override
    public Condition<BaseContext> AutomaticRequisitionSuccessCondition() {
        return new Condition<BaseContext>() {
            @Override
            public boolean isSatisfied(BaseContext ctx) {
                if(ctx instanceof AutomaticRequisitionInvoiceContext){
                    return "automaticRequisitionSuccess".equals(ctx.getCondition());
                }else{
                    return false;
                }
            }
        };
    }

    @Override
    public Condition<BaseContext> AutomaticRequisitionFailCondition() {
        return new Condition<BaseContext>() {
            @Override
            public boolean isSatisfied(BaseContext ctx) {
                if(ctx instanceof AutomaticRequisitionInvoiceContext){
                    return "automaticRequisitionSuccess".equals(ctx.getCondition());
                }else{
                    return false;
                }
            }
        };
    }
}
