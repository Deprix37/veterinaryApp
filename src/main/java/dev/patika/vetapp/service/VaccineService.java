package dev.patika.vetapp.service;

import dev.patika.vetapp.base.BaseService;
import dev.patika.vetapp.dto.VaccineRequest;
import dev.patika.vetapp.dto.VaccineResponse;
import dev.patika.vetapp.entity.Vaccine;
import dev.patika.vetapp.mapper.VaccineMapper;
import dev.patika.vetapp.repository.VaccineRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VaccineService implements BaseService<Vaccine, VaccineRequest, VaccineResponse> {
    private final VaccineRepository vaccineRepository;
    private final VaccineMapper vaccineMapper;

    @Override
    public VaccineResponse save(VaccineRequest request) {
        return vaccineMapper.asResponse(
                vaccineRepository.save(vaccineMapper.asEntity(request))
        );

    }

    @Override
    public VaccineResponse findById(Long id) {
        return vaccineMapper.asResponse(findByIdEntity(id));
    }

    @Override
    public VaccineResponse update(Long id, VaccineRequest request) {
        Vaccine vaccineFromDb = findByIdEntity(id);
        vaccineMapper.update(vaccineFromDb, request);
        return vaccineMapper.asResponse(vaccineRepository.save(vaccineFromDb));
    }

    @Override
    public void deleteById(Long id) {
        Vaccine vaccine = findByIdEntity(id);
        vaccineRepository.delete(vaccine);
    }

    @Override
    public Vaccine findByIdEntity(Long id) {
        return vaccineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vaccine is not found"));
    }

    @Override
    public List<VaccineResponse> findAll() {
        return vaccineMapper.asResponseList(vaccineRepository.findAll());
    }

    public List<VaccineResponse> findVaccineByAnimalId(Long animalId) {
        return vaccineMapper.asResponseList(vaccineRepository.findAllByAnimalId(animalId));
    }
}
