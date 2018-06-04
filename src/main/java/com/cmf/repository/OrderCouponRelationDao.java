package com.cmf.repository;

import com.cmf.domain.OrderCouponRelation;
import com.cmf.domain.OrderCouponRelationPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCouponRelationDao extends JpaRepository<OrderCouponRelation,OrderCouponRelationPK> {

}
