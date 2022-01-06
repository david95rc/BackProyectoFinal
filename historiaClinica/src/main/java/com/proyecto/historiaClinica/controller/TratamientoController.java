package com.proyecto.historiaClinica.controller;
import com.proyecto.historiaClinica.dto.TratamientoDTO;
import com.proyecto.historiaClinica.service.TratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tratamiento")

public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

    @PostMapping("/create")
    public TratamientoDTO guardarTratamiento(@RequestBody TratamientoDTO tratamientoDTO) {
        System.out.println(tratamientoDTO);
        return tratamientoService.guardarTratamiento(tratamientoDTO);
    }

    @PutMapping("/update/{id}")
    public boolean actualizarTratamiento(@RequestBody TratamientoDTO tratamientoDTO){
        return tratamientoService.actualizarTratamiento(tratamientoDTO);
    }

    @GetMapping("/lista")
    public List<TratamientoDTO> getAll(){
        return tratamientoService.obtenerDatosTratamiento();
    }

    @GetMapping("/detail/{id}")
    public TratamientoDTO obtenerDatosTratamientoPorId(@PathVariable("id") Long id){

        return tratamientoService.obtenerTratamientoPorId(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean borrarTratamiento(@PathVariable("id") Long id){
        return tratamientoService.borrarTratamiento(id);
    }
}
