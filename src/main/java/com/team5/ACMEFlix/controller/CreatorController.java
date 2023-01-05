package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Creator;
import com.team5.ACMEFlix.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/content/tvseries/creator")
public class CreatorController {

    private final CreatorService creatorService;
    @Autowired
    private CreatorController(CreatorService creatorService) {
        this.creatorService = creatorService;
    }

    @GetMapping
    public ResponseEntity<List<Creator>> findAllCreators(){
        return new ResponseEntity<>(creatorService.findAllCreators(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Creator> findCreatorById(@PathVariable("id") Long id){
        return creatorService.findCreatorById(id);
    }

    @GetMapping("findAllCreatorsByContentId/{id}")
    public ResponseEntity<List<Creator>>findAllCreatorsByContentId(@PathVariable("id") Long id){
        return new ResponseEntity<>(creatorService.findAllCreatorsByContentId(id), HttpStatus.OK);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addCreatorByContentId/{id}")
    public void addCreatorByContentId(@RequestBody Creator creator, @PathVariable("id") Long id){



        creatorService.addCreatorByContentId(creator, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addCreatorsByContentId/{id}")
    public void addCreatorsByContentId(@RequestBody Creator[] creators, @PathVariable("id") Long id){



        creatorService.addCreatorsByContentId(creators, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addCreatorByTVSeriesId/{id}")
    public void addCreatorByTVSeriesId(@RequestBody Creator creator, @PathVariable("id") Long id){



        creatorService.addCreatorByTVSeriesId(creator, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addCreatorsByTVSeriesId/{id}")
    public void addCreatorsByTVSeriesId(@RequestBody Creator[] creators, @PathVariable("id") Long id){



        creatorService.addCreatorsByTVSeriesId(creators, id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteCreatorById/{id}")
    public void deleteCreatorById(@PathVariable("id") Long id){
        creatorService.deleteCreatorById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteCreatorsByIds/{ids}")
    public void deleteCreatorsByIds(@PathVariable("ids") Long[] ids){
        creatorService.deleteCreatorsByIds(ids);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateCreatorById/{id}")
    public void updateCreatorById(
            @RequestBody Creator creator,
            @PathVariable("id") Long id
    ){
        creatorService.updateCreatorById(creator, id);
    }
}
