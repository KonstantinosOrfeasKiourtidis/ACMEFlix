package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Genre;
import com.team5.ACMEFlix.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/content/genre")
public class GenreController {

    private final GenreService genreService;
    @Autowired
    private GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public ResponseEntity<List<Genre>> findAllGenres(){
        return new ResponseEntity<>(genreService.findAllGenres(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Genre> findGenreById(@PathVariable("id") Long id){
        return genreService.findGenreById(id);
    }

    @GetMapping("findAllGenresByContentId/{id}")
    public ResponseEntity<List<Genre>> findAllGenresByContentId(@PathVariable("id") Long id){
        return new ResponseEntity<>(genreService.findAllGenresByContentId(id), HttpStatus.OK);
    }

    @PostMapping(path = "addGenreByContentId/{id}")
    public void addGenreByContentId(@RequestBody Genre genre, @PathVariable("id") Long id){
        genreService.addGenreByContentId(genre, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addGenresByContentId/{id}")
    public void addGenresByContentId(@RequestBody Genre[] genres, @PathVariable("id") Long id){



        genreService.addGenresByContentId(genres, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addGenreByMovieId/{id}")
    public void addGenreByMovieId(@RequestBody Genre genre, @PathVariable("id") Long id){



        genreService.addGenreByMovieId(genre, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addGenresByMovieId/{id}")
    public void addGenresByMovieId(@RequestBody Genre[] genres, @PathVariable("id") Long id){



        genreService.addGenresByMovieId(genres, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addGenreByTVSeriesId/{id}")
    public void addGenreByTVSeriesId(@RequestBody Genre genre, @PathVariable("id") Long id){



        genreService.addGenreByTVSeriesId(genre, id);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addGenresByTVSeriesId/{id}")
    public void addGenresByTVSeriesId(@RequestBody Genre[] genres, @PathVariable("id") Long id){



        genreService.addGenresByTVSeriesId(genres, id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteGenreById/{id}")
    public void deleteGenreById(@PathVariable("id") Long id){
        genreService.deleteGenreById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteGenresByIds/{ids}")
    public void deleteGenresByIds(@PathVariable("ids") Long[] ids){
        genreService.deleteGenresByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateGenreById/{id}")
    public void updateGenreById(
            @RequestBody Genre genre,
            @PathVariable("id") Long id
    ){
        genreService.updateGenreById(genre, id);
    }
}
