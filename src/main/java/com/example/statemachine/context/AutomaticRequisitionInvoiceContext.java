package com.example.statemachine.context;

/**
 * @author hujin
 */
public class AutomaticRequisitionInvoiceContext extends BaseContext{
    private String automaticRequisitionCondition;

    private String automaticRequisitionReferenceId;

    public String getAutomaticRequisitionReferenceId() {
        return automaticRequisitionReferenceId;
    }

    public void setAutomaticRequisitionReferenceId(String automaticRequisitionReferenceId) {
        this.automaticRequisitionReferenceId = automaticRequisitionReferenceId;
    }

    public AutomaticRequisitionInvoiceContext(String automaticRequisitionCondition,String automaticRequisitionReferenceId) {
        this.automaticRequisitionCondition = automaticRequisitionCondition;
        this.automaticRequisitionReferenceId=automaticRequisitionReferenceId;
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
