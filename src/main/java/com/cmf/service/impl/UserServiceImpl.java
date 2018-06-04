package com.cmf.service.impl;

import com.cmf.domain.CoreUserInfo;
import com.cmf.repository.UserDao;
import com.cmf.repository.UserMongoDao;
import com.cmf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by yaowei on 2018/5/4.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMongoDao userMongoDao;
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public Long getMaxUserId() {
        return userDao.getMaxUserId();
    }

    @Override
    public CoreUserInfo save(CoreUserInfo userInfo) {
        return userDao.save(userInfo);
    }
}
