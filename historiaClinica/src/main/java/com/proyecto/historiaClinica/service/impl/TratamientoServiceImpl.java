package com.proyecto.historiaClinica.service.impl;

import com.proyecto.historiaClinica.dto.TratamientoDTO;
import com.proyecto.historiaClinica.entities.TratamientoEntity;
import com.proyecto.historiaClinica.exceptions.UserNotFoundException;
import com.proyecto.historiaClinica.repository.TratamientoRepository;
import com.proyecto.historiaClinica.service.TratamientoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public TratamientoServiceImpl(TratamientoRepository tratamientoRepository, ModelMapper modelMapper) {
        this.tratamientoRepository = tratamientoRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public TratamientoDTO guardarTratamiento(TratamientoDTO tratamientoDTO) {
        TratamientoEntity tratamientoEntity = modelMapper.map(tratamientoDTO, TratamientoEntity.class);
        TratamientoEntity usuarioEntityPer = tratamientoRepository.save(tratamientoEntity);
        System.out.println(usuarioEntityPer);
        TratamientoDTO tratamientoDTO1 = modelMapper.map(usuarioEntityPer, TratamientoDTO.class);
        return tratamientoDTO1;
    }

    @Override
    public boolean actualizarTratamiento(TratamientoDTO tratamientoDTO) {

        if (tratamientoRepository.existsById(tratamientoDTO.getId())) {

            TratamientoEntity pacienteEntity = tratamientoRepository.save(modelMapper.map(tratamientoDTO, TratamientoEntity.class));

            return true;
        }
        return false;
    }

    @Override
    public boolean borrarTratamiento(Long id) {
        if (tratamientoRepository.existsById(id)) {
            tratamientoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<TratamientoDTO> obtenerDatosTratamiento() {
        Iterable<TratamientoEntity> tratamientoEntities = tratamientoRepository.findAll();
        List<TratamientoDTO> tratamientoDTO2 = new ArrayList<>();

        for (TratamientoEntity tratamientoEntity : tratamientoEntities) {
            tratamientoDTO2.add(modelMapper.map(tratamientoEntity, TratamientoDTO.class));
        }
        return tratamientoDTO2;
    }

    @Override
    public TratamientoDTO obtenerTratamientoPorId(Long id) {
        if (tratamientoRepository.existsById(id)) {
            TratamientoEntity tratamientoEntity = tratamientoRepository.findById(id).get();
            return modelMapper.map(tratamientoRepository.findById(id).get(), TratamientoDTO.class);
        } else {
            throw new UserNotFoundException("EL usuario no existe");
        }
    }




    @Override
    public List<TratamientoDTO> buscarPorIdHistoria(Long id) {
        System.out.println(tratamientoRepository.existsByHistoriaClinica_Id(id));
        if (tratamientoRepository.existsByHistoriaClinica_Id(id)) {
            List<TratamientoEntity> tratamientoEntities = tratamientoRepository.findByHistoriaClinica_Id(id);
            List<TratamientoDTO> tratamientoDTO2 = new ArrayList<>();

            for (TratamientoEntity tratamientoEntity : tratamientoEntities) {
                tratamientoDTO2.add(modelMapper.map(tratamientoEntity, TratamientoDTO.class));
            }
            return tratamientoDTO2;
        } else {
            throw new UserNotFoundException("No existe ningun tratamiento asociado a la historia clinica");
        }
    }
    }
