package dev.patika.vetapp.mapper;

import dev.patika.vetapp.dto.AppointmentRequest;
import dev.patika.vetapp.dto.AppointmentResponse;
import dev.patika.vetapp.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AppointmentMapper {
    Appointment asEntity(AppointmentRequest request);

    AppointmentResponse asResponse(Appointment appointment);

    void update(@MappingTarget Appointment appointment, AppointmentRequest request);

    List<AppointmentResponse> asResponseList(List<Appointment> appointmentList);
}
