package dev.patika.vetapp.controller;

import dev.patika.vetapp.dto.AppointmentRequest;
import dev.patika.vetapp.dto.AppointmentResponse;
import dev.patika.vetapp.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentResponse save(@RequestBody @Valid AppointmentRequest request) {
        return appointmentService.save(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentResponse findById(@PathVariable(name = "id") Long id) {
        return appointmentService.findById(id);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentResponse update(@PathVariable(name = "id") Long id, @RequestBody AppointmentRequest request) {
        return appointmentService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        appointmentService.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AppointmentResponse> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/find-by-date-between-and-animal-id")
    public List<AppointmentResponse> filterAppointments(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam Long animalId) {
        List<AppointmentResponse> filteredAppointments = appointmentService.findByDateRangeAndAnimal(startDate, endDate, animalId);
        return filteredAppointments;
    }

    @GetMapping("/find-by-date-between-and-doctor-id")
    public List<AppointmentResponse> filterAppointmentsdoctor(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam Long doctorId) {
        List<AppointmentResponse> filteredAppointmentsdoctor = appointmentService.findByAppointmentDateBetweenAndDoctor(startDate, endDate, doctorId);
        return filteredAppointmentsdoctor;
    }

}
