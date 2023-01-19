package com.qzk.minio.controller;

import com.qzk.minio.conf.MinioProperties;
import com.qzk.minio.util.MinioUtil;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Description 测试
 * @Date 2023-01-19-10-56
 * @Author qianzhikang
 */
@RestController
public class MinioController {
    @Resource
    private MinioProperties minioProperties;

    @SneakyThrows
    @PostMapping(value = "/upload")
    public String upload(@RequestParam(name = "file") MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        MinioUtil.createBucket(minioProperties.getBucket());
        MinioUtil.uploadFile(minioProperties.getBucket(), multipartFile, fileName);
        return MinioUtil.getPreSignedObjectUrl(minioProperties.getBucket(), fileName);
    }
}
