package com.informatorio.cine.controller;

import com.informatorio.cine.dto.ObraDto;
import com.informatorio.cine.service.ObraService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/obra")
public class ObraController {

    @Autowired
    private ObraService obraService;

    @ApiOperation(value = "Obtener todas las obras")
    @ApiResponse(code = 200, message = "Obras obtenidas satisfactoriamente")
    @GetMapping()
    public ResponseEntity<List> getAllObras(){
        return new ResponseEntity<>(obraService.getAllObras(), HttpStatus.OK);
    }

    @ApiOperation(value = "Obtener una obra por su ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Obra obtenida satisfactoriamente"),
            @ApiResponse(code = 404, message = "Obra no encontrada")
    })
    @GetMapping("/buscar")
    public ResponseEntity<ObraDto> getObra(
            @RequestParam @ApiParam(name = "obra id", example = "1") Long id
    ){
        return new ResponseEntity<>(obraService.getObra(id), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ObraDto> postObra(@RequestBody ObraDto obraDto){
        return new ResponseEntity<>(obraService.postObra(obraDto), HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public ResponseEntity<ObraDto> putObra(@RequestParam Long id, @RequestBody ObraDto obraDto){
        return new ResponseEntity<>(obraService.putObra(id, obraDto), HttpStatus.OK);
    }

    @PutMapping("/agregar/{id}/actor")
    public ResponseEntity<ObraDto> putActorObra(@PathVariable ("id") Long idObra,@RequestParam Long idActor){
        return new ResponseEntity<>(obraService.putActorObra(idObra, idActor), HttpStatus.OK);
    }

    @PutMapping("/agregar/{id}/director")
    public ResponseEntity<ObraDto> putDirectorObra(@PathVariable ("id") Long idObra, @RequestParam Long idDirector){
        return new ResponseEntity<>(obraService.putDirectorObra(idObra, idDirector), HttpStatus.OK);
    }

    @PutMapping("/agregar/{id}/categoria")
    public ResponseEntity<ObraDto> putCategoriaObra(@PathVariable ("id") Long idObra, @RequestParam Long idCategoria){
        return new ResponseEntity<>(obraService.putCategoriaObra(idObra, idCategoria), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity deleteObra(@RequestParam Long id){
        obraService.deleteObra(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
