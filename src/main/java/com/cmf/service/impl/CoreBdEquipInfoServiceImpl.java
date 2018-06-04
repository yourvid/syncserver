package com.cmf.service.impl;

import com.cmf.domain.CoreBdEquipInfo;
import com.cmf.repository.CoreBdEquipInfoDao;
import com.cmf.service.CoreBdEquipInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreBdEquipInfoServiceImpl implements CoreBdEquipInfoService {
    @Autowired
    private CoreBdEquipInfoDao coreBdEquipInfoDao;


    @Override
    public CoreBdEquipInfo save(CoreBdEquipInfo coreBdEquipInfo) {
        return coreBdEquipInfoDao.save(coreBdEquipInfo);
    }
}
