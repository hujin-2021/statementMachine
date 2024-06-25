package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;

import com.example.statemachine.context.BaseContext;
import com.example.statemachine.context.VerificationInvoiceContext;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;
import com.example.statemachine.service.VerificationInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author hujin
 */
@Service
public class VerificationInvoiceServiceImpl implements VerificationInvoiceService {
    private HashMap<String,Boolean> verificationConditions=new HashMap<>();

    @Override
    public Condition<BaseContext> verificationSuccessCondition() {
        return new Condition<BaseContext>() {
            @Override
            public boolean isSatisfied(BaseContext ctx) {
                if(ctx instanceof VerificationInvoiceContext){
                    Boolean sucessFlag=false;
                    if(!verificationConditions.containsKey("key_generated_by_ctx"+((VerificationInvoiceContext) ctx).getVerificationReferenceId())){
                        checkVerificationResult((VerificationInvoiceContext) ctx);
                    }
                    sucessFlag=verificationConditions.get("key_generated_by_ctx"+((VerificationInvoiceContext) ctx).getVerificationReferenceId());
                    return sucessFlag;
                }else{
                    return false;
                }
            }
        };
    }
    public void checkVerificationResult(VerificationInvoiceContext ctx){
        //执行发票校验的各种流程，并将结果保存到map
        if("verificationSuccess".equals(ctx.getCondition())){
            verificationConditions.put("key_generated_by_ctx"+ ctx.getVerificationReferenceId(),true);
            System.out.println("校验结果为成功");
        }else{
            verificationConditions.put("key_generated_by_ctx"+ctx.getVerificationReferenceId(),false);
            System.out.println("校验结果为失败");
        }

    }

    @Override
    public Condition<BaseContext> verificationFailCondition() {
        return new Condition<BaseContext>() {
            @Override
            public boolean isSatisfied(BaseContext ctx) {
                if(ctx instanceof VerificationInvoiceContext){
                    Boolean failFlag=false;
                    if(!verificationConditions.containsKey("key_generated_by_ctx"+((VerificationInvoiceContext) ctx).getVerificationReferenceId())){
                        checkVerificationResult((VerificationInvoiceContext) ctx);
                    }
                    failFlag=verificationConditions.get("key_generated_by_ctx"+((VerificationInvoiceContext) ctx).getVerificationReferenceId());
                    return !failFlag;
                }else{
                    return false;
                }
            }
        };
    }


    public Action<States, Events, BaseContext> verificationSuccessAction() {
        return (from, to, event, ctx) -> {
            System.out.println(
                    " from:" + from + " to:" + to + " on:" + event);
            writeDbAndLog();
        };
    }

    @Override
    public Action<States, Events, BaseContext> verificationFailAction() {
        return (from, to, event, ctx) -> {
            System.out.println(
                    " from:" + from + " to:" + to + " on:" + event);
            cleanFailData();
        };
    }

    public void writeDbAndLog(){
        System.out.println("写数据库、日志成功");
    }

    public void cleanFailData(){
        System.out.println("校验失败后的各种通知");
    }

}
