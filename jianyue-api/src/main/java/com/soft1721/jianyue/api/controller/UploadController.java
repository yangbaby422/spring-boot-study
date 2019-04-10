package com.soft1721.jianyue.api.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.soft1721.jianyue.api.util.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api")
public class UploadController {
    @PostMapping("/avatar/upload")
    public String ossUpload(@RequestParam("file") MultipartFile sourceFile) {
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId = "LTAI96IYDvHen6ol";
        String accessKeySecret = "3uYdPyM4ZL6VpYyqhdqBCtrtiEU7dF";
        String bucketName = "niit-soft1721-cy";
        String filedir = "avatar/";
        // 获取源文件名
        String fileName = sourceFile.getOriginalFilename();
        // 获取源文件名后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //uuid生成主文件名
        String prefix = UUID.randomUUID().toString();
        //新文件名
        String newFileName = prefix + suffix;
        //File类型的临时文件
        File tempFile = null;
        try {
            //创建临时文件，用uuid主文件名+原后缀名
            tempFile = File.createTempFile(prefix, prefix);
            // MultipartFile转成File
            sourceFile.transferTo(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, filedir + newFileName, tempFile);
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, filedir + newFileName, expiration);
        ossClient.shutdown();
        //URL返回给客户端
        return url.toString();
    }
}
