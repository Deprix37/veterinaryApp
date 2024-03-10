package dev.patika.vetapp.dto;

import dev.patika.vetapp.entity.Animal;
import dev.patika.vetapp.entity.Doctor;

import java.time.LocalDateTime;

public record AppointmentRequest(LocalDateTime appointmentDate,
                                 Animal animal,
                                 Doctor doctor) {

}

