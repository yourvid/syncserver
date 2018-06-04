package com.cmf.service.impl;

import com.cmf.domain.CoreFactoryInfo;
import com.cmf.repository.CoreFactoryInfoDao;
import com.cmf.service.CoreFactoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreFactoryInfoServiceImpl implements CoreFactoryInfoService {
    @Autowired
    private CoreFactoryInfoDao coreFactoryInfoDao;

    @Override
    public CoreFactoryInfo save(CoreFactoryInfo CoreFactoryInfo) {
        return coreFactoryInfoDao.save(CoreFactoryInfo);
    }
}
