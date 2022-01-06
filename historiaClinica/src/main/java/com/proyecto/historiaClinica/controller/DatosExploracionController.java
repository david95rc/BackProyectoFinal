package com.proyecto.historiaClinica.controller;

import com.proyecto.historiaClinica.dto.DatosExploracionDTO;
import com.proyecto.historiaClinica.dto.DoctorDTO;
import com.proyecto.historiaClinica.service.DatosExploracionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("datosexploracion")

public class DatosExploracionController {

    @Autowired
    private DatosExploracionService datosExploracionService;

    @PostMapping("/create")
    public DatosExploracionDTO guardarDatosExploracion(@RequestBody DatosExploracionDTO datosExploracionDTO) {
        System.out.println(datosExploracionDTO);
        return datosExploracionService.guardarDatosExploracion(datosExploracionDTO);
    }

    @PutMapping("/update/{id}")
    public boolean actualizarDatosExploracion(@RequestBody DatosExploracionDTO datosExploracionDTO){
        return datosExploracionService.actualizarDatosExploracion(datosExploracionDTO);
    }

    @GetMapping("/lista")
    public List<DatosExploracionDTO> getAll(){
        return datosExploracionService.obtenerDatosExploracion();
    }

    @GetMapping("/detail/{id}")
    public DatosExploracionDTO obtenerDatosExploracionPorId(@PathVariable("id") Long id){

        return datosExploracionService.obtenerDatosExploracionPorId(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean borrarDatosExploracion(@RequestParam("id") Long id){
        return datosExploracionService.borrarDatosExploracion(id);
    }


}
