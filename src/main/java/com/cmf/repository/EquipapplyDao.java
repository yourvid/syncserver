package com.cmf.repository;

import com.cmf.domain.CoreEquipapplyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipapplyDao extends JpaRepository<CoreEquipapplyInfo, Long> {
}
