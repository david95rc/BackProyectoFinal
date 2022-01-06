package com.proyecto.historiaClinica.repository;


import com.proyecto.historiaClinica.entities.PacienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<PacienteEntity, Long> {
}
