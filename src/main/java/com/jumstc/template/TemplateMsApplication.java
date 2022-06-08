package com.jumstc.template;

import com.jumstc.platform.common.annotation.EnableGlobalException;
import com.jumstc.platform.common.util.JsonUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * 模版启动类
 * 
 * @author 张云和
 * @date 2020/5/18 1:41 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableGlobalException
@MapperScan({"com.jumstc.template.domain.mapper"})
public class TemplateMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateMsApplication.class, args);
    }

    /**
     * 更改json序列化为jackson 和JsonUtils使用统一的objectMapper，支持LocalDateTime转换等
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setObjectMapper(JsonUtil.OBJECT_MAPPER);
        return jsonConverter;
    }
}
