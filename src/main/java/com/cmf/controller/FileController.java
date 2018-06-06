package com.cmf.controller;

import com.cmf.utils.FastDFSClient;
import org.csource.common.MyException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/file")
public class FileController {
    FastDFSClient fastDFSClient = FastDFSClient.getInstance();

    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(@Param("filePath") String filePath, @Param("specFilaName") String specFilaName) throws IOException, MyException {
        String substr = filePath.substring(filePath.indexOf("group"));
        String group = substr.split("/")[0];
        String remoteFileName = substr.substring(substr.indexOf("/")+1);
        return fastDFSClient.download(group, remoteFileName,specFilaName);
    }

    @RequestMapping(value = "/download1")
    public int download1(@Param("filePath") String filePath, @Param("specFilaName") String specFilaName) throws IOException, MyException {
        String substr = filePath.substring(filePath.indexOf("group"));
        String group = substr.split("/")[0];
        String remoteFileName = substr.substring(substr.indexOf("/")+1);
        return fastDFSClient.download1(group, remoteFileName,specFilaName);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile attach) throws Exception {
        if (!attach.isEmpty()) {
            byte[] bytes = attach.getBytes();
            String fileName = attach.getOriginalFilename();
            String ext = attach.getOriginalFilename().substring(fileName.lastIndexOf(".")+1);
            String res[] = fastDFSClient.uploadFile(bytes,ext);
            return new ResponseEntity<String>(res[0]+"/"+res[1],HttpStatus.OK);
        }else{
            throw new Exception("请上传文件！");
        }
    }
}
