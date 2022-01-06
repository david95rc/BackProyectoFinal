package com.proyecto.historiaClinica.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DatosExploracionDTO implements Serializable {

    private long id;
    private String descripcion;
    private DoctorDTO doctor;
    private HistoriaClinicaDTO historiaClinica;
}
