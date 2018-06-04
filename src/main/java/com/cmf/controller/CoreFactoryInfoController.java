package com.cmf.controller;

import com.alibaba.fastjson.JSON;
import com.cmf.base.ResponseModel;
import com.cmf.domain.CoreFactoryInfo;
import com.cmf.service.CoreFactoryInfoService;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "coreFactoryInfo")
public class CoreFactoryInfoController {
    @Autowired
    private CoreFactoryInfoService coreFactoryInfoService;


    @RequestMapping(value = "/save")
    public ResponseModel save(String data) throws HandlerException {
        ResponseModel responseModel = new ResponseModel();
        CoreFactoryInfo orderInfo = JSON.parseObject(data,CoreFactoryInfo.class);
        CoreFactoryInfo reorder = coreFactoryInfoService.save(orderInfo);
        responseModel.setData(reorder);
        return responseModel;
    }


}
