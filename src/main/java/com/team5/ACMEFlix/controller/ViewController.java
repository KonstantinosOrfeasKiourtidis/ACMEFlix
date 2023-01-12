package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.helpers.WatchEpisodeForm;
import com.team5.ACMEFlix.helpers.WatchMovieForm;
import com.team5.ACMEFlix.mapper.GenreMapper;
import com.team5.ACMEFlix.mapper.ViewMapper;
import com.team5.ACMEFlix.service.ViewService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.ContentResource;
import com.team5.ACMEFlix.transfer.resource.ViewResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/watchlist")
public class ViewController {

    private final ViewService viewService;
    private final ViewMapper viewMapper;

    @Autowired
    private ViewController( ViewService viewService, ViewMapper viewMapper) {
        this.viewService = viewService;
        this.viewMapper = viewMapper;
    }

    @GetMapping("findTop10MostViewedContents")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findTop10MostViewedContent(){
        return new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(viewService.findTop10MostViewedContent()).build(), HttpStatus.OK);
    }

    @GetMapping("findTop5MostPopularGenres")
    public ResponseEntity<ApiResponse<List<String>>> findTop5MostPopularGenres(){
        return new ResponseEntity<>(ApiResponse.<List<String>>builder().data(viewService.findTop5MostPopularGenres()).build(), HttpStatus.OK);
    }

    @PostMapping(path = "watchEpisode")
    public ResponseEntity<ApiResponse<ViewResource>> watchEpisode(@Valid @RequestBody WatchEpisodeForm watchEpisodeForm){
        return new ResponseEntity<>(ApiResponse.<ViewResource>builder().data(viewMapper.toResource(viewService.watchEpisode(watchEpisodeForm))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "watchMovie")
    public ResponseEntity<ApiResponse<ViewResource>> watchMovie(@Valid @RequestBody WatchMovieForm watchMovieForm){
        return new ResponseEntity<>(ApiResponse.<ViewResource>builder().data(viewMapper.toResource(viewService.watchMovie(watchMovieForm))).build(), HttpStatus.CREATED);
    }
}
