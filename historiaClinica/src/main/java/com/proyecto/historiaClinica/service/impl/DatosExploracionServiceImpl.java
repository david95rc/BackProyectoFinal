package com.proyecto.historiaClinica.service.impl;

import com.proyecto.historiaClinica.dto.DatosExploracionDTO;
import com.proyecto.historiaClinica.entities.DatosExploracionEntity;
import com.proyecto.historiaClinica.exceptions.UserNotFoundException;
import com.proyecto.historiaClinica.repository.DatosExploracionRepository;
import com.proyecto.historiaClinica.service.DatosExploracionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatosExploracionServiceImpl implements DatosExploracionService {

    @Autowired
    private DatosExploracionRepository datosExploracionRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public DatosExploracionServiceImpl(DatosExploracionRepository datosSExploracionRepository, ModelMapper modelMapper) {
        this.datosExploracionRepository = datosExploracionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DatosExploracionDTO guardarDatosExploracion(DatosExploracionDTO datosExploracionDTO) {
        DatosExploracionEntity datosExploracionEntity = modelMapper.map(datosExploracionDTO, DatosExploracionEntity.class);
        DatosExploracionEntity usuarioEntityPer = datosExploracionRepository.save(datosExploracionEntity);
        System.out.println(usuarioEntityPer);
        DatosExploracionDTO datosExploracionDTO1 = modelMapper.map(usuarioEntityPer, DatosExploracionDTO.class);
        return datosExploracionDTO1;
    }

    @Override
    public boolean actualizarDatosExploracion(DatosExploracionDTO datosExploracionDTO) {

        if (datosExploracionRepository.existsById(datosExploracionDTO.getId())) {

            DatosExploracionEntity datosExploracionEntity = datosExploracionRepository.save(modelMapper.map(datosExploracionDTO, DatosExploracionEntity.class));

            return true;
        }
        return false;
    }

    @Override
    public boolean borrarDatosExploracion(Long id) {
        if (datosExploracionRepository.existsById(id)) {
            datosExploracionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<DatosExploracionDTO> obtenerDatosExploracion() {
        Iterable<DatosExploracionEntity> datosExploracionEntities = datosExploracionRepository.findAll();
        List<DatosExploracionDTO> datosExploracionDTO2 = new ArrayList<>();

        for(DatosExploracionEntity datosExploracionEntity: datosExploracionEntities){
            datosExploracionDTO2.add(modelMapper.map(datosExploracionEntity, DatosExploracionDTO.class));
        }
        return datosExploracionDTO2;
    }

    @Override
    public DatosExploracionDTO obtenerDatosExploracionPorId(Long id) {
        if (datosExploracionRepository.existsById(id)) {
            DatosExploracionEntity datosExploracionEntity = datosExploracionRepository.findById(id).get();
            return modelMapper.map(datosExploracionRepository.findById(id).get(), DatosExploracionDTO.class);
        } else {
            throw new UserNotFoundException("EL usuario no existe");
        }
    }

    @Override
    public List<DatosExploracionDTO> buscarPorIdHistoria(Long id) {
        System.out.println(datosExploracionRepository.existsByHistoriaClinica_Id(id));
        if (datosExploracionRepository.existsByHistoriaClinica_Id(id)) {
            List<DatosExploracionEntity> datosExploracionEntities = datosExploracionRepository.findByHistoriaClinica_Id(id);
            List<DatosExploracionDTO> datosExploracionDTO2 = new ArrayList<>();

            for (DatosExploracionEntity datosExploracionEntity : datosExploracionEntities) {
                datosExploracionDTO2.add(modelMapper.map(datosExploracionEntity, DatosExploracionDTO.class));
            }
            return datosExploracionDTO2;
        } else {
            throw new UserNotFoundException("No existe ningun tratamiento asociado a la historia clinica");
        }
    }
}
