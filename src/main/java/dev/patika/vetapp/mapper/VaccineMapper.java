package dev.patika.vetapp.mapper;

import dev.patika.vetapp.dto.VaccineRequest;
import dev.patika.vetapp.dto.VaccineResponse;
import dev.patika.vetapp.entity.Vaccine;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface VaccineMapper {
    Vaccine asEntity(VaccineRequest request);

    VaccineResponse asResponse(Vaccine vaccine);

    void update(@MappingTarget Vaccine vaccine, VaccineRequest request);

    List<VaccineResponse> asResponseList(List<Vaccine> vaccineList);
}
