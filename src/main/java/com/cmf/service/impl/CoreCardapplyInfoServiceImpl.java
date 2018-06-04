package com.cmf.service.impl;

import com.cmf.domain.CoreCardapplyInfo;
import com.cmf.repository.CoreCardapplyInfoDao;
import com.cmf.service.CoreCardapplyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreCardapplyInfoServiceImpl implements CoreCardapplyInfoService {
    @Autowired
    private CoreCardapplyInfoDao coreCardapplyInfoDao;
    @Override
    public CoreCardapplyInfo save(CoreCardapplyInfo coreCardapplyInfo) {
        return coreCardapplyInfoDao.save(coreCardapplyInfo);
    }
}
