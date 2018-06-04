package com.cmf.controller;

import com.alibaba.fastjson.JSON;
import com.cmf.base.ResponseModel;
import com.cmf.domain.CoreOrderInfo;
import com.cmf.domain.CoreUserInfo;
import com.cmf.service.UserService;
import com.cmf.utils.TimestampTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * Created by yaowei on 2018/5/4.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;



    /**
     * 获取下一个用户ID
     * @return
     */
    @RequestMapping(value = "/getNextUserId")
    public ResponseModel getNextUserId() {
        ResponseModel responseModel = new ResponseModel();
        Long id = userService.getMaxUserId()+1;
        responseModel.setData(id);
        return responseModel;
    }

    /**
     * 注册用户
     * @param data
     * @return
     */
    @RequestMapping(value = "/save")
    public ResponseModel save(String data) throws HandlerException {
        ResponseModel responseModel = new ResponseModel();
        CoreUserInfo userInfo = JSON.parseObject(data,CoreUserInfo.class);
        CoreUserInfo reuser = userService.save(userInfo);
        responseModel.setData(reuser);
        return responseModel;
    }





}
