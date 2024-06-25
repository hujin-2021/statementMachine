package com.example.statemachine.context;

/**
 * @author hujin
 */
public class VerificationInvoiceContext extends BaseContext{
    private String verificationCondition;

    public String getVerificationCondition() {
        return verificationCondition;
    }

    public void setVerificationCondition(String verificationCondition) {
        this.verificationCondition = verificationCondition;
    }

    public VerificationInvoiceContext(String verificationCondition) {
        this.verificationCondition = verificationCondition;
    }

    @Override
    public String getCondition() {
        return getVerificationCondition();
    }
}
