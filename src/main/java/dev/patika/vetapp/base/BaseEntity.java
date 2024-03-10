package dev.patika.vetapp.base;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity extends Auditable {  //Her entityde kullandığım değişkenler için sınıf
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
