package com.qfedu.labsystem.controller;

import com.qfedu.labsystem.service.UploadService;
import com.qfedu.labsystem.utils.ResultOBJ;
import com.qfedu.labsystem.utils.SYSConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

@RequestMapping("/adminapi/upload")
@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;


    @PostMapping
    public ResultOBJ upload(@RequestParam("file") MultipartFile file){
        try {
            System.out.println(file);
            uploadService.upload(file);
            return new ResultOBJ(SYSConstant.CODE_SUCCESS,"上传成功");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
