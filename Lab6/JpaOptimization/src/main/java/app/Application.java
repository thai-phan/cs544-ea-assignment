package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  SchoolRepository schoolRepository;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
//    insertCustomers();
//    retrieveCustomers();
//    updateCustomers();
//    insertSchools();
//    retrieveSchools();
    retrieveSchoolsWithStudents();
  }

  private void insertSchools() {
    for (int x = 0; x < 50000; x++) {
      School school = new School("School " + x);
      Student student = new Student("Student " + x, "", "student" + x + "@school.com");
      Student student2 = new Student("Student2 "+ x, "", "student2" + x + "@school.com");

      school.addStudent(student);
      school.addStudent(student2);

      schoolRepository.save(school);
      System.out.println("Inserting school  " + x);

    }
  }

  private void retrieveSchools() {
    System.out.println("Retrieving all schools ...");
    long start = System.currentTimeMillis();

    List<School> schools = schoolRepository.findAll();
    long finish = System.currentTimeMillis();
    long timeElapsed = finish - start;
    System.out.println(schools);
    System.out.println("To retrieve all Schools took " + timeElapsed + " ms");
  }

  private void retrieveSchoolsWithStudents() {
    System.out.println("Retrieving all schools with students ...");
    long start = System.currentTimeMillis();

    List<School> schools = schoolRepository.findAllSchools();
    long finish = System.currentTimeMillis();
    long timeElapsed = finish - start;
    System.out.println(schools);
    System.out.println("To retrieve all Schools with Students took " + timeElapsed + " ms");
  }

  private void insertCustomers() {
    for (int x = 0; x < 50000; x++) {
      Customer customer = new Customer("John Doe " + x);
      Account account = new Account("123" + x);
      customer.setAccount(account);
      customerRepository.save(customer);
      System.out.println("Inserting customer  " + x);
    }
  }

  private void retrieveCustomers() {
    System.out.println("Retrieving all customers ...");
    long start = System.currentTimeMillis();

    List<Customer> customers = customerRepository.findAll();
    long finish = System.currentTimeMillis();
    long timeElapsed = finish - start;
    System.out.println("To retrieve all Customers took " + timeElapsed + " ms");
  }

  private void updateCustomers() {
    System.out.println("Change the name of all customers ...");
    long start = System.currentTimeMillis();

//    List<Customer> customers = customerRepository.findAll();
    customerRepository.updateAllCustomers("James Ahiii");
//    for (Customer c : customers) {
//      c.setName("James Bond");
//      customerRepository.save(c);
//    }
    long finish = System.currentTimeMillis();
    long timeElapsed = finish - start;
    System.out.println("To change the name of all customers took " + timeElapsed + " ms");
  }
}
