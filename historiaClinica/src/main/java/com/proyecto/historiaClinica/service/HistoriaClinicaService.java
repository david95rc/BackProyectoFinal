package com.proyecto.historiaClinica.service;

import com.proyecto.historiaClinica.dto.HistoriaClinicaDTO;

import java.util.List;

public interface HistoriaClinicaService {
    HistoriaClinicaDTO guardarHistoriaClinica(HistoriaClinicaDTO historiaClinicaDTO);

    boolean actualizarHistoriaClinica(HistoriaClinicaDTO historiaClinicaDTO);

    boolean borrarHistoriaClinica(Long id);

    List<HistoriaClinicaDTO> obtenerDatosHistoriaClinica();

    HistoriaClinicaDTO obtenerHistoriaClinicaPorId(Long id);
}
