package com.qfedu.labsystem.service.impl;

import com.qfedu.labsystem.service.UploadService;
import com.qfedu.labsystem.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class UploadSerciceImpl implements UploadService {

    @Autowired
    private AliOssUtil aliOssUtil;
    @Override
    public void upload(MultipartFile file) throws IOException {
        //原始文件名
        String originalFilename = file.getOriginalFilename();
        //截取原始文件名的后缀   dfdfdf.png
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        //构造新文件名称
        String objectName = UUID.randomUUID().toString() + extension;

        //文件的请求路径
        String filePath = aliOssUtil.upload(file.getBytes(), objectName);


        log.info(filePath);
    }
}
