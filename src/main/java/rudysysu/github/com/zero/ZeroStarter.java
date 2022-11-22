package rudysysu.github.com.zero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ZeroStarter implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(ZeroStarter.class);

    public static void main(String[] args) {
        SpringApplication.run(ZeroStarter.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        while (true) {
            LOG.warn("sendMsg: {}", Math.random() * 100);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                LOG.error(e.toString(), e);
            }
        }
    }
}
