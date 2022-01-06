package com.proyecto.historiaClinica.service;

import com.proyecto.historiaClinica.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {

    DoctorDTO guardarDoctor(DoctorDTO doctorDTO);

    boolean actualizarDoctor(DoctorDTO doctorDTO);


    boolean borrarDoctor(Long id);

    List<DoctorDTO> obtenerDatosDoctor();

    DoctorDTO obtenerDoctorPorId(Long id);

    List<DoctorDTO> obtenerDoctorPorNombre(String nombre);
}
