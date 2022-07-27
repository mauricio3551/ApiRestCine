package com.informatorio.cine.service;

import com.informatorio.cine.converter.ObraConverter;
import com.informatorio.cine.dto.ObraDto;
import com.informatorio.cine.entity.Actor;
import com.informatorio.cine.entity.Categoria;
import com.informatorio.cine.entity.Director;
import com.informatorio.cine.entity.Obra;
import com.informatorio.cine.repository.ActorRepository;
import com.informatorio.cine.repository.CategoriaRepository;
import com.informatorio.cine.repository.DirectorRepository;
import com.informatorio.cine.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObraService {

    @Autowired
    private ObraRepository obraRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ObraConverter obraConverter;

    public List<ObraDto> getAllObras(){
        return obraRepository
                .findAll()
                .stream()
                .map(obra -> obraConverter.toDto(obra))
                .collect(Collectors.toList());
    }

    public ObraDto getObra(Long id){
        return obraRepository
                .findById(id)
                .map(obra -> obraConverter.toDto(obra))
                .orElse(null);
    }

    public ObraDto postObra(ObraDto obraDto){
        Obra obra = obraRepository.save(obraConverter.toEntity(obraDto));
        return obraConverter.toDto(obra);
    }

    public ObraDto putObra(Long id, ObraDto obraDto){
        Obra nuevosDatosObra = obraConverter.toEntity(obraDto);
        Obra obraModificada = obraRepository.findById(id)
                .map(obra -> {
                    obra.setTitulo(nuevosDatosObra.getTitulo());
                    obra.setDescripcion(nuevosDatosObra.getDescripcion());
                    obra.setDuracion(nuevosDatosObra.getDuracion());
                    obra.setInscripcion(nuevosDatosObra.getInscripcion());
                    return obraRepository.save(obra);
                }).orElseGet(() -> obraRepository.save(nuevosDatosObra));

        return obraConverter.toDto(obraModificada);
    }

    public ObraDto putDirectorObra(Long idObra, Long idDirector){
        Director director = directorRepository.findById(idDirector).orElse(null);
        Obra obra = obraRepository
                .findById(idObra)
                .map(o -> {
                    if (director != null) {
                      o.setDirector(director);
                      return o;
                    }
                    return o;
                })
                .orElse(null);
        director.getObraList().add(obra);
        directorRepository.save(director);
        obraRepository.save(obra);
        return obraConverter.toDto(obra);
    }

    public ObraDto putCategoriaObra(Long idObra, Long idCategoria){
        Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);
        Obra obra = obraRepository
                .findById(idObra)
                .map(o ->{
                    if(categoria != null){
                        o.setCategoria(categoria);
                        return o;
                    }
                    return o;
                })
                .orElse(null);
        categoria.getObraList().add(obra);
        categoriaRepository.save(categoria);
        obraRepository.save(obra);
        return obraConverter.toDto(obra);
    }

    public ObraDto putActorObra(Long idObra, Long idActor){
        Actor actor = actorRepository.findById(idActor).orElse(null);
        Obra obra = obraRepository
                .findById(idObra)
                .map(o ->{
                    if(actor != null){
                        o.getListaActores().add(actor);
                        return o;
                    }
                    return o;
                    })
                .orElse(null);
        actor.getObraList().add(obra);
        actorRepository.save(actor);
        obraRepository.save(obra);
        return obraConverter.toDto(obra);
    }

    public void deleteObra(Long id){
        obraRepository.deleteById(id);
    }
}
