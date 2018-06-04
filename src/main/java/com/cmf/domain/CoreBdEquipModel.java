package com.cmf.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "core_bd_equip_model")
public class CoreBdEquipModel {
    private long ID;
    private String equipModelId;
    private String equipModelName;
    private String equipTypeId;
    private String equipDigest;
    private String equipDesc;
    private String equipImage;
    private Double equipPrice;
    private String equipFunc;
    private String equipScen;
    private Integer status;
    private Long factoryId;
    private Timestamp upTime;
    private Timestamp downTime;
    private String downReason;
    private Integer modelType;

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return ID;
    }

    public void setId(long ID) {
        this.ID = ID;
    }

    @Basic
    @Column(name = "EquipModelID", nullable = false, length = 64)
    public String getEquipModelId() {
        return equipModelId;
    }

    public void setEquipModelId(String equipModelId) {
        this.equipModelId = equipModelId;
    }

    @Basic
    @Column(name = "EquipModelName", nullable = true, length = 32)
    public String getEquipModelName() {
        return equipModelName;
    }

    public void setEquipModelName(String equipModelName) {
        this.equipModelName = equipModelName;
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
    @Column(name = "EquipDigest", nullable = true, length = 100)
    public String getEquipDigest() {
        return equipDigest;
    }

    public void setEquipDigest(String equipDigest) {
        this.equipDigest = equipDigest;
    }

    @Basic
    @Column(name = "EquipDesc", nullable = true, length = 500)
    public String getEquipDesc() {
        return equipDesc;
    }

    public void setEquipDesc(String equipDesc) {
        this.equipDesc = equipDesc;
    }

    @Basic
    @Column(name = "EquipImage", nullable = true, length = 500)
    public String getEquipImage() {
        return equipImage;
    }

    public void setEquipImage(String equipImage) {
        this.equipImage = equipImage;
    }

    @Basic
    @Column(name = "EquipPrice", nullable = true, precision = 2)
    public Double getEquipPrice() {
        return equipPrice;
    }

    public void setEquipPrice(Double equipPrice) {
        this.equipPrice = equipPrice;
    }

    @Basic
    @Column(name = "EquipFunc", nullable = true, length = 5000)
    public String getEquipFunc() {
        return equipFunc;
    }

    public void setEquipFunc(String equipFunc) {
        this.equipFunc = equipFunc;
    }

    @Basic
    @Column(name = "EquipScen", nullable = true, length = 5000)
    public String getEquipScen() {
        return equipScen;
    }

    public void setEquipScen(String equipScen) {
        this.equipScen = equipScen;
    }

    @Basic
    @Column(name = "Status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "FactoryID", nullable = true)
    public Long getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
    }

    @Basic
    @Column(name = "UpTime", nullable = true)
    public Timestamp getUpTime() {
        return upTime;
    }

    public void setUpTime(Timestamp upTime) {
        this.upTime = upTime;
    }

    @Basic
    @Column(name = "DownTime", nullable = true)
    public Timestamp getDownTime() {
        return downTime;
    }

    public void setDownTime(Timestamp downTime) {
        this.downTime = downTime;
    }

    @Basic
    @Column(name = "DownReason", nullable = true, length = 255)
    public String getDownReason() {
        return downReason;
    }

    public void setDownReason(String downReason) {
        this.downReason = downReason;
    }

    @Basic
    @Column(name = "ModelType", nullable = true)
    public Integer getModelType() {
        return modelType;
    }

    public void setModelType(Integer modelType) {
        this.modelType = modelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoreBdEquipModel that = (CoreBdEquipModel) o;
        return ID == that.ID &&
                Objects.equals(equipModelId, that.equipModelId) &&
                Objects.equals(equipModelName, that.equipModelName) &&
                Objects.equals(equipTypeId, that.equipTypeId) &&
                Objects.equals(equipDigest, that.equipDigest) &&
                Objects.equals(equipDesc, that.equipDesc) &&
                Objects.equals(equipImage, that.equipImage) &&
                Objects.equals(equipPrice, that.equipPrice) &&
                Objects.equals(equipFunc, that.equipFunc) &&
                Objects.equals(equipScen, that.equipScen) &&
                Objects.equals(status, that.status) &&
                Objects.equals(factoryId, that.factoryId) &&
                Objects.equals(upTime, that.upTime) &&
                Objects.equals(downTime, that.downTime) &&
                Objects.equals(downReason, that.downReason) &&
                Objects.equals(modelType, that.modelType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, equipModelId, equipModelName, equipTypeId, equipDigest, equipDesc, equipImage, equipPrice, equipFunc, equipScen, status, factoryId, upTime, downTime, downReason, modelType);
    }
}
