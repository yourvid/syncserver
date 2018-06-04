package com.cmf.service.impl;

import com.cmf.domain.CoreBdEquipModel;
import com.cmf.repository.CoreBdEquipModelDao;
import com.cmf.service.CoreBdEquipModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreBdEquipModelServiceImpl implements CoreBdEquipModelService {
    @Autowired
    private CoreBdEquipModelDao coreBdEquipModelDao;


    @Override
    public CoreBdEquipModel save(CoreBdEquipModel coreBdEquipModel) {
        return coreBdEquipModelDao.save(coreBdEquipModel);
    }
}
