package com.cmf.service.impl;

import com.cmf.domain.OrderCouponRelation;
import com.cmf.repository.OrderCouponRelationDao;
import com.cmf.service.OrderCouponRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCouponRelationServiceImpl implements OrderCouponRelationService {
    @Autowired
    private OrderCouponRelationDao orderCouponRelationDao;
    @Override
    public OrderCouponRelation save(OrderCouponRelation orderCouponRelation) {
        return orderCouponRelationDao.save(orderCouponRelation);
    }
}
