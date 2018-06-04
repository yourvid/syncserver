package com.cmf.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "core_bd_equip_info")
public class CoreBdEquipInfo {
    private long ID;
    private String equipNum;
    private String equipTypeId;
    private String equipModelId;
    private Long userId;
    private Integer salesStatus;
    private Long offUserId;

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return ID;
    }

    public void setId(long ID) {
        this.ID = ID;
    }

    @Basic
    @Column(name = "EquipNum", nullable = true, length = 32)
    public String getEquipNum() {
        return equipNum;
    }

    public void setEquipNum(String equipNum) {
        this.equipNum = equipNum;
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
    @Column(name = "EquipModelID", nullable = true, length = 16)
    public String getEquipModelId() {
        return equipModelId;
    }

    public void setEquipModelId(String equipModelId) {
        this.equipModelId = equipModelId;
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
    @Column(name = "SalesStatus", nullable = true)
    public Integer getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(Integer salesStatus) {
        this.salesStatus = salesStatus;
    }

    @Basic
    @Column(name = "OffUserID", nullable = true)
    public Long getOffUserId() {
        return offUserId;
    }

    public void setOffUserId(Long offUserId) {
        this.offUserId = offUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoreBdEquipInfo that = (CoreBdEquipInfo) o;
        return ID == that.ID &&
                Objects.equals(equipNum, that.equipNum) &&
                Objects.equals(equipTypeId, that.equipTypeId) &&
                Objects.equals(equipModelId, that.equipModelId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(salesStatus, that.salesStatus) &&
                Objects.equals(offUserId, that.offUserId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, equipNum, equipTypeId, equipModelId, userId, salesStatus, offUserId);
    }
}
