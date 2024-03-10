package dev.patika.vetapp.mapper;

import dev.patika.vetapp.dto.AvailableDateRequest;
import dev.patika.vetapp.dto.AvailableDateResponse;
import dev.patika.vetapp.entity.AvailableDate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AvailableDateMapper {
    AvailableDate asEntity(AvailableDateRequest request);

    AvailableDateResponse asResponse(AvailableDate availableDate);

    void update(@MappingTarget AvailableDate availableDate, AvailableDateRequest request);

    List<AvailableDateResponse> asResponseList(List<AvailableDate> availableDateList);
}
