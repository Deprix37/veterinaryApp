package dev.patika.vetapp.dto;

import dev.patika.vetapp.entity.Customer;
import dev.patika.vetapp.entity.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AnimalResponse(
        Long id,
        String name,
        String species,
        String breed,
        String color,
        Gender gender,
        LocalDate dateOfBirth,
        Customer customer,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

}
