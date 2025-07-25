package repositories;

import domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentDAO extends JpaRepository<Appointment, Double> {
}
