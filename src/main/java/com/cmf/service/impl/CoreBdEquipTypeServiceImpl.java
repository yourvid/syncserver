package com.cmf.service.impl;

import com.cmf.domain.CoreBdEquipType;
import com.cmf.repository.CoreBdEquipTypeDao;
import com.cmf.service.CoreBdEquipTypeService;
import org.springframework.stereotype.Service;

@Service
public class CoreBdEquipTypeServiceImpl implements CoreBdEquipTypeService {
    private CoreBdEquipTypeDao coreBdEquipTypeDao;


    @Override
    public CoreBdEquipType save(CoreBdEquipType coreBdEquipType) {
        return coreBdEquipTypeDao.save(coreBdEquipType);
    }
}
