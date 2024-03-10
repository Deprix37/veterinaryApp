package dev.patika.vetapp.base;

import java.util.List;

public interface BaseService<ENTITY extends BaseEntity, REQ, RES> { //her servicede kullanılan metotlar için sınıf

    RES save(REQ request);

    RES findById(Long id);

    RES update(Long id, REQ request);

    void deleteById(Long id);

    ENTITY findByIdEntity(Long id);

    List<RES> findAll();

}