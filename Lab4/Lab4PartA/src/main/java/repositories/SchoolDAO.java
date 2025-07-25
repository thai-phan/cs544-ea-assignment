package repositories;

import domain.d.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDAO extends JpaRepository<School, Long> {


}
