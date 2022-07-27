package com.informatorio.cine.dto;

import com.informatorio.cine.entity.Obra;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CategoriaDto {
    private long id;
    private String nombre;
    private List<ObraDto> obraList = new ArrayList<>();

    public CategoriaDto(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public CategoriaDto(long id, String nombre, List<Obra> obraList) {
        this.id = id;
        this.nombre = nombre;
        this.obraList = tomarObra(obraList);
    }

    public CategoriaDto() {
    }

    private List<ObraDto> tomarObra(List<Obra> lista){
        return lista.stream()
                .map(obra -> new ObraDto(
                        obra.getId(),
                        obra.getTitulo(),
                        obra.getDescripcion(),
                        obra.getDuracion(),
                        obra.getInscripcion()
                ))
                .collect(Collectors.toList());
    }
}
