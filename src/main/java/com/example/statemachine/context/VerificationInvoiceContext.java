package com.example.statemachine.context;

/**
 * @author hujin
 */
public class VerificationInvoiceContext extends BaseContext{

    //一些条件，用来执行任务
    private String verificationCondition;

    //流水号，用于将同一个请求多次执行时的结果保存在Map的同一个key里，不同的流水号的请求结果在Map里区分开
    private String verificationReferenceId;
    public String getVerificationCondition() {
        return verificationCondition;
    }

    public String getVerificationReferenceId(){
        return verificationReferenceId;
    }

    public void setVerificationReferenceId(String verificationReferenceId){
        this.verificationReferenceId=verificationReferenceId;
    }

    public void setVerificationCondition(String verificationCondition) {
        this.verificationCondition = verificationCondition;
    }

    public VerificationInvoiceContext(String verificationCondition,String verificationReferenceId) {
        this.verificationCondition = verificationCondition;
        this.verificationReferenceId=verificationReferenceId;
    }

    @Override
    public String getCondition() {
        return getVerificationCondition();
    }
}
