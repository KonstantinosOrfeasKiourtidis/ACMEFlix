package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Movie;
import com.team5.ACMEFlix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/content/movie")
public class MovieController {

    private final MovieService movieService;
    @Autowired
    private MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping
    public ResponseEntity<List<Movie>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable("id") Long id){
        return movieService.findMovieById(id);
    }

    @GetMapping("findAllMoviesFamilyFriendly")
    public ResponseEntity<List<Movie>> findAllMoviesFamilyFriendly(){
        return new ResponseEntity<>(movieService.findAllMoviesFamilyFriendly(), HttpStatus.OK);
    }

    @GetMapping("findAllMoviesByTitle")
    public ResponseEntity<List<Movie>> findAllMoviesByTitle(@Param("search") String search){
        return new ResponseEntity<>(movieService.findAllMoviesByTitle(search), HttpStatus.OK);
    }

    @GetMapping("findAllMoviesByDirectors")
    public ResponseEntity<List<Movie>> findAllMoviesByDirectors(@Param("director") String[] director){
        return new ResponseEntity<>(movieService.findAllMoviesByDirectors(director), HttpStatus.OK);
    }

    @GetMapping("findAllMoviesByWriters")
    public ResponseEntity<List<Movie>> findAllMoviesByWriters(@Param("writer") String[] writer){
        return new ResponseEntity<>(movieService.findAllMoviesByWriters(writer), HttpStatus.OK);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addMovie")
    public void addMovie(@RequestBody Movie movie){

        movieService.addMovie(movie);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addMovies")
    public void addMovies(@RequestBody Movie... movies){

        movieService.addMovies(movies);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateMovieById/{id}")
    public void updateMovieById(
            @RequestBody Movie movie,
            @PathVariable("id") Long id
    ){
        movieService.updateMovieById(movie, id);
    }
}
