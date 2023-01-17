package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.mapper.DirectorMapper;
import com.team5.ACMEFlix.service.DirectorService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.DirectorResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/content/movie/director")
public class DirectorController {

    private final DirectorService directorService;
    private final DirectorMapper directorMapper;

    @Autowired
    private DirectorController(DirectorService directorService, DirectorMapper directorMapper) {
        this.directorService = directorService;
        this.directorMapper = directorMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<DirectorResource>>> findAllDirectors(){
        return  new ResponseEntity<>(ApiResponse.<List<DirectorResource>>builder().data(directorMapper.toResources(directorService.findAllDirectors())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<DirectorResource>> findDirectorById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<DirectorResource>builder().data(directorMapper.toResource(directorService.findDirectorById(id).get())).build(), HttpStatus.OK);
    }

    @GetMapping("findAllDirectorsByContentId/{id}")
    public ResponseEntity<ApiResponse<List<DirectorResource>>> findAllDirectorsByContentId(@PathVariable("id") Long id){
        return  new ResponseEntity<>(ApiResponse.<List<DirectorResource>>builder().data(directorMapper.toResources(directorService.findAllDirectorsByContentId(id))).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addDirectorByContentId/{id}")
    public ResponseEntity<ApiResponse<DirectorResource>> addDirectorByContentId(@PathVariable("id") Long id, @Valid @RequestBody DirectorResource director){
        return new ResponseEntity<>(ApiResponse.<DirectorResource>builder().data(directorMapper.toResource(directorService.addDirectorByContentId(id, directorMapper.toDomain(director)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addDirectorsByContentId/{id}")
    public ResponseEntity<ApiResponse<List<DirectorResource>>> addDirectorsByContentId(@PathVariable("id") Long id, @Valid @RequestBody List<DirectorResource> directors){
        return  new ResponseEntity<>(ApiResponse.<List<DirectorResource>>builder().data(directorMapper.toResources(directorService.addDirectosrByContentId(id, directorMapper.toDomains(directors)))).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addDirectorByMovieId/{id}")
    public ResponseEntity<ApiResponse<DirectorResource>> addDirectorByMovieId(@PathVariable("id") Long id, @Valid @RequestBody DirectorResource director){
        return new ResponseEntity<>(ApiResponse.<DirectorResource>builder().data(directorMapper.toResource(directorService.addDirectorByMovieId(id, directorMapper.toDomain(director)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addDirectorsByMovieId/{id}")
    public ResponseEntity<ApiResponse<List<DirectorResource>>> addDirectorsByMovieId(@PathVariable("id") Long id, @Valid @RequestBody List<DirectorResource> directors){
        return  new ResponseEntity<>(ApiResponse.<List<DirectorResource>>builder().data(directorMapper.toResources(directorService.addDirectorsByMovieId(id, directorMapper.toDomains(directors)))).build(), HttpStatus.OK);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteDirectorById/{id}")
    public void deleteDirectorById(@PathVariable("id") Long id){
        directorService.deleteDirectorById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteDirectorsByIds/{ids}")
    public void deleteDirectorsByIds(@PathVariable("ids") List<Long> ids){
        directorService.deleteDirectorsByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateDirectorById/{id}")
    public void updateDirectorById(
            @PathVariable("id") Long id,
            @Valid @RequestBody DirectorResource director
    ){
        directorService.updateDirectorById(id, directorMapper.toDomain(director));
    }
}
