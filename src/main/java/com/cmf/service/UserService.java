package com.cmf.service;

import com.cmf.domain.CoreUserInfo;

/**
 * Created by yaowei on 2018/5/4.
 */
public interface UserService {

    Long getMaxUserId();


    CoreUserInfo save(CoreUserInfo userInfo);

}
