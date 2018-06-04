package com.cmf.service.impl;

import com.cmf.domain.CoreExpressRecord;
import com.cmf.repository.CoreExpressRecordDao;
import com.cmf.service.CoreExpressRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreExpressRecordServiceImpl implements CoreExpressRecordService {
    @Autowired
    private CoreExpressRecordDao coreExpressRecordDao;

    @Override
    public CoreExpressRecord save(CoreExpressRecord coreExpressRecord) {
        return coreExpressRecordDao.save(coreExpressRecord);
    }
}
