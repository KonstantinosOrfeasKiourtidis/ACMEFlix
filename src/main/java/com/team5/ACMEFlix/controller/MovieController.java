package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.mapper.MovieMapper;
import com.team5.ACMEFlix.service.MovieService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.MovieResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/content/movie")
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;
    @Autowired
    private MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<MovieResource>>> findAllMovies(){
        return  new ResponseEntity<>(ApiResponse.<List<MovieResource>>builder().data(movieMapper.toResources(movieService.findAllMovies())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<MovieResource>> findMovieById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<MovieResource>builder().data(movieMapper.toResource(movieService.findMovieById(id).get())).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addMovie")
    public ResponseEntity<ApiResponse<MovieResource>> addMovie(@Valid @RequestBody MovieResource movie){
        return new ResponseEntity<>(ApiResponse.<MovieResource>builder().data(movieMapper.toResource(movieService.addMovie(movieMapper.toDomain(movie)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addMovies")
    public ResponseEntity<ApiResponse<List<MovieResource>>> addMovies(@Valid @RequestBody List<MovieResource> movies){
        return  new ResponseEntity<>(ApiResponse.<List<MovieResource>>builder().data(movieMapper.toResources(movieService.addMovies(movieMapper.toDomains(movies)))).build(), HttpStatus.CREATED);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteMovieById/{id}")
    public void deleteMovieById(@PathVariable("id") Long id){
        movieService.deleteMovieById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteMoviesByIds/{ids}")
    public void deleteMoviesByIds(@PathVariable("ids") List<Long> ids){
        movieService.deleteMoviesByIds(ids);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateMovieById/{id}")
    public void updateMovieById(
            @PathVariable("id") Long id,
            @Valid @RequestBody MovieResource movie
    ){
        movieService.updateMovieById(id, movieMapper.toDomain(movie));
    }
}
