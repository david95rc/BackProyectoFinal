package com.proyecto.historiaClinica.controller;

import com.proyecto.historiaClinica.dto.DatosExploracionDTO;
import com.proyecto.historiaClinica.dto.DatosSubjetivosDTO;
import com.proyecto.historiaClinica.service.DatosSubjetivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("datossubjetivos")
public class DatosSubjetivosController {

    @Autowired
    private DatosSubjetivosService datosSubjetivosService;

    @PostMapping()
    public DatosSubjetivosDTO guardarDatosSubjetivos(@RequestBody DatosSubjetivosDTO datosSubjetivosDTO) {
        System.out.println(datosSubjetivosDTO);
        return datosSubjetivosService.guardarDatosSubjetivos(datosSubjetivosDTO);
    }

    @PutMapping()
    public boolean actualizarDatosSubjetivos(@RequestBody DatosSubjetivosDTO datosSubjetivosDTO){
        return datosSubjetivosService.actualizarDatosSubjetivos(datosSubjetivosDTO);
    }

    @GetMapping("datos")
    public List<DatosSubjetivosDTO> getAll(){
        return datosSubjetivosService.obtenerDatosSubjetivos();
    }

    @GetMapping("/{id}")
    public DatosSubjetivosDTO obtenerDatosSubjetivosPorId(@PathVariable("id") Long id){

        return datosSubjetivosService.obtenerDatosSubjetivosPorId(id);
    }

    @DeleteMapping("delete")
    public boolean borrarDatosSubjetivos(@RequestParam("id") Long id){
        return datosSubjetivosService.borrarDatosSubjetivos(id);
    }
}
