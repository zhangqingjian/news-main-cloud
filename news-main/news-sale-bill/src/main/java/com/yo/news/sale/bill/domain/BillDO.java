package com.yo.news.sale.bill.domain;

import java.math.BigDecimal;

public class BillDO {
    private String billId;

    private String orderId;

    private String buyerInstId;

    private String buyerId;

    private String sellerInstId;

    private Byte payType;

    private String pay3rdId;

    private BigDecimal price;

    private Integer createdTime;

    private Integer payTime;

    private Byte checkStatus;

    private Byte previousPayType;

    private String remark;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getBuyerInstId() {
        return buyerInstId;
    }

    public void setBuyerInstId(String buyerInstId) {
        this.buyerInstId = buyerInstId == null ? null : buyerInstId.trim();
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
    }

    public String getSellerInstId() {
        return sellerInstId;
    }

    public void setSellerInstId(String sellerInstId) {
        this.sellerInstId = sellerInstId == null ? null : sellerInstId.trim();
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public String getPay3rdId() {
        return pay3rdId;
    }

    public void setPay3rdId(String pay3rdId) {
        this.pay3rdId = pay3rdId == null ? null : pay3rdId.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Integer createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public Byte getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Byte checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Byte getPreviousPayType() {
        return previousPayType;
    }

    public void setPreviousPayType(Byte previousPayType) {
        this.previousPayType = previousPayType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}