package dev.patika.vetapp.service;

import dev.patika.vetapp.base.BaseService;
import dev.patika.vetapp.dto.AnimalRequest;
import dev.patika.vetapp.dto.AnimalResponse;
import dev.patika.vetapp.entity.Animal;
import dev.patika.vetapp.mapper.AnimalMapper;
import dev.patika.vetapp.repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor  // iş süreçlerini yürüttüğüm katman
public class AnimalService implements BaseService<Animal, AnimalRequest, AnimalResponse> {


    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    @Override
    public AnimalResponse save(AnimalRequest request) {
        return animalMapper.asResponse(
                animalRepository.save(animalMapper.asEntity(request))
        );

    }

    @Override
    public AnimalResponse findById(Long id) {
        return animalMapper.asResponse(findByIdEntity(id));
    }

    @Override
    public AnimalResponse update(Long id, AnimalRequest request) {
        Animal animalFromDb = findByIdEntity(id);
        animalMapper.update(animalFromDb, request);
        return animalMapper.asResponse(animalRepository.save(animalFromDb));
    }

    @Override
    public void deleteById(Long id) {
        Animal animal = findByIdEntity(id);
        animalRepository.delete(animal);
    }

    @Override
    public Animal findByIdEntity(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal is not found"));
    }

    @Override
    public List<AnimalResponse> findAll() {
        return animalMapper.asResponseList(animalRepository.findAll());
    }

    public List<AnimalResponse> findAnimalsByCustomer(Long customerId) {
        return animalMapper.asResponseList(animalRepository.findAllByCustomerId(customerId));
    }

    public List<AnimalResponse> findByName(String name) {
        return animalMapper.asResponseList(animalRepository.findAllByName(name));
    }
}
