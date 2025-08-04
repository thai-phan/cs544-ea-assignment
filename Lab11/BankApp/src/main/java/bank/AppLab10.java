package bank;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class AppLab10 implements CommandLineRunner {
  Logger logger = org.slf4j.LoggerFactory.getLogger(AppLab10.class);

  public static void main(String[] args) {
    SpringApplication.run(AppLab10.class, args);
  }

  public void run(String... args) throws Exception {
    System.out.println("Bank Receiver is running and waiting for messages");
    logger.trace("A TRACE Message");
    logger.debug("A DEBUG Message");
    logger.info("An INFO Message");
    logger.warn("A WARN Message");
    logger.error("An ERROR Message");
  }
}


