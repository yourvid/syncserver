package com.cmf.controller;

import com.alibaba.fastjson.JSON;
import com.cmf.base.ResponseModel;
import com.cmf.domain.CoreBdEquipModel;
import com.cmf.service.CoreBdEquipModelService;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "coreBdEquipModel")
public class CoreBdEquipModelController {
    
    private CoreBdEquipModelService coreBdEquipModelService;

    @RequestMapping(value = "/save")
    public ResponseModel save(String data) throws HandlerException {
        ResponseModel responseModel = new ResponseModel();
        CoreBdEquipModel orderInfo = JSON.parseObject(data, CoreBdEquipModel.class);
        CoreBdEquipModel reorder = coreBdEquipModelService.save(orderInfo);
        responseModel.setData(reorder);
        return responseModel;
    }
}
