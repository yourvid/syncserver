package com.cmf.utils;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FastDFSClient {
    private static TrackerClient trackerClient = null;
    private static TrackerServer trackerServer = null;
    private static StorageServer storageServer = null;
    private static StorageClient storageClient = null;
    private static StorageClient1 storageClient1 = null;

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
            ClientGlobal.initByProperties("properties/fastdfs-client.properties");
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

    public ResponseEntity<byte[]> download(String fileId, String specFileName) throws IOException, MyException {
        byte[] content = null;
        HttpHeaders headers = new HttpHeaders();
        content = storageClient1.download_file1(fileId);
        headers.setContentDispositionFormData("attachment",  new String(specFileName.getBytes("UTF-8"),"iso-8859-1"));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(content, headers, HttpStatus.CREATED);
    }

    public int download1(String fileId, String specFileName) throws IOException, MyException {
        return storageClient1.download_file1(fileId, specFileName);
    }

    public String[] uploadFile(MultipartFile multipartFile) throws Exception {
        byte[] bytes = multipartFile.getBytes();
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".")+1);
        return storageClient1.upload_file(bytes,ext,null);
    }

    public String[] uploadFile(MultipartFile multipartFile, NameValuePair[] nameValuePair) throws Exception {
        byte[] bytes = multipartFile.getBytes();
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".")+1);
        return storageClient1.upload_file(bytes,ext, nameValuePair);
    }

    public String[] uploadFile(File file) throws Exception {
        byte[] bytes = FileUtils.File2byte(file);
        String fileName = file.getName();
        String ext = fileName.substring(fileName.lastIndexOf(".")+1);
        return storageClient1.upload_file(bytes,ext,null);
    }

    public String[] uploadFile(File file,NameValuePair[] nameValuePair) throws Exception {
        byte[] bytes = FileUtils.File2byte(file);
        String fileName = file.getName();
        String ext = fileName.substring(fileName.lastIndexOf(".")+1);
        return storageClient1.upload_file(bytes,ext,null);
    }
    
    public int deleteFile(String fileId) throws IOException, MyException {
        return storageClient1.delete_file1(fileId);
    }
    
    public FileInfo getFileInfo(String fileId) throws IOException, MyException {
        return storageClient1.get_file_info1(fileId);
    }

    public FileInfo queryFileInfo(String fileId) throws IOException, MyException {
        return storageClient1.query_file_info1(fileId);
    }

    public NameValuePair[] getMetadata(String fileId) throws IOException, MyException {
       return storageClient1.get_metadata1(fileId);
    }

    public int setMetadata(String fileId, NameValuePair[] metaList, byte opFlag) throws IOException, MyException {
        return storageClient1.set_metadata1(fileId, metaList, opFlag);
    }
    
    
}
