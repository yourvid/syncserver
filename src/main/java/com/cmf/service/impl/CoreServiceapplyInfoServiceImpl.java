package com.cmf.service.impl;

import com.cmf.domain.CoreServiceapplyInfo;
import com.cmf.repository.CoreServiceapplyInfoDao;
import com.cmf.service.CoreServiceapplyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreServiceapplyInfoServiceImpl implements CoreServiceapplyInfoService {
    @Autowired
    private CoreServiceapplyInfoDao coreServiceapplyInfoDao;

    @Override
    public CoreServiceapplyInfo save(CoreServiceapplyInfo coreServiceapplyInfo) {
        return coreServiceapplyInfoDao.save(coreServiceapplyInfo);
    }
}
