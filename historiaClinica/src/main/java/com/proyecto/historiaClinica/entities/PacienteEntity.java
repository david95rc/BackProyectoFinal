package com.proyecto.historiaClinica.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "paciente")
public class PacienteEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String email;
    private String telefono_Contacto;
    private String genero;
    private String ocupacion;




    @OneToMany(mappedBy = "paciente")
    private List<DatosSubjetivosEntity> datosSubjetivosEntities;



}
