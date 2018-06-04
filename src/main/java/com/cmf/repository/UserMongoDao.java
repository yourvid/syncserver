package com.cmf.repository;

import com.cmf.domain.CoreUserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Description: 类描述
 * @Author: yaowei
 * @CreateDate: 2018/5/5 23:07
 * @Version: v1.0
 */
public interface UserMongoDao extends MongoRepository<CoreUserInfo, Long> {


}
