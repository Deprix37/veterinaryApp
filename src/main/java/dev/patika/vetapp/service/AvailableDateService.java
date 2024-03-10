package dev.patika.vetapp.service;

import dev.patika.vetapp.base.BaseService;
import dev.patika.vetapp.dto.AvailableDateRequest;
import dev.patika.vetapp.dto.AvailableDateResponse;
import dev.patika.vetapp.entity.AvailableDate;
import dev.patika.vetapp.mapper.AvailableDateMapper;
import dev.patika.vetapp.repository.AvailableDateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AvailableDateService implements BaseService<AvailableDate, AvailableDateRequest, AvailableDateResponse> {
    private final AvailableDateRepository availableDateRepository;
    private final AvailableDateMapper availableDateMapper;

    @Override
    public AvailableDateResponse save(AvailableDateRequest request) {
        return availableDateMapper.asResponse(
                availableDateRepository.save(availableDateMapper.asEntity(request))
        );

    }

    @Override
    public AvailableDateResponse findById(Long id) {
        return availableDateMapper.asResponse(findByIdEntity(id));
    }

    @Override
    public AvailableDateResponse update(Long id, AvailableDateRequest request) {
        AvailableDate availableDateFromDb = findByIdEntity(id);
        availableDateMapper.update(availableDateFromDb, request);
        return availableDateMapper.asResponse(availableDateRepository.save(availableDateFromDb));
    }

    @Override
    public void deleteById(Long id) {
        AvailableDate availableDate = findByIdEntity(id);
        availableDateRepository.delete(availableDate);
    }

    @Override
    public AvailableDate findByIdEntity(Long id) {
        return availableDateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Available Date is not found"));
    }

    @Override
    public List<AvailableDateResponse> findAll() {
        return availableDateMapper.asResponseList(availableDateRepository.findAll());
    }

    public Optional<AvailableDate> findByAvailableDateAndDoctorId(LocalDate availableDate, Long id) {
        return this.availableDateRepository.findByAvailableDateAndDoctorId(availableDate, id);
    }

}
