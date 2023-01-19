package com.qzk.minio.conf;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Description Minio配置
 * @Date 2023-01-19-10-37
 * @Author qianzhikang
 */
@Configuration
public class MinioConfiguration {

    @Resource
    private MinioProperties minioProperties;

    /**
     * 初始化客户端
     *
     * @return 客户端
     */
    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(minioProperties.getEndpoint())
                .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
                .build();
    }
}
