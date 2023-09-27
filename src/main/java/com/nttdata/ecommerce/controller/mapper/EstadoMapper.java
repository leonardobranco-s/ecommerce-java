package com.nttdata.ecommerce.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nttdata.ecommerce.model.dto.EstadoDto;
import com.nttdata.ecommerce.model.entity.Estado;

@Component
public class EstadoMapper {
    public Estado toEntity(EstadoDto input) {
        return new Estado(input.getId(), input.getNome(), input.getSigla());

    }
    public EstadoDto toDto(Estado entity) {
        return new EstadoDto(entity.getId(), entity.getNome(), entity.getSigla());  
    }
    public List<EstadoDto> toListDto(List<Estado> estadoList){
        List<EstadoDto> estadoDtos = new ArrayList<>();
        for (Estado estado : estadoList) {
            estadoDtos.add(toDto(estado));
        }
        return estadoDtos;
    }
    public Estado merge (Estado entity, EstadoDto input) {
        if (!entity.getId().equals(input.getId())){
            throw new IllegalArgumentException("Id não pode ser alterado.");
        }
        if (!entity.getNome().equals(input.getNome())){
            entity.setNome(input.getNome());
        }
        if (!entity.getSigla().equals(input.getSigla())){
            entity.setSigla(input.getSigla());
        }
        return entity;
    }
}
