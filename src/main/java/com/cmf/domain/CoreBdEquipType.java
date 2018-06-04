package com.cmf.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "core_bd_equip_type")
public class CoreBdEquipType {
    private String equipTypeId;
    private String equipTypeName;
    private String equipDes;

    @Id
    @Column(name = "EquipTypeID", nullable = false, length = 16)
    public String getEquipTypeId() {
        return equipTypeId;
    }

    public void setEquipTypeId(String equipTypeId) {
        this.equipTypeId = equipTypeId;
    }

    @Basic
    @Column(name = "EquipTypeName", nullable = true, length = 32)
    public String getEquipTypeName() {
        return equipTypeName;
    }

    public void setEquipTypeName(String equipTypeName) {
        this.equipTypeName = equipTypeName;
    }

    @Basic
    @Column(name = "EquipDes", nullable = true, length = 256)
    public String getEquipDes() {
        return equipDes;
    }

    public void setEquipDes(String equipDes) {
        this.equipDes = equipDes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoreBdEquipType that = (CoreBdEquipType) o;
        return Objects.equals(equipTypeId, that.equipTypeId) &&
                Objects.equals(equipTypeName, that.equipTypeName) &&
                Objects.equals(equipDes, that.equipDes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(equipTypeId, equipTypeName, equipDes);
    }
}
