package dev.patika.vetapp.entity;

import dev.patika.vetapp.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "available_dates")
public class AvailableDate extends BaseEntity {
    @Column(name = "available_date", nullable = false)
    private LocalDate availableDate;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
}
