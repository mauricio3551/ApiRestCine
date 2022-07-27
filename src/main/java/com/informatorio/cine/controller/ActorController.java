package com.informatorio.cine.controller;

import com.informatorio.cine.dto.ActorDto;
import com.informatorio.cine.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping()
    public ResponseEntity<List<ActorDto>> getAllActors(){
        return new ResponseEntity<>(actorService.getAllActors(), HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<ActorDto> getActor(@RequestParam Long id){
        return new ResponseEntity<>(actorService.getActor(id), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ActorDto> postActor(@RequestBody ActorDto actorDto){
        return new ResponseEntity<>(actorService.postActor(actorDto), HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public ResponseEntity<ActorDto> putActor(@RequestParam Long id, @RequestBody ActorDto actorDto){
        return new ResponseEntity<>(actorService.putActor(id, actorDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity deleteActor(@RequestParam Long id){
        actorService.deleteActor(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
