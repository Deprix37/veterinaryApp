package dev.patika.vetapp.dto;

import dev.patika.vetapp.entity.Animal;
import dev.patika.vetapp.entity.Doctor;

import java.time.LocalDateTime;

public record AppointmentResponse(
        Long id,
        LocalDateTime appointmentDate,
        Animal animal,
        Doctor doctor,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
