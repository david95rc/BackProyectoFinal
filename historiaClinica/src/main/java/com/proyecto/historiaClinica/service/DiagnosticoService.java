package com.proyecto.historiaClinica.service;

import com.proyecto.historiaClinica.dto.DiagnosticoDTO;

import java.util.List;

public interface DiagnosticoService {
    DiagnosticoDTO guardarDiagnostico(DiagnosticoDTO diagnosticoDTO);

    boolean actualizarDiagnostico(DiagnosticoDTO diagnosticoDTO);

    boolean borrarDiagnostico(Long id);

    List<DiagnosticoDTO> obtenerDatosDiagnostico();

    DiagnosticoDTO obtenerDiagnosticoPorId(Long id);

    List<DiagnosticoDTO> buscarPorIdHistoria(Long id);
}
