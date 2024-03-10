package dev.patika.vetapp.dto;

import java.time.LocalDateTime;

public record DoctorResponse(
        Long id,
        String name,
        String phone,
        String mail,
        String address,
        String city,
        LocalDateTime createdA,
        LocalDateTime updatedAt) {

}
