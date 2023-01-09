package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.domain.Movie;
import com.team5.ACMEFlix.mapper.MovieMapper;
import com.team5.ACMEFlix.service.MovieService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.MovieResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @GetMapping("findAllMoviesFamilyFriendly")
    public ResponseEntity<ApiResponse<List<MovieResource>>> findAllMoviesFamilyFriendly(){
        return  new ResponseEntity<>(ApiResponse.<List<MovieResource>>builder().data(movieMapper.toResources(movieService.findAllMoviesFamilyFriendly())).build(), HttpStatus.OK);
    }

    @GetMapping("findAllMoviesByTitle")
    public ResponseEntity<ApiResponse<List<MovieResource>>> findAllMoviesByTitle(@Param("search") String search){
        return  new ResponseEntity<>(ApiResponse.<List<MovieResource>>builder().data(movieMapper.toResources(movieService.findAllMoviesByTitle(search))).build(), HttpStatus.OK);
    }

    @GetMapping("findAllMoviesByDirectors")
    public ResponseEntity<ApiResponse<List<MovieResource>>> findAllMoviesByDirectors(@Param("director") String[] director){
        return  new ResponseEntity<>(ApiResponse.<List<MovieResource>>builder().data(movieMapper.toResources(movieService.findAllMoviesByDirectors(director))).build(), HttpStatus.OK);
    }

    @GetMapping("findAllMoviesByWriters")
    public ResponseEntity<ApiResponse<List<MovieResource>>> findAllMoviesByWriters(@Param("writer") String[] writer){
        return  new ResponseEntity<>(ApiResponse.<List<MovieResource>>builder().data(movieMapper.toResources(movieService.findAllMoviesByWriters(writer))).build(), HttpStatus.OK);
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
    @PatchMapping(path = "updateMovieById/{id}")
    public void updateMovieById(
            @PathVariable("id") Long id,
            @Valid @RequestBody MovieResource movie
    ){
        movieService.updateMovieById(id, movieMapper.toDomain(movie));
    }
}
