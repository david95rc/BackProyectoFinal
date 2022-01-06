package com.proyecto.historiaClinica.service.impl;


import com.proyecto.historiaClinica.dto.DiagnosticoDTO;
import com.proyecto.historiaClinica.entities.DiagnosticoEntity;
import com.proyecto.historiaClinica.exceptions.UserNotFoundException;
import com.proyecto.historiaClinica.repository.DiagnosticoRepository;
import com.proyecto.historiaClinica.service.DiagnosticoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public DiagnosticoServiceImpl(DiagnosticoRepository diagnosticoRepository, ModelMapper modelMapper) {
        this.diagnosticoRepository = diagnosticoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DiagnosticoDTO guardarDiagnostico(DiagnosticoDTO diagnosticoDTO) {
        DiagnosticoEntity diagnosticoEntity = modelMapper.map(diagnosticoDTO, DiagnosticoEntity.class);
        DiagnosticoEntity usuarioEntityPer = diagnosticoRepository.save(diagnosticoEntity);
        System.out.println(usuarioEntityPer);
        DiagnosticoDTO diagnosticoDTO1 = modelMapper.map(usuarioEntityPer, DiagnosticoDTO.class);
        return diagnosticoDTO1;
    }

    @Override
    public boolean actualizarDiagnostico(DiagnosticoDTO diagnosticoDTO) {

        if (diagnosticoRepository.existsById(diagnosticoDTO.getId())) {

            DiagnosticoEntity diagnosticoEntity = diagnosticoRepository.save(modelMapper.map(diagnosticoDTO, DiagnosticoEntity.class));

            return true;
        }
        return false;
    }

    @Override
    public boolean borrarDiagnostico(Long id) {
        if (diagnosticoRepository.existsById(id)) {
            diagnosticoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<DiagnosticoDTO> obtenerDatosDiagnostico() {
        Iterable<DiagnosticoEntity> diagnosticoEntities = diagnosticoRepository.findAll();
        List<DiagnosticoDTO> diagnosticoDTO2 = new ArrayList<>();

        for (DiagnosticoEntity diagnosticoEntity : diagnosticoEntities) {
            diagnosticoDTO2.add(modelMapper.map(diagnosticoEntity, DiagnosticoDTO.class));
        }
        return diagnosticoDTO2;
    }

    @Override
    public DiagnosticoDTO obtenerDiagnosticoPorId(Long id) {
        if (diagnosticoRepository.existsById(id)) {
            DiagnosticoEntity diagnosticoEntity = diagnosticoRepository.findById(id).get();
            return modelMapper.map(diagnosticoRepository.findById(id).get(), DiagnosticoDTO.class);
        } else {
            throw new UserNotFoundException("EL usuario no existe");
        }
    }

    @Override
    public List<DiagnosticoDTO> buscarPorIdHistoria(Long id) {
        System.out.println(diagnosticoRepository.existsByHistoriaClinica_Id(id));
        if (diagnosticoRepository.existsByHistoriaClinica_Id(id)) {
            List<DiagnosticoEntity> diagnosticoEntities = diagnosticoRepository.findByHistoriaClinica_Id(id);
            List<DiagnosticoDTO> diagnosticoDTO2 = new ArrayList<>();

            for (DiagnosticoEntity diagnosticoEntity : diagnosticoEntities) {
                diagnosticoDTO2.add(modelMapper.map(diagnosticoEntity, DiagnosticoDTO.class));
            }
            return diagnosticoDTO2;
        } else {
            throw new UserNotFoundException("No existe ningun tratamiento asociado a la historia clinica");
        }
    }


}
