package com.hss.ums.entity;

import com.hss.ums.config.constants.Library;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FundRaiser {

    @Id
    @GeneratedValue(generator = Library.UUID)
    @GenericGenerator(name = Library.UUID, strategy = Library.UUID_2)
    private String fundRaiserId;

    private String remarks, reason;

    private Double amount;

    public String getFundRaiserId() {
        return fundRaiserId;
    }

    public void setFundRaiserId(String fundRaiserId) {
        this.fundRaiserId = fundRaiserId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
