package com.cmf.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "core_order_info")
public class CoreOrderInfo {
    private Long id;
    private String orderNum;
    private Long userId;
    private Double orderAccont;
    private String orderTypeId;
    private String orderStatusId;
    private Byte payWay;
    private Double factAmount;
    private Timestamp orderDate;
    private Long offPayId;
    private String contractCode;
    private Timestamp payDate;
    private Byte dealFlag;
    private Byte delFlag;
    private Long expressId;
    private Byte invoiceReqStatus;
    private Timestamp finishTime;
    private Byte orderAudit;
    private String failureReason;
    private Long invoiceRecordId;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "OrderNum", nullable = true, length = 50)
    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    @Basic
    @Column(name = "UserID", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "OrderAccont", nullable = true, precision = 0)
    public Double getOrderAccont() {
        return orderAccont;
    }

    public void setOrderAccont(Double orderAccont) {
        this.orderAccont = orderAccont;
    }

    @Basic
    @Column(name = "OrderTypeID", nullable = true, length = 16)
    public String getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(String orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    @Basic
    @Column(name = "OrderStatusID", nullable = true, length = 16)
    public String getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(String orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Basic
    @Column(name = "PayWay", nullable = true)
    public Byte getPayWay() {
        return payWay;
    }

    public void setPayWay(Byte payWay) {
        this.payWay = payWay;
    }

    @Basic
    @Column(name = "FactAmount", nullable = true, precision = 0)
    public Double getFactAmount() {
        return factAmount;
    }

    public void setFactAmount(Double factAmount) {
        this.factAmount = factAmount;
    }

    @Basic
    @Column(name = "OrderDate", nullable = true)
    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "OffPayID", nullable = true)
    public Long getOffPayId() {
        return offPayId;
    }

    public void setOffPayId(Long offPayId) {
        this.offPayId = offPayId;
    }

    @Basic
    @Column(name = "ContractCode", nullable = true, length = 1000)
    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    @Basic
    @Column(name = "PayDate", nullable = true)
    public Timestamp getPayDate() {
        return payDate;
    }

    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }

    @Basic
    @Column(name = "DealFlag", nullable = true)
    public Byte getDealFlag() {
        return dealFlag;
    }

    public void setDealFlag(Byte dealFlag) {
        this.dealFlag = dealFlag;
    }

    @Basic
    @Column(name = "DelFlag", nullable = true)
    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    @Basic
    @Column(name = "ExpressID", nullable = true)
    public Long getExpressId() {
        return expressId;
    }

    public void setExpressId(Long expressId) {
        this.expressId = expressId;
    }

    @Basic
    @Column(name = "InvoiceReqStatus", nullable = true)
    public Byte getInvoiceReqStatus() {
        return invoiceReqStatus;
    }

    public void setInvoiceReqStatus(Byte invoiceReqStatus) {
        this.invoiceReqStatus = invoiceReqStatus;
    }

    @Basic
    @Column(name = "FinishTime", nullable = true)
    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "OrderAudit", nullable = true)
    public Byte getOrderAudit() {
        return orderAudit;
    }

    public void setOrderAudit(Byte orderAudit) {
        this.orderAudit = orderAudit;
    }

    @Basic
    @Column(name = "FailureReason", nullable = true, length = 255)
    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    @Basic
    @Column(name = "InvoiceRecordID", nullable = true)
    public Long getInvoiceRecordId() {
        return invoiceRecordId;
    }

    public void setInvoiceRecordId(Long invoiceRecordId) {
        this.invoiceRecordId = invoiceRecordId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoreOrderInfo that = (CoreOrderInfo) o;
        return id == that.id &&
                Objects.equals(orderNum, that.orderNum) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(orderAccont, that.orderAccont) &&
                Objects.equals(orderTypeId, that.orderTypeId) &&
                Objects.equals(orderStatusId, that.orderStatusId) &&
                Objects.equals(payWay, that.payWay) &&
                Objects.equals(factAmount, that.factAmount) &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(offPayId, that.offPayId) &&
                Objects.equals(contractCode, that.contractCode) &&
                Objects.equals(payDate, that.payDate) &&
                Objects.equals(dealFlag, that.dealFlag) &&
                Objects.equals(delFlag, that.delFlag) &&
                Objects.equals(expressId, that.expressId) &&
                Objects.equals(invoiceReqStatus, that.invoiceReqStatus) &&
                Objects.equals(finishTime, that.finishTime) &&
                Objects.equals(orderAudit, that.orderAudit) &&
                Objects.equals(failureReason, that.failureReason) &&
                Objects.equals(invoiceRecordId, that.invoiceRecordId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, orderNum, userId, orderAccont, orderTypeId, orderStatusId, payWay, factAmount, orderDate, offPayId, contractCode, payDate, dealFlag, delFlag, expressId, invoiceReqStatus, finishTime, orderAudit, failureReason, invoiceRecordId);
    }
}
