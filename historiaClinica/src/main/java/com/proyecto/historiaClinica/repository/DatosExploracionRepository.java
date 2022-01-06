package com.proyecto.historiaClinica.repository;

import com.proyecto.historiaClinica.entities.DatosExploracionEntity;
import com.proyecto.historiaClinica.entities.TratamientoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DatosExploracionRepository extends CrudRepository<DatosExploracionEntity, Long> {
    List<DatosExploracionEntity> findByHistoriaClinica_Id(Long id);
    boolean existsByHistoriaClinica_Id(Long id);
}
