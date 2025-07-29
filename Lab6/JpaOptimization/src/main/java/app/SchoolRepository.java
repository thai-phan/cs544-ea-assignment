package app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {

  @Query("SELECT s FROM School s join fetch s.students")
  List<School> findAllSchools();

}
