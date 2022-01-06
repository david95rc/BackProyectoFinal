package com.proyecto.historiaClinica.repository;

import com.proyecto.historiaClinica.entities.TratamientoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TratamientoRepository extends CrudRepository<TratamientoEntity, Long> {
    List<TratamientoEntity> findByHistoriaClinica_Id(Long id);
    boolean existsByHistoriaClinica_Id(Long id);
}
