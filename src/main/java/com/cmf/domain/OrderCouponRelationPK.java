package com.cmf.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OrderCouponRelationPK implements Serializable {
    private long orderId;
    private long couponId;

    @Column(name = "OrderID", nullable = false)
    @Id
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Column(name = "CouponID", nullable = false)
    @Id
    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderCouponRelationPK that = (OrderCouponRelationPK) o;
        return orderId == that.orderId &&
                couponId == that.couponId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, couponId);
    }
}
