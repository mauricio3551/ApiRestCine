package com.informatorio.cine.controller;

import com.informatorio.cine.dto.DirectorDto;
import com.informatorio.cine.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/director")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping()
    public ResponseEntity<List<DirectorDto>> getAllDirectors(){
        return new ResponseEntity<>(directorService.getAllDirectors(), HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<DirectorDto> getDirector(@RequestParam Long id){
        return new ResponseEntity<>(directorService.getDirector(id), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<DirectorDto> postDirector(@RequestBody DirectorDto directorDto){
        return new ResponseEntity<>(directorService.postDirector(directorDto), HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public ResponseEntity<DirectorDto> putDirector(@RequestParam Long id, @RequestBody DirectorDto directorDto){
        return new ResponseEntity<>(directorService.putDirector(id, directorDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity deleteDirector(@RequestParam Long id){
        directorService.deleteDirector(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
