package dev.patika.vetapp.dto;

import dev.patika.vetapp.entity.Animal;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record VaccineResponse(
        Long id,
        String name,

        String code,

        LocalDate protectionStartDate,
        LocalDate protectionFinishDate,
        Animal animal,
        LocalDateTime createdAt,
        LocalDateTime createdBy) {
}
