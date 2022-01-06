package com.proyecto.historiaClinica.service.impl;


import com.proyecto.historiaClinica.dto.DatosSubjetivosDTO;
import com.proyecto.historiaClinica.entities.DatosSubjetivosEntity;
import com.proyecto.historiaClinica.exceptions.UserNotFoundException;
import com.proyecto.historiaClinica.repository.DatosSubjetivosRepository;
import com.proyecto.historiaClinica.service.DatosSubjetivosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatosSubjetivosServiceImpl implements DatosSubjetivosService {

    @Autowired
    private DatosSubjetivosRepository datosSubjetivosRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public DatosSubjetivosServiceImpl(DatosSubjetivosRepository datosSubjetivosRepository, ModelMapper modelMapper) {
        this.datosSubjetivosRepository = datosSubjetivosRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DatosSubjetivosDTO guardarDatosSubjetivos(DatosSubjetivosDTO datosSubjetivosDTO) {
        DatosSubjetivosEntity datosSubjetivosEntity = modelMapper.map(datosSubjetivosDTO, DatosSubjetivosEntity.class);
        DatosSubjetivosEntity usuarioEntityPer = datosSubjetivosRepository.save(datosSubjetivosEntity);
        System.out.println(usuarioEntityPer);
        DatosSubjetivosDTO datosSubjetivosDTO1 = modelMapper.map(usuarioEntityPer, DatosSubjetivosDTO.class);
        return datosSubjetivosDTO1;
    }

    @Override
    public boolean actualizarDatosSubjetivos(DatosSubjetivosDTO datosSubjetivosDTO) {

        if (datosSubjetivosRepository.existsById(datosSubjetivosDTO.getId())) {

            DatosSubjetivosEntity datosSubjetivosEntity = datosSubjetivosRepository.save(modelMapper.map(datosSubjetivosDTO, DatosSubjetivosEntity.class));

            return true;
        }
        return false;
    }

    @Override
    public boolean borrarDatosSubjetivos(Long id) {
        if (datosSubjetivosRepository.existsById(id)) {
            datosSubjetivosRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<DatosSubjetivosDTO> obtenerDatosSubjetivos() {
        Iterable<DatosSubjetivosEntity> datosSubjetivosEntities = datosSubjetivosRepository.findAll();
        List<DatosSubjetivosDTO> datosSubjetivosDTO2 = new ArrayList<>();

        for(DatosSubjetivosEntity datosSubjetivosEntity: datosSubjetivosEntities){
            datosSubjetivosDTO2.add(modelMapper.map(datosSubjetivosEntity, DatosSubjetivosDTO.class));
        }
        return datosSubjetivosDTO2;
    }

    @Override
    public DatosSubjetivosDTO obtenerDatosSubjetivosPorId(Long id) {
        if (datosSubjetivosRepository.existsById(id)) {
            DatosSubjetivosEntity datosSubjetivosEntity = datosSubjetivosRepository.findById(id).get();
            return modelMapper.map(datosSubjetivosRepository.findById(id).get(), DatosSubjetivosDTO.class);
        } else {
            throw new UserNotFoundException("EL usuario no existe");
        }
    }
    @Override
    public List<DatosSubjetivosDTO> buscarPorIdHistoria(Long id) {
        System.out.println(datosSubjetivosRepository.existsByHistoriaClinica_Id(id));
        if (datosSubjetivosRepository.existsByHistoriaClinica_Id(id)) {
            List<DatosSubjetivosEntity> datosSubjetivosEntities = datosSubjetivosRepository.findByHistoriaClinica_Id(id);
            List<DatosSubjetivosDTO> datosSubjetivosDTO2 = new ArrayList<>();

            for (DatosSubjetivosEntity datosSubjetivosEntity : datosSubjetivosEntities) {
                datosSubjetivosDTO2.add(modelMapper.map(datosSubjetivosEntity, DatosSubjetivosDTO.class));
            }
            return datosSubjetivosDTO2;
        } else {
            throw new UserNotFoundException("No existe ningun tratamiento asociado a la historia clinica");
        }
    }

}
