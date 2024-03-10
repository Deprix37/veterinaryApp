package dev.patika.vetapp.dto;

import dev.patika.vetapp.entity.Doctor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AvailableDateResponse(
        Long id,
        LocalDate availableDate,
        Doctor doctor,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

}
