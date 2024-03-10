package dev.patika.vetapp.dto;

import dev.patika.vetapp.entity.Animal;

import java.time.LocalDate;

public record VaccineRequest(
        String name,
        String code,
        LocalDate protectionStartDate,
        LocalDate protectionFinishDate,
        Animal animal) {

}
