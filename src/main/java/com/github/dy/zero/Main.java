package com.github.dy.zero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.TimeUnit;

@EnableScheduling
@SpringBootApplication
public class Main implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        while (true) {
            int timeout = (int) (Math.random() * 5);
            if (timeout == 0) {
                timeout = 1;
            }
            // LOG.warn("timeout: {}", timeout);
            try {
                TimeUnit.SECONDS.sleep(timeout);
            } catch (InterruptedException e) {
                LOG.error(e.toString(), e);
            }
        }
    }
}
