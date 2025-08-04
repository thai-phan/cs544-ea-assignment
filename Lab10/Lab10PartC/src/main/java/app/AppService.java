package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Component;

@Component
public class AppService {
  @Autowired
  private AppProperties appProperties;

  public void print() {
    System.out.println("Application Name = " + appProperties.getName());
    System.out.println("Application Version = " + appProperties.getVersion());
    System.out.println("Server URL = " + appProperties.getServer().getUrl());
    System.out.println("Server Name = " + appProperties.getServer().getName());
    System.out.println("User First Name = " + appProperties.getUser().getFirstname());
    System.out.println("User Last Name = " + appProperties.getUser().getLastname());
    System.out.println("User Username = " + appProperties.getUser().getUsername());
    System.out.println("User Password = " + appProperties.getUser().getPassword());
    System.out.println("Countries = " + String.join(", ", appProperties.getCountries()));
  }
}