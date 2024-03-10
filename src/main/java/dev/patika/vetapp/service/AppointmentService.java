package dev.patika.vetapp.service;

import dev.patika.vetapp.base.BaseService;
import dev.patika.vetapp.dto.AppointmentRequest;
import dev.patika.vetapp.dto.AppointmentResponse;
import dev.patika.vetapp.entity.Appointment;
import dev.patika.vetapp.entity.AvailableDate;
import dev.patika.vetapp.mapper.AppointmentMapper;
import dev.patika.vetapp.repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentService implements BaseService<Appointment, AppointmentRequest, AppointmentResponse> {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final AvailableDateService availableDateService;

    @Override
    public AppointmentResponse save(AppointmentRequest request) {
        if (request.appointmentDate().getMinute() != 0) {
            throw new RuntimeException("Sadece saat başı randevu alabilirsiniz.");
        }
        Optional<Appointment> appointmentExist = appointmentRepository.findByAppointmentDateAndAnimalIdAndDoctorId(request.appointmentDate(), request.animal().getId(), request.doctor().getId());
        if (appointmentExist.isPresent()) {
            throw new RuntimeException("Bu Randevu Sistemde Kayıtlı");
        }
        Optional<Appointment> appointmentExists = appointmentRepository.findByDoctorIdAndAppointmentDate(request.doctor().getId(), request.appointmentDate());
        if (appointmentExists.isPresent()) {
            throw new RuntimeException("Doktorun Bu Randevu Saati Dolu");
        }
        Optional<AvailableDate> availableDateExist = availableDateService.findByAvailableDateAndDoctorId(request.appointmentDate().toLocalDate(), request.doctor().getId());
        if (availableDateExist.isEmpty()) {
            throw new RuntimeException("Doktor Bu Gün Çalışmıyor");
        }

        return appointmentMapper.asResponse(
                appointmentRepository.save(appointmentMapper.asEntity(request))
        );

    }

    @Override
    public AppointmentResponse findById(Long id) {
        return appointmentMapper.asResponse(findByIdEntity(id));
    }

    @Override
    public AppointmentResponse update(Long id, AppointmentRequest request) {
        Appointment appointmentFromDb = findByIdEntity(id);
        appointmentMapper.update(appointmentFromDb, request);
        return appointmentMapper.asResponse(appointmentRepository.save(appointmentFromDb));
    }

    @Override
    public void deleteById(Long id) {
        Appointment appointment = findByIdEntity(id);
        appointmentRepository.delete(appointment);
    }


    @Override
    public Appointment findByIdEntity(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Appointment is not found"));
    }

    @Override
    public List<AppointmentResponse> findAll() {
        return appointmentMapper.asResponseList(appointmentRepository.findAll());
    }
    
}

