package com.hss.ums.entity.bean;

import com.hss.ums.entity.Funds;
import org.springframework.beans.BeanUtils;

public class FundsDto {

    public FundsDto() {}

    public FundsDto(Funds funds){
        BeanUtils.copyProperties(funds, this);
    }

    private String fundId;

    private Double amount;

    private Boolean deposit;

    private String name, remarks;

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getDeposit() {
        return deposit;
    }

    public void setDeposit(Boolean deposit) {
        this.deposit = deposit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
