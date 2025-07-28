package app;

import domain.Course;
import domain.Department;
import domain.Grade;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CourseRepository;
import repositories.DepartmentRepository;
import repositories.GradeRepository;
import repositories.StudentRepository;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class Application implements CommandLineRunner {
  @Autowired
  DepartmentRepository departmentRepository;
  @Autowired
  CourseRepository courseRepository;
  @Autowired
  StudentRepository studentRepository;
  @Autowired
  GradeRepository gradeRepository;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    createSampleData();

    List<Student> students1 = studentRepository.findByDepartmentName("Computer Science");
    System.out.println("Students in Computer Science Department:");
    System.out.println(students1);

    List<Student> students2 = studentRepository.findByGradesCourseName("Algorithms");
    System.out.println("Students enrolled in Algorithms course:");
    System.out.println(students2);

    List<Student> students3 = studentRepository.queryFindByDepartment("Computer Science");
    System.out.println("Students in Computer Science Department using query:");
    System.out.println(students3);

    List<Student> students4 = studentRepository.queryFindByGradesCourseName("Algorithms");
    System.out.println("Students enrolled in Algorithms course using query:");
    System.out.println(students4);
  }


  public void createSampleData() {
    Department csDept = new Department("Computer Science");
    Department mathDept = new Department("Mathematics");
    departmentRepository.save(csDept);
    departmentRepository.save(mathDept);

    Course course1 = new Course("Algorithms");
    Course course2 = new Course("Data Structures");
    Course course3 = new Course("Calculus");
    Course course4 = new Course("Linear Algebra");
    Course course5 = new Course("Discrete Mathematics");

    courseRepository.save(course1);
    courseRepository.save(course2);
    courseRepository.save(course3);
    courseRepository.save(course4);
    courseRepository.save(course5);

    Grade grade1 = new Grade("A", course1);
    Grade grade2 = new Grade("B+", course2);
    Grade grade3 = new Grade("A-", course3);
    Grade grade4 = new Grade("B", course4);
    Grade grade5 = new Grade("C", course5);
    Grade grade6 = new Grade("B-", course1);

    gradeRepository.save(grade1);
    gradeRepository.save(grade2);
    gradeRepository.save(grade3);
    gradeRepository.save(grade4);
    gradeRepository.save(grade5);
    gradeRepository.save(grade6);


    Student student1 = new Student("John Doe", "S1001", csDept);
    Student student2 = new Student("Jane Smith", "S1002", mathDept);
    Student student3 = new Student("Alice Johnson", "S1003", csDept);
    Student student4 = new Student("Bob Brown", "S1004", mathDept);
    Student student5 = new Student("Charlie White", "S1005", csDept);

    student1.addGrade(grade1);
    student1.addGrade(grade2);
    student2.addGrade(grade3);
    student3.addGrade(grade4);
    student4.addGrade(grade5);
    student5.addGrade(grade6);

    studentRepository.save(student1);
    studentRepository.save(student2);
    studentRepository.save(student3);
    studentRepository.save(student4);
    studentRepository.save(student5);
  }
}
