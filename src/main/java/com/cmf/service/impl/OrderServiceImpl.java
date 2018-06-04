package com.cmf.service.impl;

import com.cmf.domain.CoreOrderInfo;
import com.cmf.repository.OrderInfoDao;
import com.cmf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderInfoDao orderInfoDao;

    @Override
    public CoreOrderInfo save(CoreOrderInfo coreOrderInfo) {
        return orderInfoDao.save(coreOrderInfo);
    }
}
