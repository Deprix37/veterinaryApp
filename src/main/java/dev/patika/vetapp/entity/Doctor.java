package dev.patika.vetapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.patika.vetapp.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "doctors")
public class Doctor extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Email
    @Column(name = "mail", nullable = false)
    private String mail;
    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;
    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Appointment> appointments;


    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<AvailableDate> availableDates;
}
