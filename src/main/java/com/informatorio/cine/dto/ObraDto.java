package com.informatorio.cine.dto;

import com.informatorio.cine.entity.Actor;
import com.informatorio.cine.entity.Categoria;
import com.informatorio.cine.entity.Director;
import com.informatorio.cine.entity.Obra;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ObraDto {

    @ApiModelProperty(notes = "Obra ID", example = "1", required = true)
    private long id;
    private String titulo;
    private String descripcion;
    private int duracion;
    private String inscripcion;
    private List<ActorDto> listaActores = new ArrayList<>();
    private DirectorDto director;
    private CategoriaDto categoria;

    public ObraDto() {
    }

    public ObraDto(long id, String titulo, String descripcion, int duracion, String inscripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.inscripcion = inscripcion;
    }

    public ObraDto(long id,
                   String titulo,
                   String descripcion,
                   int duracion,
                   String inscripcion,
                   List<Actor> listaActores,
                   Director director,
                   Categoria categoria)  {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.inscripcion = inscripcion;
        this.listaActores = tomarActores(listaActores);
        this.director =  tomarDirector(director);
        this.categoria = tomarCategoria(categoria);
    }

    private List<ActorDto> tomarActores(List<Actor> lista){
        return lista.stream()
                .map(actor -> new ActorDto(
                        actor.getId(),
                        actor.getNombre(),
                        actor.getApellido(),
                        actor.getFechaNacimiento(),
                        actor.getDni()
                        ))
                .collect(Collectors.toList());
    }

    private DirectorDto tomarDirector(Director director){
        if(director != null){
            return new DirectorDto(
                    director.getId(),
                    director.getNombre(),
                    director.getApellido(),
                    director.getFechaNacimiento(),
                    director.getDni(),
                    director.getFechaAlta()
            );
        }
        return null;
    }

    private CategoriaDto tomarCategoria(Categoria categoria){
        if (categoria == null) {
            return null;
        }
        return new CategoriaDto(
                categoria.getId(),
                categoria.getNombre()
        );
    }
}
