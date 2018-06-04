package com.cmf.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_coupon_relation")
@IdClass(OrderCouponRelationPK.class)
public class OrderCouponRelation {
    private long orderId;
    private long couponId;

    @Id
    @Column(name = "OrderID", nullable = false)
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "CouponID", nullable = false)
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
        OrderCouponRelation that = (OrderCouponRelation) o;
        return orderId == that.orderId &&
                couponId == that.couponId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, couponId);
    }
}
