package com.informatorio.cine.converter;

import com.informatorio.cine.dto.ActorDto;
import com.informatorio.cine.entity.Actor;
import org.springframework.stereotype.Component;

@Component
public class ActorConverter {

    public ActorDto toDto(Actor actor){
        return new ActorDto(
                actor.getId(),
                actor.getNombre(),
                actor.getApellido(),
                actor.getFechaNacimiento(),
                actor.getDni(),
                actor.getObraList()
        );
    }

    public Actor toEntity(ActorDto actorDto){
        return new Actor(
                actorDto.getId(),
                actorDto.getNombre(),
                actorDto.getApellido(),
                actorDto.getFechaNacimiento(),
                actorDto.getDni()
        );
    }
}
