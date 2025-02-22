package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.FileStorageService;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.errors.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * 通用接口
 */
@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonController {

    @Autowired
    private FileStorageService fileStorageService;

    /**
     * 文件上传
     * @return String为文件保存路径
     */
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file){
        log.info("文件上传：{}", file);
        try {
            String originalFilename = file.getOriginalFilename();
            // 获取原始后缀
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            // UUID名称
            String objectName = UUID.randomUUID().toString() + extension;

            String filePath = fileStorageService.uploadImgFile("", objectName, file.getInputStream());
            return Result.success(filePath);
        } catch (Exception e) {
            log.error("文件上传失败：{}", e.getMessage());
        }
        return null;
    }
}
