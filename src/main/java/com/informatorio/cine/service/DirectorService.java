package com.informatorio.cine.service;

import com.informatorio.cine.converter.DirectorConverter;
import com.informatorio.cine.dto.DirectorDto;
import com.informatorio.cine.entity.Director;
import com.informatorio.cine.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private DirectorConverter directorConverter;

    public List<DirectorDto> getAllDirectors(){
        return directorRepository
                .findAll()
                .stream()
                .map(director -> directorConverter.toDto(director))
                .collect(Collectors.toList());
    }

    public DirectorDto getDirector(Long id){
        return directorRepository
                .findById(id)
                .map(director -> directorConverter.toDto(director))
                .orElse(null);
    }

    public DirectorDto postDirector(DirectorDto directorDto){
        Director director = directorRepository.save(directorConverter.toEntity(directorDto));
        return directorConverter.toDto(director);
    }

    public DirectorDto putDirector(Long id, DirectorDto directorDto){
        Director nuevosDatosDirector = directorConverter.toEntity(directorDto);
        Director directorModificado = directorRepository
                .findById(id)
                .map(director -> {
                    director.setNombre(nuevosDatosDirector.getNombre());
                    director.setApellido(nuevosDatosDirector.getApellido());
                    director.setFechaNacimiento(nuevosDatosDirector.getFechaNacimiento());
                    director.setDni(nuevosDatosDirector.getDni());
                    director.setFechaAlta(nuevosDatosDirector.getFechaAlta());
                    return directorRepository.save(director);
                })
                .orElseGet(() -> directorRepository.save(nuevosDatosDirector));

        return directorConverter.toDto(directorModificado);
    }

    public void deleteDirector(Long id){
        directorRepository.deleteById(id);
    }
}
