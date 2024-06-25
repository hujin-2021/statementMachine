package com.example.statemachine.context;

/**
 * @author hujin
 */
public class AutomaticRequisitionInvoiceContext extends BaseContext{
    private String automaticRequisitionCondition;

    public AutomaticRequisitionInvoiceContext(String automaticRequisitionCondition) {
        this.automaticRequisitionCondition = automaticRequisitionCondition;
    }

    public String getAutomaticRequisitionCondition() {
        return automaticRequisitionCondition;
    }

    public void setAutomaticRequisitionCondition(String automaticRequisitionCondition) {
        this.automaticRequisitionCondition = automaticRequisitionCondition;
    }

    @Override
    public String getCondition() {
        return getAutomaticRequisitionCondition();
    }
}
