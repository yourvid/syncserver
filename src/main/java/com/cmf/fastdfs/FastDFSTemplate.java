package com.cmf.fastdfs;


import com.cmf.fastdfs.exception.FastDFSException;
import com.cmf.fastdfs.pool.ConnectionPoolFactory;
import com.cmf.utils.FileUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.StorageClient1;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * FastDFS 模板类
 */
@Component
public class FastDFSTemplate {

    @Resource
    private ConnectionPoolFactory connPoolFactory;
    @Resource
    private FastDFSTemplateFactory factory;

    public FastDfsInfo uploadFile(MultipartFile multipartFile) throws Exception {
        StorageClient1 client = getClient();
        try {
            byte[] bytes = multipartFile.getBytes();
            String fileName = multipartFile.getOriginalFilename();
            String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
            String[] uploadResults = client.upload_file(bytes, ext , null);
            String groupName = uploadResults[0];
            String remoteFileName = uploadResults[1];
            FastDfsInfo fastDfsInfo = new FastDfsInfo(groupName, remoteFileName);
            if (factory != null) {
                this.setFileAbsolutePath(fastDfsInfo);
            }
            return fastDfsInfo;
        } catch (Exception e) {
            throw new FastDFSException(e.getMessage(), e, 0);
        } finally {
            releaseClient(client);
        }
    }

    public FastDfsInfo uploadFile(File file) throws Exception {
        StorageClient1 client = getClient();
        try {
            byte[] bytes = FileUtils.File2byte(file);
            String fileName = file.getName();
            String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
            String[] uploadResults = client.upload_file(bytes, ext , null);
            String groupName = uploadResults[0];
            String remoteFileName = uploadResults[1];
            FastDfsInfo fastDfsInfo = new FastDfsInfo(groupName, remoteFileName);
            if (factory != null) {
                this.setFileAbsolutePath(fastDfsInfo);
            }
            return fastDfsInfo;
        } catch (Exception e) {
            throw new FastDFSException(e.getMessage(), e, 0);
        } finally {
            releaseClient(client);
        }
    }


    /**
     * 上传文件
     *
     * @param data
     * @param ext 后缀，如：jpg、bmp（注意不带.）
     *
     * @return
     *
     * @throws FastDFSException
     */
    public FastDfsInfo upload(byte[] data, String ext) throws FastDFSException {
        return this.upload(data, ext, null);
    }

    /**
     * 上传文件
     *
     * @param data
     * @param ext 后缀，如：jpg、bmp（注意不带.）
     * @param values
     *
     * @return
     *
     * @throws FastDFSException
     */
    public FastDfsInfo upload(byte[] data, String ext, Map<String, String> values) throws FastDFSException {
        NameValuePair[] valuePairs = null;
        if (values != null && !values.isEmpty()) {
            valuePairs = new NameValuePair[values.size()];
            int index = 0;
            for (Map.Entry<String, String> entry : values.entrySet()) {
                valuePairs[index] = new NameValuePair(entry.getKey(), entry.getValue());
                index++;
            }
        }
        StorageClient1 client = getClient();

        try {
            String[] uploadResults = client.upload_file(data, ext, valuePairs);
            String groupName = uploadResults[0];
            String remoteFileName = uploadResults[1];
            FastDfsInfo fastDfsInfo = new FastDfsInfo(groupName, remoteFileName);
            if (factory != null) {
                this.setFileAbsolutePath(fastDfsInfo);
            }
            return fastDfsInfo;
        } catch (Exception e) {
            throw new FastDFSException(e.getMessage(), e, 0);
        } finally {
            releaseClient(client);
        }
    }

    /**
     * 下载文件
     *
     * @param dfs
     *
     * @return
     *
     * @throws FastDFSException
     */
    public byte[] loadFile(FastDfsInfo dfs) throws FastDFSException {
        return this.loadFile(dfs.getGroup(), dfs.getPath());
    }

    /**
     * 下载文件
     *
     * @param groupName
     * @param remoteFileName
     *
     * @return
     *
     * @throws FastDFSException
     */
    public byte[] loadFile(String groupName, String remoteFileName) throws FastDFSException {
        StorageClient1 client = getClient();
        try {
            return client.download_file(groupName, remoteFileName);
        } catch (Exception e) {
            throw new FastDFSException(e.getMessage(), e, 0);
        } finally {
            releaseClient(client);
        }
    }

    public byte[] loadFile(String fileId) throws FastDFSException {
        StorageClient1 client = getClient();
        try {
            return client.download_file1(fileId);
        } catch (Exception e) {
            throw new FastDFSException(e.getMessage(), e, 0);
        } finally {
            releaseClient(client);
        }
    }

    public ResponseEntity<byte[]> download(String fileId, String specFileName) throws Exception {
        StorageClient1 client = getClient();
        try {
            HttpHeaders headers = new HttpHeaders();
            byte[] content = client.download_file1(fileId);
            headers.setContentDispositionFormData("attachment", new String(specFileName.getBytes("UTF-8"), "iso-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(content, headers, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e) {
            throw new FastDFSException(e.getMessage(), e, 0);
        } finally {
            releaseClient(client);
        }

    }

    /**
     * 删除文件
     *
     * @param dfs
     *
     * @throws FastDFSException
     */
    public void deleteFile(FastDfsInfo dfs) throws FastDFSException {
        this.deleteFile(dfs.getGroup(), dfs.getPath());
    }

    /**
     * 删除文件
     *
     * @param groupName
     * @param remoteFileName
     *
     * @throws FastDFSException
     */
    public void deleteFile(String groupName, String remoteFileName) throws FastDFSException {
        int code;
        StorageClient1 client = getClient();
        try {
            code = client.delete_file(groupName, remoteFileName);
        } catch (Exception e) {
            throw new FastDFSException(e.getMessage(), e, 0);
        } finally {
            releaseClient(client);
        }
        if (code != 0) {
            throw new FastDFSException(code);
        }
    }

    public void deleteFile(String fileId) throws FastDFSException {
        int code;
        StorageClient1 client = getClient();
        try {
            code = client.delete_file1(fileId);
        } catch (Exception e) {
            throw new FastDFSException(e.getMessage(), e, 0);
        } finally {
            releaseClient(client);
        }
        if (code != 0) {
            throw new FastDFSException(code);
        }
    }

    /**
     * 设置远程可访问路径
     *
     * @param path
     * @param group
     *
     * @return
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws MyException
     */
    private String setFileAbsolutePath(String group, String path)
            throws IOException, NoSuchAlgorithmException, MyException {
        int ts = (int) (System.currentTimeMillis() / 1000);
        String token = "";
        if (factory.isG_anti_steal_token()) {
            token = ProtoCommon.getToken(path, ts, factory.getG_secret_key());
            token = "?token=" + token + "&ts=" + ts;
        }
        List<String> addressList = factory.getNginx_address();
        Random random = new Random();
        int i = random.nextInt(addressList.size());
        String address = addressList.get(i);
        return address +
               factory.getSepapator() +
               group +
               factory.getSepapator() +
               path + token;
    }

    private void setFileAbsolutePath(FastDfsInfo fastDfsInfo) throws IOException, NoSuchAlgorithmException, MyException {
        fastDfsInfo.setFileAbsolutePath(this.setFileAbsolutePath(fastDfsInfo.getGroup(), fastDfsInfo.getPath()));
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
