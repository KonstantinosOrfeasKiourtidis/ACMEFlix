package com.team5.ACMEFlix.controller;


import com.team5.ACMEFlix.mapper.GenreMapper;
import com.team5.ACMEFlix.service.GenreService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.GenreResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/content/genre")
public class GenreController {

    private final GenreService genreService;
    private final GenreMapper genreMapper;
    @Autowired
    private GenreController(GenreService genreService, GenreMapper genreMapper) {
        this.genreService = genreService;
        this.genreMapper = genreMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GenreResource>>> findAllGenres(){
        return  new ResponseEntity<>(ApiResponse.<List<GenreResource>>builder().data(genreMapper.toResources(genreService.findAllGenres())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<GenreResource>> findGenreById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<GenreResource>builder().data(genreMapper.toResource(genreService.findGenreById(id).get())).build(), HttpStatus.OK);
    }

    @GetMapping("findAllGenresByContentId/{id}")
    public ResponseEntity<ApiResponse<List<GenreResource>>> findAllGenresByContentId(@PathVariable("id") Long id){
        return  new ResponseEntity<>(ApiResponse.<List<GenreResource>>builder().data(genreMapper.toResources(genreService.findAllGenresByContentId(id))).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addGenreByContentId/{id}")
    public ResponseEntity<ApiResponse<GenreResource>> addGenreByContentId(@PathVariable("id") Long id, @Valid @RequestBody GenreResource genre){
        return new ResponseEntity<>(ApiResponse.<GenreResource>builder().data(genreMapper.toResource(genreService.addGenreByContentId(id, genreMapper.toDomain(genre)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addGenresByContentId/{id}")
    public ResponseEntity<ApiResponse<List<GenreResource>>> addGenresByContentId(@PathVariable("id") Long id, @Valid @RequestBody List<GenreResource> genres){
        return  new ResponseEntity<>(ApiResponse.<List<GenreResource>>builder().data(genreMapper.toResources(genreService.addGenresByContentId(id, genreMapper.toDomains(genres)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addGenreByMovieId/{id}")
    public ResponseEntity<ApiResponse<GenreResource>> addGenreByMovieId(@PathVariable("id") Long id, @Valid @RequestBody GenreResource genre){
        return new ResponseEntity<>(ApiResponse.<GenreResource>builder().data(genreMapper.toResource(genreService.addGenreByMovieId(id, genreMapper.toDomain(genre)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addGenresByMovieId/{id}")
    public ResponseEntity<ApiResponse<List<GenreResource>>> addGenresByMovieId(@PathVariable("id") Long id, @Valid @RequestBody List<GenreResource> genres){
        return  new ResponseEntity<>(ApiResponse.<List<GenreResource>>builder().data(genreMapper.toResources(genreService.addGenresByMovieId(id, genreMapper.toDomains(genres)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addGenreByTVSeriesId/{id}")
    public ResponseEntity<ApiResponse<GenreResource>> addGenreByTVSeriesId(@PathVariable("id") Long id, @Valid @RequestBody GenreResource genre){
        return new ResponseEntity<>(ApiResponse.<GenreResource>builder().data(genreMapper.toResource(genreService.addGenreByTVSeriesId(id, genreMapper.toDomain(genre)))).build(), HttpStatus.CREATED);
    }


    @PostMapping(path = "addGenresByTVSeriesId/{id}")
    public ResponseEntity<ApiResponse<List<GenreResource>>> addGenresByTVSeriesId(@PathVariable("id") Long id, @Valid @RequestBody List<GenreResource> genres){
        return  new ResponseEntity<>(ApiResponse.<List<GenreResource>>builder().data(genreMapper.toResources(genreService.addGenresByTVSeriesId(id, genreMapper.toDomains(genres)))).build(), HttpStatus.CREATED);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteGenreById/{id}")
    public void deleteGenreById(@PathVariable("id") Long id){
        genreService.deleteGenreById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteGenresByIds/{ids}")
    public void deleteGenresByIds(@PathVariable("ids") List<Long> ids){
        genreService.deleteGenresByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateGenreById/{id}")
    public void updateGenreById(
            @PathVariable("id") Long id,
            @Valid @RequestBody GenreResource genre
    ){
        genreService.updateGenreById(id, genreMapper.toDomain(genre));
    }
}
