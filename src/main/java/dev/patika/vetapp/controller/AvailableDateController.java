package dev.patika.vetapp.controller;

import dev.patika.vetapp.dto.AvailableDateRequest;
import dev.patika.vetapp.dto.AvailableDateResponse;
import dev.patika.vetapp.service.AvailableDateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/availableDate")
public class AvailableDateController {
    private final AvailableDateService availableDateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AvailableDateResponse save(@RequestBody @Valid AvailableDateRequest request) {
        return availableDateService.save(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)

    public AvailableDateResponse findById(@PathVariable(name = "id") Long id) {
        return availableDateService.findById(id);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)

    public AvailableDateResponse update(@PathVariable(name = "id") Long id, @RequestBody AvailableDateRequest request) {
        return availableDateService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        availableDateService.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AvailableDateResponse> findAll() {
        return availableDateService.findAll();
    }
}
