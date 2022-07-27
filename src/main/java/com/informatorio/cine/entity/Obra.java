package com.informatorio.cine.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.informatorio.cine.dto.ObraDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String descripcion;
    private int duracion;
    private String inscripcion;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Obra_Actor",
            joinColumns = @JoinColumn(name = "obra_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> listaActores = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "obraDirector")
    private Director director;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "obraCategoria")
    private Categoria categoria;

    public Obra() {

    }

    public Obra(long id, String titulo, String descripcion, int duracion, String inscripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.inscripcion = inscripcion;
    }
}

