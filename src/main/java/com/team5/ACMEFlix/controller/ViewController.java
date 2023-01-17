package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.View;
import com.team5.ACMEFlix.forms.WatchEpisodeForm;
import com.team5.ACMEFlix.forms.WatchMovieForm;
import com.team5.ACMEFlix.mapper.*;
import com.team5.ACMEFlix.service.ViewService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
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

    @GetMapping("findViewingHoursByAccountId/{id}")
    public ResponseEntity<ApiResponse<AccountResourceViewingHours>> findViewingHoursByAccountId(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<AccountResourceViewingHours>builder().data(viewService.findViewingHoursByAccountId(id)).build(), HttpStatus.OK);
    }

    @GetMapping("findAllViewingHistory")
    public ResponseEntity<ApiResponse<List<AccountResourceViewingHistory>>> findAllViewingHistory() throws SQLException {
        return new ResponseEntity<>(ApiResponse.<List<AccountResourceViewingHistory>>builder().data(viewService.findAllViewingHistory()).build(), HttpStatus.OK);
    }

    @PostMapping(path = "watchEpisode")
    public ResponseEntity<ApiResponse<ViewResource>> watchEpisode(@Valid @RequestBody WatchEpisodeForm watchEpisodeForm){
        return new ResponseEntity<>(ApiResponse.<ViewResource>builder().data(viewMapper.toResource(viewService.watchEpisode(watchEpisodeForm))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "watchMovie")
    public ResponseEntity<ApiResponse<View>> watchMovie(@Valid @RequestBody WatchMovieForm watchMovieForm){
        return new ResponseEntity<>(ApiResponse.<View>builder().data(viewService.watchMovie(watchMovieForm)).build(), HttpStatus.CREATED);
    }
}
