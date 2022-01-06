package com.proyecto.historiaClinica.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Console;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "historiaclinica")
public class HistoriaClinicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private String observaciones;




    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PacienteEntity paciente;

    @OneToMany(mappedBy = "historiaClinica", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DiagnosticoEntity> diagnosticoEntities;

    @OneToMany(mappedBy = "historiaClinica", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DatosExploracionEntity> datosExploracionEntities;

    @OneToMany(mappedBy = "historiaClinica", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DatosSubjetivosEntity> datosSubjetivosEntities;

    @OneToMany(mappedBy = "historiaClinica", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TratamientoEntity> tratamientoEntities;


}
