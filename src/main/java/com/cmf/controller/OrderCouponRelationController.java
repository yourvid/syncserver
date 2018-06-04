package com.cmf.controller;

import com.alibaba.fastjson.JSON;
import com.cmf.base.ResponseModel;
import com.cmf.domain.OrderCouponRelation;
import com.cmf.service.OrderCouponRelationService;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orderCouponRelation")
public class OrderCouponRelationController {

    @Autowired
    private OrderCouponRelationService orderCouponRelationService;

    @RequestMapping(value = "/save")
    public ResponseModel save(String data) throws HandlerException {
        ResponseModel responseModel = new ResponseModel();
        OrderCouponRelation info = JSON.parseObject(data,OrderCouponRelation.class);
        OrderCouponRelation reInfo = orderCouponRelationService.save(info);
        responseModel.setData(reInfo);
        return responseModel;
    }
}
