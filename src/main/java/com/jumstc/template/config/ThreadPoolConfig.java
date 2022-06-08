package com.jumstc.template.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池初始化
 *
 * @Author chenhui
 * @Date 2020/6/23 14:02
 */
@Slf4j
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    /**
     * 线程池名称
     */
    public static final String EXECUTOR = "baseExecutor";

    /**
     * 核心线程池数量
     */
    @Value("${thread-pool.core-pool-size:10}")
    private int corePoolSize;

    /**
     * 线程池最大线程数量
     */
    @Value("${thread-pool.max-pool-size:15}")
    private int maxPoolSize;

    /**
     * 缓存队列
     */
    @Value("${thread-pool.queue-capacity:3000}")
    private int queueCapacity;

    /**
     * 允许的空闲时间
     */
    @Value("${thread-pool.keep-alive:60}")
    private int keepAlive;

    @Bean(name = EXECUTOR)
    public ThreadPoolTaskExecutor baseExecutor() {
        log.info("初始化线程池baseExecutor, corePoolSize: {}, maxPoolSize: {}, queueCapacity: {}, keepAlive: {}",
            corePoolSize, maxPoolSize, queueCapacity, keepAlive);
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("baseExecutor-");

        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.setKeepAliveSeconds(keepAlive);
        executor.initialize();
        return executor;
    }
}