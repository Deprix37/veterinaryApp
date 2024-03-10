package dev.patika.vetapp.mapper;

import dev.patika.vetapp.dto.DoctorRequest;
import dev.patika.vetapp.dto.DoctorResponse;
import dev.patika.vetapp.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface DoctorMapper {
    Doctor asEntity(DoctorRequest request);

    DoctorResponse asResponse(Doctor doctor);

    void update(@MappingTarget Doctor doctor, DoctorRequest request);

    List<DoctorResponse> asResponseList(List<Doctor> doctorList);
}
