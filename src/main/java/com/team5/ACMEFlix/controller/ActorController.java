package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Actor;
import com.team5.ACMEFlix.service.AccountService;
import com.team5.ACMEFlix.service.ActorService;
import com.team5.ACMEFlix.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/content/actor")
public class ActorController {

    private final ActorService actorService;
    @Autowired
    private ActorController(ActorService actorService) {
        this.actorService = actorService;
    }
    @GetMapping
    public ResponseEntity<List<Actor>> findAllActors(){
        return new ResponseEntity<>(actorService.findAllActors(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Actor> findActorById(@PathVariable("id") Long id){
        return actorService.findActorById(id);
    }

    @GetMapping("findAllActorsByContentId/{id}")
    public ResponseEntity<List<Actor>> findAllActorsByContentId(@PathVariable("id") Long id){
        return new ResponseEntity<>(actorService.findAllActorsByContentId(id), HttpStatus.OK);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addActorByContentId/{id}")
    public void addActorByContentId(@RequestBody Actor actor, @PathVariable("id") Long id){

        actorService.addActorByContentId(actor, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addActorsByContentId/{id}")
    public void addActorsByContentId(@RequestBody Actor[] actors, @PathVariable("id") Long id){

        actorService.addActorsByContentId(actors, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addActorByMovieId/{id}")
    public void addActorByMovieId(@RequestBody Actor actor, @PathVariable("id") Long id){

        actorService.addActorByMovieId(actor, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addActorsByMovieId/{id}")
    public void addActorsByMovieId(@RequestBody Actor[] actors, @PathVariable("id") Long id){

        actorService.addActorsByMovieId(actors, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addActorByTVSeriesId/{id}")
    public void addActorByTVSeriesId(@RequestBody Actor actor, @PathVariable("id") Long id){

        actorService.addActorByTVSeriesId(actor, id);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addActorsByTVSeriesId/{id}")
    public void addActorsByTVSeriesId(@RequestBody Actor[] actors, @PathVariable("id") Long id){

        actorService.addActorsByTVSeriesId(actors, id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteActorById/{id}")
    public void deleteActorById(@PathVariable("id") Long id){
        actorService.deleteActorById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteActorsByIds/{ids}")
    public void deleteActorsByIds(@PathVariable("ids") Long[] ids){
        actorService.deleteActorsByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateActorById/{id}")
    public void updateActorById(
            @RequestBody Actor actor,
            @PathVariable("id") Long id
    ){
        actorService.updateActorById(actor, id);
    }
}
