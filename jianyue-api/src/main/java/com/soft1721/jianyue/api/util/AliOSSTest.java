package com.soft1721.jianyue.api.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;

import java.io.File;
import java.net.URL;
import java.util.Date;

/**
 * Created by 洋酱 on 2019/4/3.
 */
public class AliOSSTest {
    public static void main(String[] args) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高
        String accessKeyId = "LTAI96IYDvHen6ol";
        String accessKeySecret = "3uYdPyM4ZL6VpYyqhdqBCtrtiEU7dF";
        String bucketName = "niit-soft1721-cy";
        String filedir = "avatar/";
        String fileKey = "hello.jpg";
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件
        PutObjectResult putResult = ossClient.putObject(bucketName, filedir + fileKey, new File("D:\\pic.jpg"));
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, filedir + fileKey, expiration);
        System.out.println(url);
        ossClient.shutdown();
    }
}