package com.proyecto.historiaClinica.service;

import com.proyecto.historiaClinica.dto.DatosSubjetivosDTO;

import java.util.List;

public interface DatosSubjetivosService {
    DatosSubjetivosDTO guardarDatosSubjetivos(DatosSubjetivosDTO datosSubjetivosDTO);

    boolean actualizarDatosSubjetivos(DatosSubjetivosDTO datosSubjetivosDTO);

    boolean borrarDatosSubjetivos(Long id);

    List<DatosSubjetivosDTO> obtenerDatosSubjetivos();

    DatosSubjetivosDTO obtenerDatosSubjetivosPorId(Long id);

    List<DatosSubjetivosDTO> buscarPorIdHistoria(Long id);
}
