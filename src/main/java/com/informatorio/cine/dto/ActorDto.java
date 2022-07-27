package com.informatorio.cine.dto;

import com.informatorio.cine.entity.Obra;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ActorDto {

    private long id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private long dni;
    private List<ObraDto> obraList = new ArrayList<>();

    public ActorDto(long id, String nombre, String apellido, String fechaNacimiento, long dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
    }

    public ActorDto(long id, String nombre, String apellido, String fechaNacimiento, long dni, List<Obra> obraList) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.obraList = tomarObras(obraList);
    }

    public ActorDto() {
    }

    private List<ObraDto> tomarObras(List<Obra> lista){
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
