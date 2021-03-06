package com.cmf.controller;

import com.alibaba.fastjson.JSON;
import com.cmf.base.ResponseModel;
import com.cmf.domain.CoreBdEquipInfo;
import com.cmf.service.CoreBdEquipInfoService;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coreBdEquipInfo")
public class CoreBdEquipInfoController {


    @Autowired
    private CoreBdEquipInfoService coreBdEquipInfoService;

    @RequestMapping(value = "/save")
    public ResponseModel save(String data) throws HandlerException {
        ResponseModel responseModel = new ResponseModel();
        CoreBdEquipInfo orderInfo = JSON.parseObject(data, CoreBdEquipInfo.class);
        CoreBdEquipInfo reorder = coreBdEquipInfoService.save(orderInfo);
        responseModel.setData(reorder);
        return responseModel;
    }

}
