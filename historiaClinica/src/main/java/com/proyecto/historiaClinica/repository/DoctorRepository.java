package com.proyecto.historiaClinica.repository;
import com.proyecto.historiaClinica.entities.DoctorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<DoctorEntity, Long> {
    List<DoctorEntity> findByNombre(String nombre);
}
