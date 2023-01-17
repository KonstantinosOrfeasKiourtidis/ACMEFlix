package com.team5.ACMEFlix.controller;


import com.team5.ACMEFlix.mapper.ActorMapper;
import com.team5.ACMEFlix.service.ActorService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.ActorResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/content/actor")
public class ActorController {

    private final ActorService actorService;
    private final ActorMapper actorMapper;

    @Autowired
    private ActorController(ActorService actorService, ActorMapper actorMapper) {
        this.actorService = actorService;
        this.actorMapper = actorMapper;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<ActorResource>>> findAllActors(){
        return  new ResponseEntity<>(ApiResponse.<List<ActorResource>>builder().data(actorMapper.toResources(actorService.findAllActors())).build(), HttpStatus.OK);

    }
    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<ActorResource>> findActorById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<ActorResource>builder().data(actorMapper.toResource(actorService.findActorById(id).get())).build(), HttpStatus.OK);
    }

    @GetMapping("findAllActorsByContentId/{id}")
    public ResponseEntity<ApiResponse<List<ActorResource>>> findAllActorsByContentId(@PathVariable("id") Long id){
        return  new ResponseEntity<>(ApiResponse.<List<ActorResource>>builder().data(actorMapper.toResources(actorService.findAllActorsByContentId(id))).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addActorByContentId/{id}")
    public ResponseEntity<ApiResponse<ActorResource>> addActorByContentId(@PathVariable("id") Long id, @Valid @RequestBody ActorResource actor){
        return new ResponseEntity<>(ApiResponse.<ActorResource>builder().data(actorMapper.toResource(actorService.addActorByContentId(id, actorMapper.toDomain(actor)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addActorsByContentId/{id}")
    public ResponseEntity<ApiResponse<List<ActorResource>>> addActorsByContentId(@PathVariable("id") Long id, @Valid @RequestBody List<ActorResource> actors){
        return  new ResponseEntity<>(ApiResponse.<List<ActorResource>>builder().data(actorMapper.toResources(actorService.addActorsByContentId(id, actorMapper.toDomains(actors)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addActorByMovieId/{id}")
    public ResponseEntity<ApiResponse<ActorResource>> addActorByMovieId(@PathVariable("id") Long id, @Valid @RequestBody ActorResource actor){
        return new ResponseEntity<>(ApiResponse.<ActorResource>builder().data(actorMapper.toResource(actorService.addActorByMovieId(id, actorMapper.toDomain(actor)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addActorsByMovieId/{id}")
    public ResponseEntity<ApiResponse<List<ActorResource>>> addActorsByMovieId(@PathVariable("id") Long id, @Valid @RequestBody List<ActorResource> actors){
        return  new ResponseEntity<>(ApiResponse.<List<ActorResource>>builder().data(actorMapper.toResources(actorService.addActorsByMovieId(id, actorMapper.toDomains(actors)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addActorByTVSeriesId/{id}")
    public ResponseEntity<ApiResponse<ActorResource>> addActorByTVSeriesId(@PathVariable("id") Long id, @Valid @RequestBody ActorResource actor){
        return new ResponseEntity<>(ApiResponse.<ActorResource>builder().data(actorMapper.toResource(actorService.addActorByTVSeriesId(id, actorMapper.toDomain(actor)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addActorsByTVSeriesId/{id}")
    public ResponseEntity<ApiResponse<List<ActorResource>>> addActorsByTVSeriesId(@PathVariable("id") Long id, @Valid @RequestBody List<ActorResource> actors){
        return  new ResponseEntity<>(ApiResponse.<List<ActorResource>>builder().data(actorMapper.toResources(actorService.addActorsByTVSeriesId(id, actorMapper.toDomains(actors)))).build(), HttpStatus.CREATED);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteActorById/{id}")
    public void deleteActorById(@PathVariable("id") Long id){
        actorService.deleteActorById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteActorsByIds/{ids}")
    public void deleteActorsByIds(@PathVariable("ids") List<Long> ids){
        actorService.deleteActorsByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateActorById/{id}")
    public void updateActorById(
            @PathVariable("id") Long id,
            @Valid @RequestBody ActorResource actor
    ){
        actorService.updateActorById(id, actorMapper.toDomain(actor));
    }
}
