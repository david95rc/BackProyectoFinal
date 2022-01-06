package com.proyecto.historiaClinica.controller;
import com.proyecto.historiaClinica.dto.DiagnosticoDTO;
import com.proyecto.historiaClinica.service.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("diagnostico")
public class DiagnosticoController {

    @Autowired
    private DiagnosticoService diagnosticoService;

    @PostMapping("/create")
    public DiagnosticoDTO guardarDiagnostico(@RequestBody DiagnosticoDTO diagnosticoDTO) {
        System.out.println(diagnosticoDTO);
        return diagnosticoService.guardarDiagnostico(diagnosticoDTO);
    }

    @PutMapping("/update/{id}")
    public boolean actualizarDiagnostico(@RequestBody DiagnosticoDTO diagnosticoDTO){
        return diagnosticoService.actualizarDiagnostico(diagnosticoDTO);
    }

    @GetMapping("/lista")
    public List<DiagnosticoDTO> getAll(){
        return diagnosticoService.obtenerDatosDiagnostico();
    }

    @GetMapping("/detail/{id}")
    public DiagnosticoDTO obtenerDatosDiagnosticoPorId(@PathVariable("id") Long id){

        return diagnosticoService.obtenerDiagnosticoPorId(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean borrarDiagnostico(@RequestParam("id") Long id){
        return diagnosticoService.borrarDiagnostico(id);
    }
}
