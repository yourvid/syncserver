package com.cmf.fastdfs.pool;

import com.cmf.fastdfs.FastDFSTemplateFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.csource.fastdfs.StorageClient1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * FastDFS 连接池工厂
 */
@Component
public class ConnectionPoolFactory {
    @Resource
    private FastDFSTemplateFactory fastDFSTemplateFactory;
    @Value("${fastdfs.max_total}")
    private int maxTotal;
    @Value("${fastdfs.max_idle}")
    private int maxIdle;
    @Value("${fastdfs.min_idle}")
    private int minIdle;

    private GenericObjectPool<StorageClient1> pool;
    private GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();

    @PostConstruct
    public void init() {
        initPoolConfig();
        pool = new GenericObjectPool<>(new ConnectionFactory(fastDFSTemplateFactory),genericObjectPoolConfig);
    }

    private void initPoolConfig() {
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMinIdle(minIdle);
        genericObjectPoolConfig.setMaxTotal(maxTotal);
    }

    public StorageClient1 getClient() throws Exception {
        return pool.borrowObject();
    }

    public void releaseConnection(StorageClient1 client) {
        try {
            pool.returnObject(client);
        } catch (Exception ignored) {
        }
    }
}