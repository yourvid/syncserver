package com.cmf.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "core_cardapply_info")
public class CoreCardapplyInfo {
    private long id;
    private String applyNum;
    private Long orderId;
    private Long userId;
    private Integer cardType;
    private Integer unitCardNumber;
    private Integer serviceFrequency;
    private Integer communicationLevel;
    private String mainUsage;
    private String detectionUrl;
    private Integer number;
    private Integer yearLimit;
    private Byte delFlag;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ApplyNum", nullable = true, length = 32)
    public String getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(String applyNum) {
        this.applyNum = applyNum;
    }

    @Basic
    @Column(name = "OrderID", nullable = true)
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
    @Column(name = "CardType", nullable = true)
    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    @Basic
    @Column(name = "UnitCardNumber", nullable = true)
    public Integer getUnitCardNumber() {
        return unitCardNumber;
    }

    public void setUnitCardNumber(Integer unitCardNumber) {
        this.unitCardNumber = unitCardNumber;
    }

    @Basic
    @Column(name = "ServiceFrequency", nullable = true)
    public Integer getServiceFrequency() {
        return serviceFrequency;
    }

    public void setServiceFrequency(Integer serviceFrequency) {
        this.serviceFrequency = serviceFrequency;
    }

    @Basic
    @Column(name = "CommunicationLevel", nullable = true)
    public Integer getCommunicationLevel() {
        return communicationLevel;
    }

    public void setCommunicationLevel(Integer communicationLevel) {
        this.communicationLevel = communicationLevel;
    }

    @Basic
    @Column(name = "MainUsage", nullable = true, length = 100)
    public String getMainUsage() {
        return mainUsage;
    }

    public void setMainUsage(String mainUsage) {
        this.mainUsage = mainUsage;
    }

    @Basic
    @Column(name = "DetectionUrl", nullable = true, length = 1000)
    public String getDetectionUrl() {
        return detectionUrl;
    }

    public void setDetectionUrl(String detectionUrl) {
        this.detectionUrl = detectionUrl;
    }

    @Basic
    @Column(name = "Number", nullable = true)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "YearLimit", nullable = true)
    public Integer getYearLimit() {
        return yearLimit;
    }

    public void setYearLimit(Integer yearLimit) {
        this.yearLimit = yearLimit;
    }

    @Basic
    @Column(name = "DelFlag", nullable = true)
    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoreCardapplyInfo that = (CoreCardapplyInfo) o;
        return id == that.id &&
                Objects.equals(applyNum, that.applyNum) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(cardType, that.cardType) &&
                Objects.equals(unitCardNumber, that.unitCardNumber) &&
                Objects.equals(serviceFrequency, that.serviceFrequency) &&
                Objects.equals(communicationLevel, that.communicationLevel) &&
                Objects.equals(mainUsage, that.mainUsage) &&
                Objects.equals(detectionUrl, that.detectionUrl) &&
                Objects.equals(number, that.number) &&
                Objects.equals(yearLimit, that.yearLimit) &&
                Objects.equals(delFlag, that.delFlag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, applyNum, orderId, userId, cardType, unitCardNumber, serviceFrequency, communicationLevel, mainUsage, detectionUrl, number, yearLimit, delFlag);
    }
}
