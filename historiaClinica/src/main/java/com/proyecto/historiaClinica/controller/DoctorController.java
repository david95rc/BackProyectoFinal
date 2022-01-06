package com.proyecto.historiaClinica.controller;


import com.proyecto.historiaClinica.dto.DoctorDTO;
import com.proyecto.historiaClinica.exceptions.BadRequestException;
import com.proyecto.historiaClinica.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/create")
    public DoctorDTO guardarDoctor(@RequestBody DoctorDTO doctorDTO) {
       // System.out.println(doctorDTO);
        if(doctorDTO == null){
            throw new BadRequestException("datos de doctor invalidos");
        }
        return doctorService.guardarDoctor(doctorDTO);
    }

    @PutMapping("/update/{id}")
    public boolean actualizarDoctor(@PathVariable("id") Long id,@RequestBody DoctorDTO doctorDTO){
        return doctorService.actualizarDoctor(doctorDTO);
    }

    @GetMapping("/lista")
    public List<DoctorDTO> getAll(){
        return doctorService.obtenerDatosDoctor();
    }

    @GetMapping("/detail/{id}")
    public DoctorDTO obtenerDatosDoctorPorId(@PathVariable("id") Long id){

        return doctorService.obtenerDoctorPorId(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean borrarDoctor(@PathVariable("id") Long id){
        return doctorService.borrarDoctor(id);
    }

    @GetMapping("/porNombre")
    public List<DoctorDTO> obtenerPorNombre(@RequestParam("nombre") String nombre){
        return doctorService.obtenerDoctorPorNombre(nombre);
    }

/*

    @RequestMapping(value = "datos")
    public DoctorDTO editar() {
        /creamos la variable
        DoctorDTO usuario = new DoctorDTO();
        //usuario.setId(id);
        usuario.setNombre("juano");
        usuario.setApellido("cifuentes");
        usuario.setEmail("dav@adad");
        usuario.setTelefono("3213121");
        usuario.setDireccion("wqwqqw");
        usuario.setEspecialidad("neurocirujano");
        return usuario;
    }*/
}