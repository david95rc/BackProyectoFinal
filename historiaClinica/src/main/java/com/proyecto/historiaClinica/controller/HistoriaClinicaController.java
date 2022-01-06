package com.proyecto.historiaClinica.controller;

import com.proyecto.historiaClinica.dto.*;
import com.proyecto.historiaClinica.entities.TratamientoEntity;
import com.proyecto.historiaClinica.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("historiaclinica")
public class HistoriaClinicaController {


    @Autowired
    private HistoriaClinicaService historiaClinicaService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private TratamientoService tratamientoService;
    @Autowired
    private DiagnosticoService diagnosticoService;
    @Autowired
    private DatosSubjetivosService datosSubjetivosService;
    @Autowired
    private DatosExploracionService datosExploracionService;

    @PostMapping("/create")
    public HistoriaClinicaDTO guardarHistoriaClinica(@RequestBody HistoriaClinicaDTO historiaClinicaDTO) {
        System.out.println(historiaClinicaDTO);
        return historiaClinicaService.guardarHistoriaClinica(historiaClinicaDTO);
    }

    @PutMapping("/update/{id}")
    public boolean actualizarHistoriaClinica(@PathVariable("id") Long id, @RequestBody HistoriaClinicaDTO historiaClinicaDTO) {
        return historiaClinicaService.actualizarHistoriaClinica(historiaClinicaDTO);
    }

    @GetMapping("/lista")
    public List<HistoriaClinicaDTO> getAll() {
        return historiaClinicaService.obtenerDatosHistoriaClinica();
    }

    @GetMapping("/listaPaciente")
    public List<PacienteDTO> getAllP() {
        return pacienteService.obtenerDatosPaciente();
    }

    @GetMapping("/tratamiento")
    public List<TratamientoDTO> getAllT() {
        return tratamientoService.obtenerDatosTratamiento();
    }

    @GetMapping("/detail/{id}")
    public HistoriaClinicaDTO obtenerDatosHistoriaClinicaPorId(@PathVariable("id") Long id) {

        return historiaClinicaService.obtenerHistoriaClinicaPorId(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean borrarHistoriaClinica(@PathVariable("id") Long id) {
        return historiaClinicaService.borrarHistoriaClinica(id);
    }

    @GetMapping("/tratamientoh/{id}")
    public List<TratamientoDTO> buscarTratamiento(@PathVariable("id") Long id) {
        return tratamientoService.buscarPorIdHistoria(id);
    }

    @GetMapping("/diagnosticoh/{id}")
    public List<DiagnosticoDTO> buscarDiagnostico(@PathVariable("id") Long id) {
        return diagnosticoService.buscarPorIdHistoria(id);
    }

    @GetMapping("/datosSubjetivosh/{id}")
    public List<DatosSubjetivosDTO> buscarDatosSubjetivos(@PathVariable("id") Long id) {
        return datosSubjetivosService.buscarPorIdHistoria(id);
    }


    @GetMapping("/datosExploracionh/{id}")
    public List<DatosExploracionDTO> buscarDatosExploracion(@PathVariable("id") Long id) {
        return datosExploracionService.buscarPorIdHistoria(id);
    }

}
