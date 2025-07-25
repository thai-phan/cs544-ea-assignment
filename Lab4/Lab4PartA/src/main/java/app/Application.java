package app;

import domain.a.Department;
import domain.a.Employee;
import domain.b.Book;
import domain.b.Publisher;
import domain.c.Flight;
import domain.c.Passenger;
import domain.d.School;
import domain.d.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class Application implements CommandLineRunner {

  @Autowired
  DepartmentDAO DepartmentDAO;

  @Autowired
  PublisherDAO publisherDAO;

  @Autowired
  BookDAO bookDAO;

  @Autowired
  FlightDAO flightDAO;

  @Autowired
  PassengerDAO passengerDAO;

  @Autowired
  StudentDAO studentDAO;

  @Autowired
  SchoolDAO schoolDAO;

  @PersistenceContext
  EntityManager entityManager;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    testA();
    System.out.println("--------------------------------------------------");
    testB();
    System.out.println("--------------------------------------------------");
    testC();
    System.out.println("--------------------------------------------------");
    testD();
  }

  public void testA() {
    Employee emp1 = new Employee("Emp 1", "Algorithm Professor");
    Employee emp2 = new Employee("Emp 2", "Security Professor");
    Employee emp3 = new Employee("Emp 3", "Cloud Professor");

    Department department = new Department("Department 1");

    department.addEmployee(emp1);
    department.addEmployee(emp2);
    department.addEmployee(emp3);

    DepartmentDAO.save(department);

    Department dept = DepartmentDAO.findById(1);
    System.out.println(dept);
  }

  public void testB() {
    Publisher publisher = new Publisher("New york Time");
    publisherDAO.save(publisher);

    Book book1 = new Book("ABCD2", "Algorithm", "Algorithm Description");
    book1.setPublisher(publisher);
    Book book2 = new Book("ABCD3", "Security", "Security Description");
    Publisher publisher2 = new Publisher("LA Book");
    book2.setPublisher(publisher2);
    publisherDAO.save(publisher2);

    bookDAO.save(book1);
    bookDAO.save(book2);
//    bookDAO.save(book3);

    Book book = bookDAO.findByTitle("ABCD2");
    System.out.println(book);
  }

  public void testC() {
    Passenger passenger = new Passenger("Alice");

    Flight flight1 = new Flight("Boston", "New York", LocalDate.now());
    Flight flight2 = new Flight("New York", "London", LocalDate.of(2025, 5, 20));

    passenger.addFlight(flight1);
    passenger.addFlight(flight2);

    passengerDAO.save(passenger);
  }

  public void testD() {
    School school = new School("Harvard");

    Student s1 = new Student(101L, "Alice", "Smith");
    Student s2 = new Student(102L, "Bob", "Brown");

    school.addStudent(s1);
    school.addStudent(s2);

    schoolDAO.save(school);
  }
}
