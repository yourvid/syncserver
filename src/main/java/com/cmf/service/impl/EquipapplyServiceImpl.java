package com.cmf.service.impl;

import com.cmf.domain.CoreEquipapplyInfo;
import com.cmf.repository.EquipapplyDao;
import com.cmf.service.EquipapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("equipapplyService")
@Transactional
public class EquipapplyServiceImpl implements EquipapplyService {
    @Autowired
    private EquipapplyDao equipapplyDao;

    @Override
    public CoreEquipapplyInfo save(CoreEquipapplyInfo coreEquipapplyInfo) {
        return equipapplyDao.save(coreEquipapplyInfo);
    }
}
