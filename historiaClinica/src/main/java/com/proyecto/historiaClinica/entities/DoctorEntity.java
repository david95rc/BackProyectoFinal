package com.proyecto.historiaClinica.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor")
public class DoctorEntity implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;

        private String apellido;

        private String email;

        private String password;

        private String telefono;

        private String direccion;

        private String especialidad;

        @OneToMany(mappedBy = "doctor")
        private List<DiagnosticoEntity> diagnosticoEntities;

        @OneToMany(mappedBy = "doctor")
        private List<DatosExploracionEntity> datosExploracionEntities;

        @OneToMany(mappedBy = "doctor")
        private List<TratamientoEntity> tratamientoEntities;



    }

