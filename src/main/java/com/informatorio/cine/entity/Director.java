package com.informatorio.cine.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private long dni;
    private String fechaAlta;
    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "obraDirector")
    private List<Obra> obraList = new ArrayList<>();

    public Director(Long id, String nombre, String apellido, String fechaNacimiento, long dni, String fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
    }

    public Director() {
    }
}
