package com.proyecto.historiaClinica.service;

import com.proyecto.historiaClinica.dto.TratamientoDTO;

import java.util.List;

public interface TratamientoService {
    TratamientoDTO guardarTratamiento(TratamientoDTO tratamientoDTO);

    boolean actualizarTratamiento(TratamientoDTO tratamientoDTO);

    boolean borrarTratamiento(Long id);

    List<TratamientoDTO> obtenerDatosTratamiento();

    TratamientoDTO obtenerTratamientoPorId(Long id);

    List<TratamientoDTO> buscarPorIdHistoria(Long id);
}
