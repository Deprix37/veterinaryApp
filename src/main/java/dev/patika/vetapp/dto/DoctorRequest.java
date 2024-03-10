package dev.patika.vetapp.dto;

public record DoctorRequest(String name,
                            String phone,
                            String mail,
                            String address,
                            String city) {

}
