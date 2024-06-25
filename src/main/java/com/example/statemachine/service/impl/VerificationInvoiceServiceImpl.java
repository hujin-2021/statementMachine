package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;
import com.alibaba.cola.statemachine.StateMachine;
import com.example.statemachine.InvoiceContext;
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
    private HashMap<String,Boolean> conditions=new HashMap<>();

    @Autowired
    private StateMachine<States, Events,BaseContext> stateMachine;
    @Override
    public Condition<BaseContext> verificationSuccessCondition() {
        return new Condition<BaseContext>() {
            @Override
            public boolean isSatisfied(BaseContext ctx) {
                if(ctx instanceof VerificationInvoiceContext){
                    Boolean sucessFlag=false;
                    System.out.println("根据context的参数去执行流转过程的处理，最终更改ctx里的标志位表明结果");
                    if(!conditions.containsKey("key_generated_by_ctx")){
                        checkVerificationResult((VerificationInvoiceContext) ctx);
                    }
                    sucessFlag=conditions.get("key_generated_by_ctx");
                    return sucessFlag;
                }else{
                    return false;
                }
            }
        };
    }
    public void checkVerificationResult(VerificationInvoiceContext ctx){
        //执行发票校验的各种流程，并将结果保存到map
        conditions.put("key_generated_by_ctx",true);
        System.out.println("校验结果为成功");
    }

    @Override
    public Condition<BaseContext> verificationFailCondition() {
        return new Condition<BaseContext>() {
            @Override
            public boolean isSatisfied(BaseContext ctx) {
                if(ctx instanceof VerificationInvoiceContext){
                    return "verificationFail".equals(ctx.getCondition());
                }else{
                    return false;
                }
            }
        };
    }

    @Override
    public void verifyInvoice(String param) {
        VerificationInvoiceContext verifiyCtx=new VerificationInvoiceContext("verificationFail");
        //为verifiyCtx设置更多需要用到的属性
        stateMachine.fireEvent(States.ToBeVerified, Events.VerificationInvoice, verifiyCtx);
    }


    public Action<States, Events, BaseContext> verificationSuccessAction() {
        return (from, to, event, ctx) -> {
            System.out.println(
                    " from:" + from + " to:" + to + " on:" + event);
            System.out.println("开始保存数据、保存日志、将状态保存到数据库");
            writeDbAndLog();
        };
    }

    public void writeDbAndLog(){
        System.out.println("写数据库、日志成功");
    }

}
