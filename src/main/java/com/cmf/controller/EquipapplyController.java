package com.cmf.controller;

import com.alibaba.fastjson.JSON;
import com.cmf.base.ResponseModel;
import com.cmf.domain.CoreEquipapplyInfo;
import com.cmf.service.EquipapplyService;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/equipApply")
public class EquipapplyController {
    @Autowired
    private EquipapplyService equipapplyService;


    @RequestMapping(value = "/save")
    public ResponseModel save(String data) throws HandlerException {
        ResponseModel responseModel = new ResponseModel();
        CoreEquipapplyInfo info = JSON.parseObject(data,CoreEquipapplyInfo.class);
        CoreEquipapplyInfo reinfo = equipapplyService.save(info);
        responseModel.setData(reinfo);
        return responseModel;
    }


}
