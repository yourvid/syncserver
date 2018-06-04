package com.cmf.repository;

import com.cmf.domain.CoreOrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInfoDao extends JpaRepository<CoreOrderInfo, Long> {
}
