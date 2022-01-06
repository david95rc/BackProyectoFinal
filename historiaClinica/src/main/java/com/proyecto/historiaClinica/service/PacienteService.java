package com.proyecto.historiaClinica.service;

import com.proyecto.historiaClinica.dto.DoctorDTO;
import com.proyecto.historiaClinica.dto.PacienteDTO;

import java.util.List;

public interface PacienteService {

    PacienteDTO guardarPaciente(PacienteDTO pacienteDTO);

    boolean actualizarPaciente(PacienteDTO pacienteDTO);

    boolean borrarPaciente(Long id);

    List<PacienteDTO> obtenerDatosPaciente();

    PacienteDTO obtenerPacientePorId(Long id);
}
