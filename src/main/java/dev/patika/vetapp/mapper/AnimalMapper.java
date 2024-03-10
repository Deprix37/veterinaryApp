package dev.patika.vetapp.mapper;

import dev.patika.vetapp.dto.AnimalRequest;
import dev.patika.vetapp.dto.AnimalResponse;
import dev.patika.vetapp.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AnimalMapper {
    //mapleme işlemleri mapstruct ile

    Animal asEntity(AnimalRequest request);

    AnimalResponse asResponse(Animal animal);

    void update(@MappingTarget Animal animal, AnimalRequest request);

    List<AnimalResponse> asResponseList(List<Animal> animalList);
}
