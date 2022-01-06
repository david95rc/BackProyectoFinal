package com.proyecto.historiaClinica.service.impl;

import com.proyecto.historiaClinica.dto.HistoriaClinicaDTO;
import com.proyecto.historiaClinica.entities.HistoriaClinicaEntity;
import com.proyecto.historiaClinica.exceptions.UserNotFoundException;
import com.proyecto.historiaClinica.repository.HistoriaClinicaRepository;
import com.proyecto.historiaClinica.service.HistoriaClinicaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public HistoriaClinicaServiceImpl(HistoriaClinicaRepository historiaClinicaRepository, ModelMapper modelMapper) {
        this.historiaClinicaRepository = historiaClinicaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public HistoriaClinicaDTO guardarHistoriaClinica(HistoriaClinicaDTO historiaClinicaDTO) {
        HistoriaClinicaEntity historiaClinicaEntity = modelMapper.map(historiaClinicaDTO, HistoriaClinicaEntity.class);
        HistoriaClinicaEntity usuarioEntityPer = historiaClinicaRepository.save(historiaClinicaEntity);
        System.out.println(usuarioEntityPer);
        HistoriaClinicaDTO historiaClinicaDTO1 = modelMapper.map(usuarioEntityPer, HistoriaClinicaDTO.class);
        return historiaClinicaDTO1;
    }

    @Override
    public boolean actualizarHistoriaClinica(HistoriaClinicaDTO historiaClinicaDTO) {

        if (historiaClinicaRepository.existsById(historiaClinicaDTO.getId())) {

            HistoriaClinicaEntity historiaClinicaEntity = historiaClinicaRepository.save(modelMapper.map(historiaClinicaDTO, HistoriaClinicaEntity.class));

            return true;
        }
        return false;
    }

    @Override
    public boolean borrarHistoriaClinica(Long id) {
        if (historiaClinicaRepository.existsById(id)) {
            historiaClinicaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<HistoriaClinicaDTO> obtenerDatosHistoriaClinica() {
        Iterable<HistoriaClinicaEntity> historiaClinicaEntities = historiaClinicaRepository.findAll();
        List<HistoriaClinicaDTO> historiaClinicaDTO2 = new ArrayList<>();

        for(HistoriaClinicaEntity historiaClinicaEntity: historiaClinicaEntities){
            historiaClinicaDTO2.add(modelMapper.map(historiaClinicaEntity, HistoriaClinicaDTO.class));
        }
        return historiaClinicaDTO2;
    }

    @Override
    public HistoriaClinicaDTO obtenerHistoriaClinicaPorId(Long id) {
        if (historiaClinicaRepository.existsById(id)) {
            HistoriaClinicaEntity historiaClinicaEntity = historiaClinicaRepository.findById(id).get();
            return modelMapper.map(historiaClinicaRepository.findById(id).get(), HistoriaClinicaDTO.class);
        } else {
            throw new UserNotFoundException("EL usuario no existe");
        }
    }
}
