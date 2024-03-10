package dev.patika.vetapp.controller;


import dev.patika.vetapp.dto.VaccineRequest;
import dev.patika.vetapp.dto.VaccineResponse;
import dev.patika.vetapp.service.VaccineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/vaccine")
public class VaccineController {
    private final VaccineService vaccineService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VaccineResponse save(@RequestBody @Valid VaccineRequest request) {
        return vaccineService.save(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VaccineResponse findById(@PathVariable(name = "id") Long id) {
        return vaccineService.findById(id);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VaccineResponse update(@PathVariable(name = "id") Long id, @RequestBody VaccineRequest request) {
        return vaccineService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        vaccineService.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineResponse> findAll() {
        return vaccineService.findAll();
    }

    @GetMapping("/find-all-by-animal-id/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineResponse> findAllByAnimalId(@PathVariable("animalId") Long animalId) {
        return vaccineService.findVaccineByAnimalId(animalId);
    }

    @GetMapping("/find-all-vaccines-by-date-range")
    public List<VaccineResponse> getVaccinesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        List<VaccineResponse> vaccineList = vaccineService.findVaccinesByDateRange(startDate, endDate);
        return vaccineList;
    }

   /* @GetMapping("/find-all-vaccines-by-date-range")
    public List<VaccineResponse> filterVaccinesByDateRange(
            @RequestParam Long animalId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<VaccineResponse> filteredVaccines = vaccineService.findVaccinesByDateRange(animalId, startDate, endDate);
        return filteredVaccines;
    }*/
}
