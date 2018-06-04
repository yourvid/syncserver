package com.cmf.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "core_serviceapply_info")
public class CoreServiceapplyInfo {
    private long id;
    private String applyNum;
    private Long orderId;
    private Long serviceId;
    private Integer serviceNumber;
    private Integer serviceYear;
    private Long userId;
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
    @Column(name = "ServiceID", nullable = true)
    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "ServiceNumber", nullable = true)
    public Integer getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(Integer serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    @Basic
    @Column(name = "ServiceYear", nullable = true)
    public Integer getServiceYear() {
        return serviceYear;
    }

    public void setServiceYear(Integer serviceYear) {
        this.serviceYear = serviceYear;
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
        CoreServiceapplyInfo that = (CoreServiceapplyInfo) o;
        return id == that.id &&
                Objects.equals(applyNum, that.applyNum) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(serviceId, that.serviceId) &&
                Objects.equals(serviceNumber, that.serviceNumber) &&
                Objects.equals(serviceYear, that.serviceYear) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(delFlag, that.delFlag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, applyNum, orderId, serviceId, serviceNumber, serviceYear, userId, delFlag);
    }
}
