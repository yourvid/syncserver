package com.cmf.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "core_factory_info")
public class CoreFactoryInfo {
    private long ID;
    private String factory;
    private String factoryAlias;
    private String linkName;
    private String linkTel;

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return ID;
    }

    public void setId(long ID) {
        this.ID = ID;
    }

    @Basic
    @Column(name = "Factory", nullable = true, length = 128)
    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    @Basic
    @Column(name = "FactoryAlias", nullable = true, length = 255)
    public String getFactoryAlias() {
        return factoryAlias;
    }

    public void setFactoryAlias(String factoryAlias) {
        this.factoryAlias = factoryAlias;
    }

    @Basic
    @Column(name = "LinkName", nullable = true, length = 255)
    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    @Basic
    @Column(name = "LinkTel", nullable = true, length = 255)
    public String getLinkTel() {
        return linkTel;
    }

    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoreFactoryInfo that = (CoreFactoryInfo) o;
        return ID == that.ID &&
                Objects.equals(factory, that.factory) &&
                Objects.equals(factoryAlias, that.factoryAlias) &&
                Objects.equals(linkName, that.linkName) &&
                Objects.equals(linkTel, that.linkTel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, factory, factoryAlias, linkName, linkTel);
    }
}
