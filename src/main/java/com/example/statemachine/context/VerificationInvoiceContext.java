package com.example.statemachine.context;

/**
 * @author hujin
 */
public class VerificationInvoiceContext extends BaseContext{
    private String verificationCondition;

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
