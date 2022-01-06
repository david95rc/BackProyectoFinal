package com.proyecto.historiaClinica.service;

import com.proyecto.historiaClinica.dto.DatosExploracionDTO;

import java.util.List;

public interface DatosExploracionService {
    DatosExploracionDTO guardarDatosExploracion(DatosExploracionDTO datosExploracionDTO);

    boolean actualizarDatosExploracion(DatosExploracionDTO datosExploracionDTO);

    boolean borrarDatosExploracion(Long id);

    List<DatosExploracionDTO> obtenerDatosExploracion();

    DatosExploracionDTO obtenerDatosExploracionPorId(Long id);

    List<DatosExploracionDTO> buscarPorIdHistoria(Long id);
}
