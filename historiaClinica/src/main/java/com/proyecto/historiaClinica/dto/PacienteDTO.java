package com.proyecto.historiaClinica.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PacienteDTO implements Serializable {

    private long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String email;
    private String telefono_Contacto;
    private String genero;
    private String ocupacion;

}
