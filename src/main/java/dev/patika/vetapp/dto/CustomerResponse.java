package dev.patika.vetapp.dto;

import java.time.LocalDateTime;

public record CustomerResponse(
        Long id,
        String name,

        String phone,
        String mail,
        String address,
        String city,
        LocalDateTime createdAt,
        LocalDateTime createdBy) {

}
