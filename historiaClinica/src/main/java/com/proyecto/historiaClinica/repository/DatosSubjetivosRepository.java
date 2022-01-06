package com.proyecto.historiaClinica.repository;


import com.proyecto.historiaClinica.entities.DatosSubjetivosEntity;
import com.proyecto.historiaClinica.entities.TratamientoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DatosSubjetivosRepository extends CrudRepository<DatosSubjetivosEntity, Long> {
    List<DatosSubjetivosEntity> findByHistoriaClinica_Id(Long id);
    boolean existsByHistoriaClinica_Id(Long id);
}
