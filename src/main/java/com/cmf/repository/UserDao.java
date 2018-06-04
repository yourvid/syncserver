package com.cmf.repository;

import com.cmf.domain.CoreUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by yaowei on 2018/5/4.
 */
public interface UserDao extends JpaRepository<CoreUserInfo, Long> {

    @Query("select max(u.userID) from CoreUserInfo u")
    Long getMaxUserId();

}
