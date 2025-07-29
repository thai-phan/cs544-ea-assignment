package lab;

import java.util.Collection;

import lab.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AppLab8PartA implements CommandLineRunner {

  @Autowired
  IBookService bookService;

  public static void main(String[] args) {
    SpringApplication.run(AppLab8PartA.class, args);
  }

  @Override
  public void run(String... args) {




  }
}


