package repositories;

import domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorDAO extends JpaRepository<Doctor, Double> {
}
