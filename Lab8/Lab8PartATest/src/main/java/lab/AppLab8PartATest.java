package lab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;


@SpringBootApplication
public class AppLab8PartATest implements CommandLineRunner {


  public static void main(String[] args) {
    SpringApplication.run(AppLab8PartATest.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    RestClient restClient = RestClient.builder()
        .baseUrl("http://localhost:8080")
        .build();

    BookDTO bookDTO = restClient.get()
          .uri("/api/books/111-3-16-2222-0")
        .retrieve()
        .body(BookDTO.class);
    System.out.println(bookDTO);

    BookDTO newBook = new BookDTO("111-3-16-2227-0", "Spring Boot in Action", "Craig Walls", 29.99);
    bookDTO = restClient
        .post()
        .uri("/api/books")
        .contentType(MediaType.APPLICATION_JSON)
        .body(newBook)
        .retrieve()
        .body(BookDTO.class);
    System.out.println(bookDTO);

//// add John
//    Contact johnResponse = restClient.post()
//        .uri("/contacts")
//        .contentType(MediaType.APPLICATION_JSON)
//        .body(new Contact("John", "Doe", "jdoe@acme.com", "6739127563"))
//        .retrieve()
//        .body(Contact.class);
  }
}


