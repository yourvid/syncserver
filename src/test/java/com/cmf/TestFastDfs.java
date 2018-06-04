package com.cmf;

import com.cmf.utils.FastDFSClient;
import org.csource.common.MyException;
import org.csource.fastdfs.FileInfo;
import org.junit.Test;

import java.io.IOException;

public class TestFastDfs {
    FastDFSClient client = FastDFSClient.getInstance();
//    @Test
    public void upload(){
        try {
            String res[] = client.uploadFile("D://fastdfs.txt","txt",null);
            for(String s : res){
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//    @Test
    public void getFileInfo(){
        try {
            FileInfo info = client.getFileInfo("group1","M00/00/00/Ch4AUVsUpyqACUKmAAAD1UKQIHo417.txt");
            System.out.println(info.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteFile(){
        try {
            int info = client.deleteFile("group1","M00/00/00/Ch4AUVsUpyqACUKmAAAD1UKQIHo417.txt");
            System.out.println(info);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

    }
}
