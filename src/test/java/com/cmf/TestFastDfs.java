package com.cmf;


import com.cmf.fastdfs.FastDFSTemplate;
import com.cmf.fastdfs.FastDfsInfo;
import com.cmf.fastdfs.exception.FastDFSException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SyncserverApplication.class)// 指定spring-boot的启动类
public class TestFastDfs {

    @Resource
    private FastDFSTemplate dfsTemplate;

//            @Test
    public void testUploadAndDel() throws FastDFSException {
        FastDfsInfo rv = dfsTemplate.upload("".getBytes(), "txt");
        System.out.println(rv);
        dfsTemplate.deleteFile(rv);
        System.out.println("删除成功！");
    }

        @Test
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
//    public void activeTest() throws IOException {
//        Socket socket = new Socket("10.30.0.81", 22122);
//        Boolean re = ProtoCommon.activeTest(socket);
//        System.out.println(re);
//    }




}
