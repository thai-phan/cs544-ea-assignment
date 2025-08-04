package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class AppLab10PartC implements CommandLineRunner {
  @Autowired
  AppService appService;

  public static void main(String[] args) {
    SpringApplication.run(AppLab10PartC.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    appService.print();
  }
}


