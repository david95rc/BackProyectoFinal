package com.proyecto.historiaClinica.service.impl;


import com.proyecto.historiaClinica.dto.PacienteDTO;
import com.proyecto.historiaClinica.entities.PacienteEntity;
import com.proyecto.historiaClinica.exceptions.UserNotFoundException;
import com.proyecto.historiaClinica.repository.PacienteRepository;
import com.proyecto.historiaClinica.service.PacienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public PacienteServiceImpl(PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public PacienteDTO guardarPaciente(PacienteDTO pacienteDTO) {
        PacienteEntity pacienteEntity = modelMapper.map(pacienteDTO, PacienteEntity.class);
        PacienteEntity usuarioEntityPer = pacienteRepository.save(pacienteEntity);
        System.out.println(usuarioEntityPer);
        PacienteDTO pacienteDTO1 = modelMapper.map(usuarioEntityPer, PacienteDTO.class);
        return pacienteDTO1;
    }

    @Override
    public boolean actualizarPaciente(PacienteDTO pacienteDTO) {

        if (pacienteRepository.existsById(pacienteDTO.getId())) {

            PacienteEntity pacienteEntity = pacienteRepository.save(modelMapper.map(pacienteDTO, PacienteEntity.class));

            return true;
        }
        return false;
    }

    @Override
    public boolean borrarPaciente(Long id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<PacienteDTO> obtenerDatosPaciente() {
        Iterable<PacienteEntity> pacienteEntities = pacienteRepository.findAll();
        List<PacienteDTO> pacienteDTO2 = new ArrayList<>();

        for(PacienteEntity pacienteEntity: pacienteEntities){
            pacienteDTO2.add(modelMapper.map(pacienteEntity, PacienteDTO.class));
        }
        return pacienteDTO2;
    }

    @Override
    public PacienteDTO obtenerPacientePorId(Long id) {
        if (pacienteRepository.existsById(id)) {
            PacienteEntity pacienteEntity = pacienteRepository.findById(id).get();
            return modelMapper.map(pacienteRepository.findById(id).get(), PacienteDTO.class);
        } else {
            throw new UserNotFoundException("EL usuario no existe");
        }
    }
}
