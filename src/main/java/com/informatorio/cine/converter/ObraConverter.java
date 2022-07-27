package com.informatorio.cine.converter;

import com.informatorio.cine.dto.ObraDto;
import com.informatorio.cine.entity.Obra;
import org.springframework.stereotype.Component;

@Component
public class ObraConverter {

    public ObraDto toDto(Obra obra){
        return new ObraDto(
                obra.getId(),
                obra.getTitulo(),
                obra.getDescripcion(),
                obra.getDuracion(),
                obra.getInscripcion(),
                obra.getListaActores(),
                obra.getDirector(),
                obra.getCategoria()
        );
    }

    public Obra toEntity(ObraDto obraDto){
        return new Obra(
                obraDto.getId(),
                obraDto.getTitulo(),
                obraDto.getDescripcion(),
                obraDto.getDuracion(),
                obraDto.getInscripcion()
        );
    }
}
