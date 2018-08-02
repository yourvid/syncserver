package com.cmf;


import com.cmf.fastdfs.FastDFSTemplate;
import com.cmf.fastdfs.FastDfsInfo;
import com.cmf.fastdfs.exception.FastDFSException;
import com.cmf.fastdfs.pool.ConnectionPoolFactory;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.StorageClient1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SyncserverApplication.class)// 指定spring-boot的启动类
public class TestFastDfs {

    @Resource
    private FastDFSTemplate dfsTemplate;

    @Resource
    private ConnectionPoolFactory connPoolFactory;
//            @Test
    public void testUploadAndDel() {
                StorageClient1 client = getClient();
                try {
//                    FastDfsInfo rv = dfsTemplate.upload("123".getBytes(), "txt");
//                    System.out.println(rv);
//                    dfsTemplate.deleteFile(rv);
//                    System.out.println("删除成功！");

                    File file = new File("D:\\fastdfs.txt");
                    FileInputStream fis = new FileInputStream(file);
                    byte[] b = new byte[fis.available()];
                    fis.read(b);
                    NameValuePair n1 = new NameValuePair("name1","value1");
                    NameValuePair n2 = new NameValuePair("name2","value2");
                    NameValuePair[] meta_list = {n1,n2};
                    String re1 = client.upload_appender_file1(b,"txt", meta_list);
                    System.out.println(re1);

                    NameValuePair[] re2 = client.get_metadata1(re1);
                    Arrays.asList(re2).stream().forEach(x -> System.out.println(x.getName()+":"+x.getValue()));

                    int i = client.modify_file1(re1,file.length(),"D:\\bds.txt");
                    System.out.println("修改结果："+i);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    releaseClient(client);
                }
            }

//        @Test
    public void testPool() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                File file = new File("D:\\fastdfs.txt");
                FileInputStream fis = new FileInputStream(file);
                byte[] b = new byte[fis.available()];
                fis.read(b);
                Map<String, String> map = new HashMap<>();
                FastDfsInfo rv = dfsTemplate.upload(b, "txt", map);
                System.out.println(rv.getFileAbsolutePath());
                dfsTemplate.deleteFile(rv);
                System.out.println(rv.getFileAbsolutePath() + "--删除成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        Thread.currentThread().join();
    }


//    @Test
    public void activeTest() throws IOException {
        Socket socket = new Socket("10.30.0.81", 22122);
        Boolean re = ProtoCommon.activeTest(socket);
        System.out.println(re);
    }


    protected StorageClient1 getClient() {
        StorageClient1 client = null;
        while (client == null) {
            try {
                client = connPoolFactory.getClient();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return client;
    }

    protected void releaseClient(StorageClient1 client) {
        connPoolFactory.releaseConnection(client);
    }




}
