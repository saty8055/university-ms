package com.hss.ums.entity.bean;

import com.hss.ums.entity.FundRaiser;
import org.springframework.beans.BeanUtils;

public class FundRaiserDto {

    public FundRaiserDto() {}

    public FundRaiserDto(FundRaiser raiser){
        BeanUtils.copyProperties(raiser, this);
    }

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
