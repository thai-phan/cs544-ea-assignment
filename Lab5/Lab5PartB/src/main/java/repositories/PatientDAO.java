package repositories;

import domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDAO extends JpaRepository<Patient, Double> {
}
