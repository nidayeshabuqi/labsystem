package com.qfedu.labsystem.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UploadService {
    public void upload(MultipartFile file) throws IOException;
}
