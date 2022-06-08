package com.jumstc.template.job;

import com.jumstc.template.service.GenerateIndexService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author EDZ
 */
@Component
public class TaskConsumer implements ApplicationRunner {

    @Resource(name = "baseExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Resource
    private GenerateIndexService generateIndexService;

    @Override
    public void run(ApplicationArguments args) {
        threadPoolTaskExecutor.execute(()->{
            try {
                generateIndexService.syncLucene();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
