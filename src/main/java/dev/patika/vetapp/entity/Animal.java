package dev.patika.vetapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.patika.vetapp.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "animals")
public class Animal extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "species", nullable = false)
    private String species;
    @Column(name = "breed", nullable = false)
    private String breed;
    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "color", nullable = false)
    private String color;
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "animal", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointments;
}
