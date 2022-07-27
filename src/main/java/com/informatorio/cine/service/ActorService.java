package com.informatorio.cine.service;

import com.informatorio.cine.converter.ActorConverter;
import com.informatorio.cine.dto.ActorDto;
import com.informatorio.cine.entity.Actor;
import com.informatorio.cine.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorConverter actorConverter;

    public List<ActorDto> getAllActors(){
        return actorRepository
                .findAll()
                .stream()
                .map(actor -> actorConverter.toDto(actor))
                .collect(Collectors.toList());
    }

    public ActorDto getActor(Long id){
        return actorRepository
                .findById(id)
                .map(actor -> actorConverter.toDto(actor))
                .orElse(null);
    }

    public ActorDto postActor(ActorDto actorDto){
        Actor actor = actorRepository.save(actorConverter.toEntity(actorDto));
        return actorConverter.toDto(actor);
    }

    public ActorDto putActor(Long id, ActorDto actorDto){
        Actor nuevoDatosActor = actorConverter.toEntity(actorDto);
        Actor actorModificado = actorRepository
                .findById(id)
                .map(actor -> {
                    actor.setNombre(nuevoDatosActor.getNombre());
                    actor.setApellido(nuevoDatosActor.getApellido());
                    actor.setFechaNacimiento(nuevoDatosActor.getFechaNacimiento());
                    actor.setDni(nuevoDatosActor.getDni());
                    return actorRepository.save(actor);
                })
                .orElseGet(() -> actorRepository.save(nuevoDatosActor));

        return actorConverter.toDto(actorModificado);

    }

    public void deleteActor(Long id){
        actorRepository.deleteById(id);
    }
}
