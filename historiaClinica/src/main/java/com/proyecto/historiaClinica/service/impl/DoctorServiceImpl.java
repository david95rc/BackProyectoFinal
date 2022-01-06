package com.proyecto.historiaClinica.service.impl;

import com.proyecto.historiaClinica.dto.DoctorDTO;
import com.proyecto.historiaClinica.entities.DoctorEntity;
import com.proyecto.historiaClinica.exceptions.UserNotFoundException;
import com.proyecto.historiaClinica.repository.DoctorRepository;
import com.proyecto.historiaClinica.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public DoctorServiceImpl(DoctorRepository doctorRepository, ModelMapper modelMapper) {
        this.doctorRepository = doctorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DoctorDTO guardarDoctor(DoctorDTO doctorDTO) {
        DoctorEntity doctorEntity = modelMapper.map(doctorDTO, DoctorEntity.class);
        DoctorEntity usuarioEntityPer = doctorRepository.save(doctorEntity);
        System.out.println(usuarioEntityPer);
        DoctorDTO doctorDTO1 = modelMapper.map(usuarioEntityPer, DoctorDTO.class);
        return doctorDTO1;
    }

    @Override
    public boolean actualizarDoctor(DoctorDTO doctorDTO) {

        if (doctorRepository.existsById(doctorDTO.getId())) {

            DoctorEntity doctorEntity = doctorRepository.save(modelMapper.map(doctorDTO, DoctorEntity.class));

            return true;
        }
        return false;
    }

    @Override
    public boolean borrarDoctor(Long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<DoctorDTO> obtenerDatosDoctor() {
        Iterable<DoctorEntity> doctorEntities = doctorRepository.findAll();
        List<DoctorDTO> doctorDTO2 = new ArrayList<>();

        for(DoctorEntity doctorEntity: doctorEntities){
            doctorDTO2.add(modelMapper.map(doctorEntity, DoctorDTO.class));
        }
        return doctorDTO2;
    }

    @Override
    public DoctorDTO obtenerDoctorPorId(Long id) {
        if (doctorRepository.existsById(id)) {
            DoctorEntity doctorEntity = doctorRepository.findById(id).get();
            return modelMapper.map(doctorRepository.findById(id).get(), DoctorDTO.class);
        } else {
            throw new UserNotFoundException("EL usuario no existe");
        }
    }

    @Override
    public List<DoctorDTO> obtenerDoctorPorNombre(String nombre) {
        if (nombre != "" && nombre != null){
            List<DoctorEntity> doctorEntities = doctorRepository.findByNombre(nombre);
            List<DoctorDTO> doctorDTO3 = new ArrayList<>();
            doctorEntities.forEach(doctorEntity -> {
                doctorDTO3.add(modelMapper.map(doctorEntity, DoctorDTO.class));
            });
            return doctorDTO3;
        } else {
            throw new UserNotFoundException("Nombre no puede ser vacio");
        }
    }
}
