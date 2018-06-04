package com.cmf.controller;

import com.alibaba.fastjson.JSON;
import com.cmf.base.ResponseModel;
import com.cmf.domain.CoreExpressRecord;
import com.cmf.service.CoreExpressRecordService;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "expressRecord")
public class CoreExpressRecordController {
    @Autowired
    private CoreExpressRecordService coreExpressRecordService;

    @RequestMapping(value = "/save")
    public ResponseModel save(String data) throws HandlerException {
        ResponseModel responseModel = new ResponseModel();
        CoreExpressRecord orderInfo = JSON.parseObject(data,CoreExpressRecord.class);
        CoreExpressRecord reorder = coreExpressRecordService.save(orderInfo);
        responseModel.setData(reorder);
        return responseModel;
    }

}
