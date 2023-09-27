package com.nttdata.ecommerce.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.ecommerce.controller.mapper.EstadoMapper;
import com.nttdata.ecommerce.model.dto.EstadoDto;
import com.nttdata.ecommerce.model.entity.Estado;
import com.nttdata.ecommerce.model.repository.EstadoRepository;

@Service

public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private EstadoMapper estadoMapper;

@Transactional
    public EstadoDto create(EstadoDto input){
        return estadoMapper.toDto(estadoRepository.save(estadoMapper.toEntity(input)));
    }

@Transactional    
    public List<EstadoDto> createList(List<EstadoDTO> inputList) {
        return estadoMapper.toDtoList(
            estadoRepository.saveAll(
                estadoMapper.toEntityList(inputList)));
    }

    public Page<EstadoDto> findPage(Pageable pageable) {
        return estadoMapper.toDtoPage(estadoRepository.findAll(pageable), pageable);
    }
    public EstadoDto findByID (Long id) {
        return estadoMapper.toDto(findEntity(id));
    }
    public EstadoDto findByID (String sigla) {
        return estadoMapper.toDto(estadoRepository.findBySigla(sigla).orElseThrow());
    }
    private Estado findEntity (Long id) {
        return estadoRepository.findById(id).orElseThrow();
    }
    @Transactional 
    public EstadoDto update (Long id, EstadoDto input) { 
        return estadoMapper.toDto(estadoRepository.save(estadoMapper.merge(findEntity(id),input)));
    }
    @Transactional
    public void delete (Long id) {
        estadoRepository.delete(findEntity(id));
    }
}
