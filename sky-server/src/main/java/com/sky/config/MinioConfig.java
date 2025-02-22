package com.sky.config;

import com.sky.properties.MinioConfigProperties;
import com.sky.service.FileStorageService;
import io.minio.MinioClient;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//当引入FileStorageService接口时
@Slf4j
public class MinioConfig {

    @Autowired
    private MinioConfigProperties minIOConfigProperties;

    @Bean
    @ConditionalOnMissingBean
    public MinioClient buildMinioClient() {
        log.info("开始创建MinIO云文件上传工具类对象：{}", minIOConfigProperties);
        return MinioClient
                .builder()
                .credentials(minIOConfigProperties.getAccessKey(), minIOConfigProperties.getSecretKey())
                .endpoint(minIOConfigProperties.getEndpoint())
                .build();
    }
}
