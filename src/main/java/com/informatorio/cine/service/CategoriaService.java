package com.informatorio.cine.service;

import com.informatorio.cine.converter.CategoriaConverter;
import com.informatorio.cine.dto.CategoriaDto;
import com.informatorio.cine.entity.Categoria;
import com.informatorio.cine.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaConverter categoriaConverter;

    public List<CategoriaDto> getAllCategorias(){
        return categoriaRepository
                .findAll()
                .stream()
                .map(categoria -> categoriaConverter.toDto(categoria))
                .collect(Collectors.toList());
    }

    public CategoriaDto getCategoria(Long id){
        return categoriaRepository
                .findById(id)
                .map(categoria -> categoriaConverter.toDto(categoria))
                .orElse(null);
    }

    public CategoriaDto postCategoria(CategoriaDto categoriaDto){
        Categoria categoria = categoriaRepository.save(categoriaConverter.toEntity(categoriaDto));
        return categoriaConverter.toDto(categoria);
    }

    public CategoriaDto putCategoria(Long id, CategoriaDto categoriaDto){
        Categoria nuevosDatosCategoria = categoriaConverter.toEntity(categoriaDto);
        Categoria categoriaModificada = categoriaRepository
                .findById(id)
                .map(categoria -> {
                    categoria.setNombre(nuevosDatosCategoria.getNombre());
                    return categoriaRepository.save(categoria);
                }).orElseGet(() -> categoriaRepository.save(nuevosDatosCategoria));

        return categoriaConverter.toDto(categoriaModificada);
    }

    public void deleteCategoria(Long id){
        categoriaRepository.deleteById(id);
    }
}
