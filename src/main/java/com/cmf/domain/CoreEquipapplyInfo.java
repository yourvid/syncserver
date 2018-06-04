package com.cmf.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "core_equipapply_info")
public class CoreEquipapplyInfo {
    private Long id;
    private String applyNum;
    private Long orderId;
    private Long userId;
    private String equipTypeId;
    private Integer equipNum;
    private Byte delFlag;
    private String equipModelId;

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
    @Column(name = "EquipTypeID", nullable = true, length = 16)
    public String getEquipTypeId() {
        return equipTypeId;
    }

    public void setEquipTypeId(String equipTypeId) {
        this.equipTypeId = equipTypeId;
    }

    @Basic
    @Column(name = "EquipNum", nullable = true)
    public Integer getEquipNum() {
        return equipNum;
    }

    public void setEquipNum(Integer equipNum) {
        this.equipNum = equipNum;
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
    @Column(name = "EquipModelID", nullable = true, length = 16)
    public String getEquipModelId() {
        return equipModelId;
    }

    public void setEquipModelId(String equipModelId) {
        this.equipModelId = equipModelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoreEquipapplyInfo that = (CoreEquipapplyInfo) o;
        return id == that.id &&
                Objects.equals(applyNum, that.applyNum) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(equipTypeId, that.equipTypeId) &&
                Objects.equals(equipNum, that.equipNum) &&
                Objects.equals(delFlag, that.delFlag) &&
                Objects.equals(equipModelId, that.equipModelId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, applyNum, orderId, userId, equipTypeId, equipNum, delFlag, equipModelId);
    }
}
