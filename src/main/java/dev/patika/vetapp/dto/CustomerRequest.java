package dev.patika.vetapp.dto;

public record CustomerRequest(String name,
                              String phone,
                              String address,
                              String mail,
                              String city) {
}
