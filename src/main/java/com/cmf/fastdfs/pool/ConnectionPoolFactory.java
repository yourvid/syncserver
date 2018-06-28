package com.cmf.fastdfs.pool;

import com.cmf.fastdfs.FastDFSTemplateFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.csource.fastdfs.StorageClient1;
import org.springframework.stereotype.Component;

/**
 * FastDFS 连接池工厂
 */
@Component
public class ConnectionPoolFactory {

    private GenericObjectPool<StorageClient1> pool;


    public ConnectionPoolFactory(FastDFSTemplateFactory fastDFSTemplateFactory) {
        pool = new GenericObjectPool<>(new ConnectionFactory(fastDFSTemplateFactory),new GenericObjectPoolConfig());
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