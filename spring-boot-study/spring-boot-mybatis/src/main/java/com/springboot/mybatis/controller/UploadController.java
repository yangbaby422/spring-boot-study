package com.springboot.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 上传文件控制器
 * 直接上传到服务器
 * @author yangbaby
 * 2019.3.25
 */
@RestController
public class UploadController {

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file")MultipartFile sourceFile){
        String returnFileName = "";
        //选择了文件，开始进行上传操作
        try {
            //构建上传目标路径,找到了项目得target得class目录
            File destFile = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!destFile.exists()){
                destFile = new File("");
            }
            //输出目标文件得绝对路径
            System.out.println("file path:"+destFile.getAbsolutePath());
            //拼接static目录

            File uploadFolder = new File(destFile.getAbsolutePath(),"upload/");
            //若目标文件夹不存在，则创建一个
            if (!uploadFolder.exists()) {
                uploadFolder.mkdirs();
             }
            System.out.println("upload url: "+uploadFolder.getAbsolutePath());
            //根据srcFile的大小，准备一个字节数组
            byte[] bytes = sourceFile.getBytes();
            //拼接上传路径
            Path path = Paths.get(uploadFolder.getAbsolutePath() + "/" + sourceFile.getOriginalFilename());

            //最重要的一步，将源文件写入目标地址
            Files.write(path , bytes);
            //将文件上传成功的信息写入message
            returnFileName = "http://localhost:8080/upload/" + sourceFile.getOriginalFilename();
        }catch (IOException e){
            e.printStackTrace();
        }
        return returnFileName;
    }

}