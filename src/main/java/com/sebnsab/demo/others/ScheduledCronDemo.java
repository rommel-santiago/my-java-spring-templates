package com.sebnsab.demo.others;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduledCronDemo {

    //@Scheduled(fixedRate = 5000)
    @Scheduled(cron ="0 0 21 * * MON-FRI", zone = "Europe/London")
    public void scheduledDemo() throws InterruptedException{
        log.info("Triggering Job ");

    }
}
