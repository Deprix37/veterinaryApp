package dev.patika.vetapp.repository;

import dev.patika.vetapp.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByAppointmentDateAndAnimalIdAndDoctorId(LocalDateTime dateTime, Long id, Long doctorId);

    Optional<Appointment> findByDoctorIdAndAppointmentDate(Long id, LocalDateTime dateTime);

    List<Appointment> findByAppointmentDateBetweenAndAnimalId(LocalDateTime startDateTime, LocalDateTime finishDateTime, Long animalId);

    List<Appointment> findByAppointmentDateBetweenAndDoctorId(LocalDateTime startDateTime, LocalDateTime finishDateTime, Long doctorId);
}
