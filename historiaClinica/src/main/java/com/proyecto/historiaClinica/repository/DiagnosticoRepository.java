package com.proyecto.historiaClinica.repository;

import com.proyecto.historiaClinica.entities.DiagnosticoEntity;
import com.proyecto.historiaClinica.entities.TratamientoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiagnosticoRepository extends CrudRepository<DiagnosticoEntity, Long> {
    List<DiagnosticoEntity> findByHistoriaClinica_Id(Long id);
    boolean existsByHistoriaClinica_Id(Long id);
}
