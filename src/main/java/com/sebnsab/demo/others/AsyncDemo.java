package com.sebnsab.demo.others;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AsyncDemo {


    @Async("threadPoolTaskExecutor")  // threadPoolTaskExecutor is a Bean defined in ConfigDemo
    //For Async to work you have to have @EnableAsync on  Config Bean
    public void asyncCallDemo() {

        try {
            log.info("Sleeping..");
            Thread.sleep(5000);
            log.info("awake..");
        } catch(InterruptedException e) {
            log.error("Someone woke me up..");
        }


    }
}
