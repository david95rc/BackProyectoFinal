package com.proyecto.historiaClinica.dto;

import com.proyecto.historiaClinica.entities.DiagnosticoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HistoriaClinicaDTO implements Serializable {

    private Long id;
    private String fecha;
    private String observaciones;
    private PacienteDTO paciente;




}
