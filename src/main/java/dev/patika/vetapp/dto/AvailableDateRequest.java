package dev.patika.vetapp.dto;

import dev.patika.vetapp.entity.Doctor;

import java.time.LocalDate;

public record AvailableDateRequest(
        LocalDate availableDate,
        Doctor doctor) {

}

