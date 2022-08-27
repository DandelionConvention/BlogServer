package com.fbw.controller;

import com.fbw.domain.ReturnData;
import com.fbw.domain.User;
import com.fbw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


@RequestMapping("/upload")
@RestController
public class FileController {

    @Autowired
    IUserService iUserService;

    @Value("${images.filePath}")
    private String imagsPath;
//    图片上传

    @PostMapping("/img")
    public ReturnData uploadByOne(@RequestParam("file") MultipartFile file,@RequestParam("fileId") String fileId){
        if(file.isEmpty()){
            return new ReturnData(null,"你骗我，传空文件",250);
        }

        try{
            String fileName = file.getOriginalFilename().split("\\.")[1];
            //获取存储路径 System.getProperty("user.dir")是获取当前项目的地址
            String filePath = imagsPath;
            File dest = new File(filePath+System.currentTimeMillis()+"."+fileName);
            System.out.println(dest.toPath());
            byte[] bytes = file.getBytes();

            String msg = iUserService.imgUpload(dest,bytes,Integer.decode(fileId));

            if (msg == ""){
                return new ReturnData(msg,"错误",250);
            }

            return new ReturnData(msg,"成功",200);
        } catch (Exception e){
            System.out.println("file error");
            System.out.println(e.getMessage());
            return new ReturnData(null,"失败",500);
        }

    }

}
