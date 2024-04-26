package com.example.ThucTapLTS.dto;

import java.util.List;

public class BillDTO {
    private String name;

    private String createTime;

    private String updateTime;

    private double totalMoney;

    private String tradingCode;

    private boolean isActive;

    private int billStatusId;

    private int promotionId;

    private int customerId;

    private List<BillFoodDTO> billFoodDTOList;

    private List<BillTicketDTO> billTicketDTOList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getTradingCode() {
        return tradingCode;
    }

    public void setTradingCode(String tradingCode) {
        this.tradingCode = tradingCode;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getBillStatusId() {
        return billStatusId;
    }

    public void setBillStatusId(int billStatusId) {
        this.billStatusId = billStatusId;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<BillFoodDTO> getBillFoodDTOList() {
        return billFoodDTOList;
    }

    public void setBillFoodDTOList(List<BillFoodDTO> billFoodDTOList) {
        this.billFoodDTOList = billFoodDTOList;
    }

    public List<BillTicketDTO> getBillTicketDTOList() {
        return billTicketDTOList;
    }

    public void setBillTicketDTOList(List<BillTicketDTO> billTicketDTOList) {
        this.billTicketDTOList = billTicketDTOList;
    }
}
