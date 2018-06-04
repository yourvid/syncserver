package com.cmf.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "core_express_record")
public class CoreExpressRecord {
    private long id;
    private Byte cargoType;
    private String addressStr;
    private String expressNum;
    private Byte expressType;
    private Timestamp recvTime;
    private Byte recvType;
    private Timestamp sendTime;

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
    @Column(name = "CargoType", nullable = true)
    public Byte getCargoType() {
        return cargoType;
    }

    public void setCargoType(Byte cargoType) {
        this.cargoType = cargoType;
    }

    @Basic
    @Column(name = "AddressStr", nullable = true, length = 255)
    public String getAddressStr() {
        return addressStr;
    }

    public void setAddressStr(String addressStr) {
        this.addressStr = addressStr;
    }

    @Basic
    @Column(name = "ExpressNum", nullable = true, length = 255)
    public String getExpressNum() {
        return expressNum;
    }

    public void setExpressNum(String expressNum) {
        this.expressNum = expressNum;
    }

    @Basic
    @Column(name = "ExpressType", nullable = true)
    public Byte getExpressType() {
        return expressType;
    }

    public void setExpressType(Byte expressType) {
        this.expressType = expressType;
    }

    @Basic
    @Column(name = "RecvTime", nullable = true)
    public Timestamp getRecvTime() {
        return recvTime;
    }

    public void setRecvTime(Timestamp recvTime) {
        this.recvTime = recvTime;
    }

    @Basic
    @Column(name = "RecvType", nullable = true)
    public Byte getRecvType() {
        return recvType;
    }

    public void setRecvType(Byte recvType) {
        this.recvType = recvType;
    }

    @Basic
    @Column(name = "SendTime", nullable = true)
    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoreExpressRecord that = (CoreExpressRecord) o;
        return id == that.id &&
                Objects.equals(cargoType, that.cargoType) &&
                Objects.equals(addressStr, that.addressStr) &&
                Objects.equals(expressNum, that.expressNum) &&
                Objects.equals(expressType, that.expressType) &&
                Objects.equals(recvTime, that.recvTime) &&
                Objects.equals(recvType, that.recvType) &&
                Objects.equals(sendTime, that.sendTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cargoType, addressStr, expressNum, expressType, recvTime, recvType, sendTime);
    }
}
