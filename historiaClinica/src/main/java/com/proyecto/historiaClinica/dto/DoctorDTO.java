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

public class DoctorDTO implements Serializable {

private long id;
private String nombre;
private String apellido;
private String email;
private String password;
private String telefono;
private String direccion;
private String especialidad;

}
