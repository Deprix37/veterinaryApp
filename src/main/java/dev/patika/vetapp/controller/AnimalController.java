package dev.patika.vetapp.controller;

import dev.patika.vetapp.dto.AnimalRequest;
import dev.patika.vetapp.dto.AnimalResponse;
import dev.patika.vetapp.service.AnimalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/animal")
public class AnimalController {          // ANİMAL İŞ SÜREÇLERİNİ YÜRÜTTÜĞÜM SINIF

    private final AnimalService animalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AnimalResponse> save(@RequestBody @Valid AnimalRequest request) {
        return new ResponseEntity<>(animalService.save(request), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalResponse findById(@PathVariable(name = "id") Long id) {
        return animalService.findById(id);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalResponse update(@PathVariable(name = "id") Long id, @RequestBody AnimalRequest request) {
        return animalService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        animalService.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalResponse> findAll() {
        return animalService.findAll();
    }

    @GetMapping("/find-all-by-customer-id/{customerId}")  //animalları customer id ye göre filtrele
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalResponse> findAllByCustomerId(@PathVariable("customerId") Long customerId) {
        return animalService.findAnimalsByCustomer(customerId);
    }

    @GetMapping("/find-by-name")   //name' e göre filtreleme
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalResponse> findByName(@RequestParam String name, @RequestParam String breed) {
        return animalService.findByName(name);
    }


}
