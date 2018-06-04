package com.cmf.utils;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class FastDFSClient {
    private static TrackerClient trackerClient = null;
    private static TrackerServer trackerServer = null;
    private static StorageServer storageServer = null;
    private static StorageClient storageClient = null;

    private FastDFSClient() {
    }

    private static class LazyHolder {
        private static final FastDFSClient INSTANCE = new FastDFSClient();
    }

    public static final FastDFSClient getInstance() {
        return LazyHolder.INSTANCE;
    }

    static  {
        try {
            ClientGlobal.initByProperties("fastdfs-client.properties");
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageServer = null;
            storageClient = new StorageClient(trackerServer,   storageServer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传文件方法
     * <p>Title: uploadFile</p>
     * <p>Description: </p>
     * @param fileName 文件全路径
     * @param extName 文件扩展名，不包含（.）
     * @param metas 文件扩展信息
     * @return
     * @throws Exception
     */
    public String[] uploadFile(String fileName, String extName, NameValuePair[] metas) throws Exception {
        String result[] = storageClient.upload_file(fileName, extName, metas);
        return result;
    }


    public String[] uploadFile(String fileName) throws Exception {
        return uploadFile(fileName, null, null);
    }

    public String[] uploadFile(String fileName, String extName) throws Exception {
        return uploadFile(fileName, extName, null);
    }

    /**
     * 上传文件方法
     * <p>Title: uploadFile</p>
     * <p>Description: </p>
     * @param fileContent 文件的内容，字节数组
     * @param extName 文件扩展名
     * @param metas 文件扩展信息
     * @return
     * @throws Exception
     */
    public String[] uploadFile(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception {
        String result[] = storageClient.upload_file(fileContent, extName, metas);
        return result;
    }

    public String[] uploadFile(byte[] fileContent) throws Exception {
        return uploadFile(fileContent, null, null);
    }

    public String[] uploadFile(byte[] fileContent, String extName) throws Exception {
        return uploadFile(fileContent, extName, null);
    }

    public byte[] downloadFile(String group_name, String remote_filename) throws IOException, MyException{
        return storageClient.download_file(group_name, remote_filename);
    }

    public int downloadFile(String group_name, String remote_filename, String local_filename) throws IOException, MyException {
        return storageClient.download_file(group_name, remote_filename, local_filename);
    }


    public FileInfo getFileInfo(String group_name, String remote_filename) throws IOException, MyException {
        return storageClient.get_file_info(group_name,remote_filename);
    }

    public int deleteFile(String group_name, String remote_filename) throws IOException, MyException {
        return storageClient.delete_file(group_name,remote_filename);
    }



    /**
     * <strong>方法概要： 文件下载</strong> <br>
     * <strong>创建时间： 2016-9-26 上午10:28:21</strong> <br>
     *
     * @param groupName
     * @param remoteFileName
     * @return returned value comment here
     * @author Wang Liang
     */
    public ResponseEntity<byte[]> download(String groupName,
                                                  String remoteFileName, String specFileName) throws IOException, MyException {
        byte[] content = null;
        HttpHeaders headers = new HttpHeaders();
        content = downloadFile(groupName, remoteFileName);
        headers.setContentDispositionFormData("attachment",  new String(specFileName.getBytes("UTF-8"),"iso-8859-1"));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(content, headers, HttpStatus.CREATED);
    }
}
