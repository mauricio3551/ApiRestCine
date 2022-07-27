package com.informatorio.cine.converter;

import com.informatorio.cine.dto.DirectorDto;
import com.informatorio.cine.entity.Director;
import org.springframework.stereotype.Component;

@Component
public class DirectorConverter {

    public DirectorDto toDto(Director director){
        return new DirectorDto(
                director.getId(),
                director.getNombre(),
                director.getApellido(),
                director.getFechaNacimiento(),
                director.getDni(),
                director.getFechaAlta(),
                director.getObraList()
        );
    }

    public Director toEntity(DirectorDto directorDto){
        return new Director(
                directorDto.getId(),
                directorDto.getNombre(),
                directorDto.getApellido(),
                directorDto.getFechaNacimiento(),
                directorDto.getDni(),
                directorDto.getFechaAlta()
        );
    }
}
