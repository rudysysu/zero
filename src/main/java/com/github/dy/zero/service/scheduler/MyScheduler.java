package com.github.dy.zero.service.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;

@Service
public class MyScheduler {
    private static final Logger LOG = LoggerFactory.getLogger(MyScheduler.class);

    private static volatile boolean jvmStopping = false;

    public MyScheduler() {
        LOG.info("MyScheduler");
    }

    @PreDestroy
    public void shutdown() {
        LOG.info("shutdown...");
        jvmStopping = true;
    }

    @Scheduled(cron = "0/3 * * * * *")
    public void myTask() throws InterruptedException {
        try {
            for (int i = 0; i < 10; i++) {
                if (jvmStopping == true) {
                    break;
                }
                LOG.info("myTask start...");
                TimeUnit.SECONDS.sleep(2);
                LOG.info("myTask end.");
            }
        } catch (InterruptedException e) {
            LOG.warn(e.toString());
        }
    }
}
