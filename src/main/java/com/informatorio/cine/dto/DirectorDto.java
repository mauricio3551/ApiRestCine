package com.informatorio.cine.dto;

import com.informatorio.cine.entity.Obra;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DirectorDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private long dni;
    private String fechaAlta;
    private List<ObraDto> obraList = new ArrayList<>();

    public DirectorDto(Long id, String nombre, String apellido, String fechaNacimiento, long dni, String fechaAlta, List<Obra> obraList) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
        this.obraList = tomarObra(obraList);
    }

    public DirectorDto(Long id, String nombre, String apellido, String fechaNacimiento, long dni, String fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
    }

    public DirectorDto() {
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
