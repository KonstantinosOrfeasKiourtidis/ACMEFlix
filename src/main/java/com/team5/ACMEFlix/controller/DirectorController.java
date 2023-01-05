package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Director;
import com.team5.ACMEFlix.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/content/movie/director")
public class DirectorController {

    private final DirectorService directorService;
    @Autowired
    private DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public ResponseEntity<List<Director>> findAllDirectors(){
        return new ResponseEntity<>(directorService.findAllDirectors(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Director> findDirectorById(@PathVariable("id") Long id){
        return directorService.findDirectorById(id);
    }

    @GetMapping("findAllDirectorsByContentId/{id}")
    public ResponseEntity<List<Director>> findAllDirectorsByContentId(@PathVariable("id") Long id){
        return new ResponseEntity<>(directorService.findAllDirectorsByContentId(id), HttpStatus.OK);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addDirectorByContentId/{id}")
    public void addDirectorByContentId(@RequestBody Director director, @PathVariable("id") Long id){

        directorService.addDirectorByContentId(director, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addDirectorsByContentId/{id}")
    public void addDirectorsByContentId(@RequestBody Director[] directors, @PathVariable("id") Long id){

        directorService.addDirectosrByContentId(directors, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addDirectorByMovieId/{id}")
    public void addDirectorByMovieId(@RequestBody Director director, @PathVariable("id") Long id){

        directorService.addDirectorByMovieId(director, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addDirectorsByMovieId/{id}")
    public void addDirectorsByMovieId(@RequestBody Director[] directors, @PathVariable("id") Long id){

        directorService.addDirectorsByMovieId(directors, id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteDirectorById/{id}")
    public void deleteDirectorById(@PathVariable("id") Long id){
        directorService.deleteDirectorById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteDirectorsByIds/{ids}")
    public void deleteDirectorsByIds(@PathVariable("ids") Long[] ids){
        directorService.deleteDirectorsByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateDirectorById/{id}")
    public void updateDirectorById(
            @RequestBody Director director,
            @PathVariable("id") Long id
    ){
        directorService.updateDirectorById(director, id);
    }
}
