package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

  List<Student> findByDepartmentName(String departmentName);

  @Query("SELECT s FROM Student s JOIN s.department d WHERE d.name = ?1")
  List<Student> queryFindByDepartment(String departmentName);

  List<Student> findByGradesCourseName(String name);

  @Query("SELECT s FROM Student s JOIN s.grades g WHERE g.course.name = ?1")
  List<Student> queryFindByGradesCourseName(String courseName);
}