package com.cmf.controller;

import com.alibaba.fastjson.JSON;
import com.cmf.base.ResponseModel;
import com.cmf.domain.CoreBdEquipType;
import com.cmf.service.CoreBdEquipTypeService;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "coreBdEquipType")
public class CoreBdEquipTypeController {
    private CoreBdEquipTypeService coreBdEquipTypeService;

    @RequestMapping(value = "/save")
    public ResponseModel save(String data) throws HandlerException {
        ResponseModel responseModel = new ResponseModel();
        CoreBdEquipType orderInfo = JSON.parseObject(data, CoreBdEquipType.class);
        CoreBdEquipType reorder = coreBdEquipTypeService.save(orderInfo);
        responseModel.setData(reorder);
        return responseModel;
    }
}
