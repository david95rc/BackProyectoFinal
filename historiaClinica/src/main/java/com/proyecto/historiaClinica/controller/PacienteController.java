package com.proyecto.historiaClinica.controller;


import com.proyecto.historiaClinica.dto.DoctorDTO;
import com.proyecto.historiaClinica.dto.PacienteDTO;
import com.proyecto.historiaClinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/create")
    public PacienteDTO guardarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        System.out.println(pacienteDTO);
        return pacienteService.guardarPaciente(pacienteDTO);
    }

    @PutMapping("/update/{id}")
    public boolean actualizarPaciente(@PathVariable("id") Long id,@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.actualizarPaciente(pacienteDTO);
    }

    @GetMapping("/lista")
    public List<PacienteDTO> getAll(){
        return pacienteService.obtenerDatosPaciente();
    }

    @GetMapping("/detail/{id}")
    public PacienteDTO obtenerDatosPacientePorId(@PathVariable("id") Long id){

        return pacienteService.obtenerPacientePorId(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean borrarPaciente(@PathVariable("id") Long id){
        return pacienteService.borrarPaciente(id);
    }
}
