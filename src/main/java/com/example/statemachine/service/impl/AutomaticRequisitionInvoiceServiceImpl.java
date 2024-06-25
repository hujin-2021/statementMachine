package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;
import com.example.statemachine.context.AutomaticRequisitionInvoiceContext;
import com.example.statemachine.context.BaseContext;
import com.example.statemachine.context.VerificationInvoiceContext;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;
import com.example.statemachine.service.AutomaticRequisitionInvoiceService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author hujin
 */
@Service
public class AutomaticRequisitionInvoiceServiceImpl implements AutomaticRequisitionInvoiceService {
    private HashMap<String,Boolean> automaticRequisitionConditions=new HashMap<>();
    @Override
    public Condition<BaseContext> AutomaticRequisitionSuccessCondition() {
        return new Condition<BaseContext>() {
            @Override
            public boolean isSatisfied(BaseContext ctx) {
                if(ctx instanceof AutomaticRequisitionInvoiceContext){
                    Boolean sucessFlag=false;
                    if(!automaticRequisitionConditions.containsKey("key_generated_by_ctx"+((AutomaticRequisitionInvoiceContext) ctx).getAutomaticRequisitionReferenceId())){
                        checkRequisitionResult((AutomaticRequisitionInvoiceContext) ctx);
                    }
                    sucessFlag=automaticRequisitionConditions.get("key_generated_by_ctx"+((AutomaticRequisitionInvoiceContext) ctx).getAutomaticRequisitionReferenceId());
                    return sucessFlag;
                }else{
                    return false;
                }
            }
        };
    }

    public void checkRequisitionResult(AutomaticRequisitionInvoiceContext ctx){
        if("requisitionSuccess".equals(ctx.getCondition())){
            automaticRequisitionConditions.put("key_generated_by_ctx"+ctx.getAutomaticRequisitionReferenceId(),true);
            System.out.println("自动领用结果为成功");
        }else{
            automaticRequisitionConditions.put("key_generated_by_ctx"+ctx.getAutomaticRequisitionReferenceId(),false);
            System.out.println("自动领用结果为失败");
        }

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

    public Action<States, Events, BaseContext> automaticRequisitionSuccessAction() {
        return (from, to, event, ctx) -> {
            System.out.println(
                    " from:" + from + " to:" + to + " on:" + event);
            writeDbAndLog();
        };
    }

    public void writeDbAndLog(){
        System.out.println("写自动领用数据库、日志成功");
    }
}
