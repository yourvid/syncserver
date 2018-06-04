package com.cmf.controller;

import com.alibaba.fastjson.JSON;
import com.cmf.base.ResponseModel;
import com.cmf.domain.CoreServiceapplyInfo;
import com.cmf.service.CoreServiceapplyInfoService;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "serviceApply")
public class CoreServiceapplyInfoController {
    @Autowired
    private CoreServiceapplyInfoService coreServiceapplyInfoService;
    @RequestMapping(value = "/save")
    public ResponseModel save(String data) throws HandlerException {
        ResponseModel responseModel = new ResponseModel();
        CoreServiceapplyInfo orderInfo = JSON.parseObject(data,CoreServiceapplyInfo.class);
        CoreServiceapplyInfo reorder = coreServiceapplyInfoService.save(orderInfo);
        responseModel.setData(reorder);
        return responseModel;
    }
}
