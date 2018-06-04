package com.cmf.controller;

import com.alibaba.fastjson.JSON;
import com.cmf.base.ResponseModel;
import com.cmf.domain.CoreCardapplyInfo;
import com.cmf.service.CoreCardapplyInfoService;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "cardApply")
public class CoreCardapplyInfoController {
    @Autowired
    private CoreCardapplyInfoService coreCardapplyInfoService;
    @RequestMapping(value = "/save")
    public ResponseModel save(String data) throws HandlerException {
        ResponseModel responseModel = new ResponseModel();
        CoreCardapplyInfo orderInfo = JSON.parseObject(data,CoreCardapplyInfo.class);
        CoreCardapplyInfo reorder = coreCardapplyInfoService.save(orderInfo);
        responseModel.setData(reorder);
        return responseModel;
    }

}
