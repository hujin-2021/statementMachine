package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;
import com.example.statemachine.context.BaseContext;
import com.example.statemachine.context.MatchingInvoiceTaxpayerInvoiceContext;
import com.example.statemachine.context.VerificationInvoiceContext;
import com.example.statemachine.enums.Events;
import com.example.statemachine.enums.States;
import com.example.statemachine.service.MatchingInvoiceTaxpayerInvoiceService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author hujin
 */
@Service
public class MatchingInvoiceTaxpayerInvoiceServiceImpl implements MatchingInvoiceTaxpayerInvoiceService {
    private HashMap<String,Boolean> matchingTaxpayerConditions=new HashMap<>();
    @Override
    public Condition<BaseContext> matchingInvoiceTaxpayerSuccessCondition() {
        return new Condition<BaseContext>() {
            @Override
            public boolean isSatisfied(BaseContext ctx) {
                if(ctx instanceof MatchingInvoiceTaxpayerInvoiceContext){
                    Boolean sucessFlag=false;
                    if(!matchingTaxpayerConditions.containsKey("key_generated_by_ctx"+((MatchingInvoiceTaxpayerInvoiceContext) ctx).getMatchingReferenceId())){
                        checkMatchingResult((MatchingInvoiceTaxpayerInvoiceContext) ctx);
                    }
                    sucessFlag=matchingTaxpayerConditions.get("key_generated_by_ctx"+((MatchingInvoiceTaxpayerInvoiceContext) ctx).getMatchingReferenceId());
                    return sucessFlag;
                }else{
                    return false;
                }
            }
        };
    }

    public void checkMatchingResult(MatchingInvoiceTaxpayerInvoiceContext ctx){
        if("matchingSuccess".equals(ctx.getCondition())){
            matchingTaxpayerConditions.put("key_generated_by_ctx"+ctx.getMatchingReferenceId(),true);
            System.out.println("匹配结果为成功");
        }else{
            matchingTaxpayerConditions.put("key_generated_by_ctx"+ctx.getMatchingReferenceId(),false);
            System.out.println("匹配结果为失败");
        }
    }


    @Override
    public Condition<BaseContext> matchingInvoiceTaxpayerFailCondition() {
        return new Condition<BaseContext>() {
            @Override
            public boolean isSatisfied(BaseContext ctx) {
                if(ctx instanceof MatchingInvoiceTaxpayerInvoiceContext){
                    Boolean failFlag=false;
                    if(!matchingTaxpayerConditions.containsKey("key_generated_by_ctx"+((MatchingInvoiceTaxpayerInvoiceContext) ctx).getMatchingReferenceId())){
                        checkMatchingResult((MatchingInvoiceTaxpayerInvoiceContext) ctx);
                    }
                    failFlag=matchingTaxpayerConditions.get("key_generated_by_ctx"+((MatchingInvoiceTaxpayerInvoiceContext) ctx).getMatchingReferenceId());
                    return !failFlag;
                }else{
                    return false;
                }
            }
        };
    }

    @Override
    public Action<States, Events, BaseContext> matchingSuccessAction() {
        return (from, to, event, ctx) -> {
            System.out.println(
                    " from:" + from + " to:" + to + " on:" + event);
            writeDbAndLog();
        };
    }

    @Override
    public Action<States, Events, BaseContext> matchingFailAction() {
        return (from, to, event, ctx) -> {
            System.out.println(
                    " from:" + from + " to:" + to + " on:" + event);
            cleanFailData();
        };
    }

    public void writeDbAndLog(){
        System.out.println("写匹配数据库、日志成功");
    }

    public void cleanFailData(){
        System.out.println("匹配失败后的各种通知");
    }

}
