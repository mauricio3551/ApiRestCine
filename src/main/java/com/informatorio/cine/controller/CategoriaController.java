package com.informatorio.cine.controller;

import com.informatorio.cine.dto.CategoriaDto;
import com.informatorio.cine.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping()
    public ResponseEntity<List<CategoriaDto>> getAllCategoria(){
        return new ResponseEntity<>(categoriaService.getAllCategorias(), HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<CategoriaDto> getCategoria(@RequestParam Long id){
        return new ResponseEntity<>(categoriaService.getCategoria(id), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<CategoriaDto> postCategoria(@RequestBody CategoriaDto categoriaDto){
        return new ResponseEntity<>(categoriaService.postCategoria(categoriaDto), HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public ResponseEntity<CategoriaDto> putCategoria(@RequestParam Long id, @RequestBody CategoriaDto categoriaDto){
        return new ResponseEntity<>(categoriaService.putCategoria(id, categoriaDto), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity deleteCateria(@RequestParam Long id){
        categoriaService.deleteCategoria(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
