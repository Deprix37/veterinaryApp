package dev.patika.vetapp.repository;

import dev.patika.vetapp.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // Database ile iletişime geçtiğim katman
    List<Animal> findAllByCustomerId(Long customerId);

    List<Animal> findAllByName(String name);
}
