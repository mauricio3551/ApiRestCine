package com.informatorio.cine.converter;

import com.informatorio.cine.dto.CategoriaDto;
import com.informatorio.cine.entity.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaConverter {

    public CategoriaDto toDto(Categoria categoria){
        return new CategoriaDto(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getObraList()
        );
    }

    public Categoria toEntity(CategoriaDto categoriaDto){
        return new Categoria(
                categoriaDto.getId(),
                categoriaDto.getNombre()
        );
    }
}
