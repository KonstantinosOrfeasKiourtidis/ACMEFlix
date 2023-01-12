package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.helpers.WatchEpisodeForm;
import com.team5.ACMEFlix.helpers.WatchMovieForm;
import com.team5.ACMEFlix.mapper.*;
import com.team5.ACMEFlix.service.MovieService;
import com.team5.ACMEFlix.service.TVSeriesService;
import com.team5.ACMEFlix.service.ViewService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/watchlist")
public class ViewController {

    private final ViewService viewService;
    private final ViewMapper viewMapper;
    private final ContentMapper contentMapper;
    private final MovieMapper movieMapper;
    private final TVSeriesMapper tvSeriesMapper;
    private final MovieService movieService;
    private final TVSeriesService tvSeriesService;

    @Autowired
    private ViewController( ViewService viewService, ViewMapper viewMapper,
                            ContentMapper contentMapper, MovieMapper movieMapper, TVSeriesMapper tvSeriesMapper,  MovieService movieService, TVSeriesService tvSeriesService) {
        this.viewService = viewService;
        this.viewMapper = viewMapper;
        this.contentMapper = contentMapper;
        this.movieMapper = movieMapper;
        this.tvSeriesMapper = tvSeriesMapper;
        this.movieService = movieService;
        this.tvSeriesService = tvSeriesService;
    }

    @GetMapping("findTop10MostViewedContents")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findTop10MostViewedContent(){

        List<ContentResource> contentResources = contentMapper.domainToResources(viewService.findTop10MostViewedContent());

        List<ContentResource> contentResourcesReturn = new ArrayList<>();
        for(ContentResource content: contentResources){
            if(content.getContentType().equals(ContentType.MOVIE)){
                contentResources.add(contentMapper.movieToContentResource(movieService.findMovieByContentId(content.getId()).get()));
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                contentResources.add(contentMapper.tvSerieToContentResource(tvSeriesService.findTVSeriesByContentId(content.getId()).get()));
            }
        }

        return new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentResourcesReturn).build(), HttpStatus.OK);
    }

    @GetMapping("findTop5MostPopularGenres")
    public ResponseEntity<ApiResponse<List<String>>> findTop5MostPopularGenres(){
        return new ResponseEntity<>(ApiResponse.<List<String>>builder().data(viewService.findTop5MostPopularGenres()).build(), HttpStatus.OK);
    }

    @GetMapping("findViewingHoursByAccountId/{id}")
    public ResponseEntity<ApiResponse<AccountResourceViewingHours>> findViewingHoursByAccountId(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<AccountResourceViewingHours>builder().data(viewService.findViewingHoursByAccountId(id)).build(), HttpStatus.OK);
    }

    @PostMapping(path = "watchEpisode")
    public ResponseEntity<ApiResponse<ViewResource>> watchEpisode(@Valid @RequestBody WatchEpisodeForm watchEpisodeForm){
        return new ResponseEntity<>(ApiResponse.<ViewResource>builder().data(viewMapper.toResource(viewService.watchEpisode(watchEpisodeForm.getProfile_id(), watchEpisodeForm.getEpisode_id(), watchEpisodeForm.getTimeWatchedInMinutes()))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "watchMovie")
    public ResponseEntity<ApiResponse<ViewResource>> watchMovie(@Valid @RequestBody WatchMovieForm watchMovieForm){
        return new ResponseEntity<>(ApiResponse.<ViewResource>builder().data(viewMapper.toResource(viewService.watchMovie(watchMovieForm.getProfile_id(), watchMovieForm.getMovie_id(), watchMovieForm.getTimeWatchedInMinutes()))).build(), HttpStatus.CREATED);
    }
}
