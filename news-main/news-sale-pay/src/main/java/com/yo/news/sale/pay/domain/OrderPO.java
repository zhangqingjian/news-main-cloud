package com.yo.news.sale.pay.domain;

import java.math.BigDecimal;

import com.yo.news.sale.framework.domain.BasicDomain;

public class OrderPO extends BasicDomain{
    private String orderId;

    private String buyerInstId;

    private String buyerId;

    private String sellerInstId;

    private BigDecimal price;

    private Byte status;

    private Integer createdTime;

    private Integer payTime;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
}