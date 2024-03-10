package dev.patika.vetapp.service;

import dev.patika.vetapp.base.BaseService;
import dev.patika.vetapp.dto.DoctorRequest;
import dev.patika.vetapp.dto.DoctorResponse;
import dev.patika.vetapp.entity.Doctor;
import dev.patika.vetapp.mapper.DoctorMapper;
import dev.patika.vetapp.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService implements BaseService<Doctor, DoctorRequest, DoctorResponse> {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public DoctorResponse save(DoctorRequest request) {
        return doctorMapper.asResponse(
                doctorRepository.save(doctorMapper.asEntity(request))
        );

    }

    @Override
    public DoctorResponse findById(Long id) {
        return doctorMapper.asResponse(findByIdEntity(id));
    }


    @Override
    public DoctorResponse update(Long id, DoctorRequest request) {
        Doctor doctorFromDb = findByIdEntity(id);
        doctorMapper.update(doctorFromDb, request);
        return doctorMapper.asResponse(doctorRepository.save(doctorFromDb));
    }


    @Override
    public void deleteById(Long id) {
        Doctor doctor = findByIdEntity(id);
        doctorRepository.delete(doctor);
    }


    @Override
    public Doctor findByIdEntity(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor is not found"));
    }

    @Override
    public List<DoctorResponse> findAll() {
        return doctorMapper.asResponseList(doctorRepository.findAll());
    }
}
