package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.TVSeries;
import com.team5.ACMEFlix.service.GenreService;
import com.team5.ACMEFlix.service.TVSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/content/tvseries")
public class TVSeriesController {

    private final TVSeriesService tvSeriesService;
    @Autowired
    private TVSeriesController(TVSeriesService tvSeriesService) {
        this.tvSeriesService = tvSeriesService;
    }

    @GetMapping
    public ResponseEntity<List<TVSeries>> findAllTVSeries(){
        return new ResponseEntity<>(tvSeriesService.findAllTVSeries(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TVSeries> findTVSeriesById(@PathVariable("id") Long id){
        return tvSeriesService.findTVSeriesById(id);
    }

    @GetMapping("findAllTVSeriesFamilyFriendly")
    public ResponseEntity<List<TVSeries>> findAllTVSeriesFamilyFriendly(){
        return new ResponseEntity<>(tvSeriesService.findAllTVSeriesFamilyFriendly(), HttpStatus.OK);
    }



    @GetMapping("findAllTVSeriesByTitle")
    public ResponseEntity<List<TVSeries>> findAllTVSeriesByTitle(@Param("search") String search){
        return new ResponseEntity<>(tvSeriesService.findAllTVSeriesByTitle(search), HttpStatus.OK);
    }

    @GetMapping("findAllTVSeriesByCreators")
    public ResponseEntity<List<TVSeries>> findAllTVSeriesByCreators(@Param("creator") String[] creator){
        return new ResponseEntity<>(tvSeriesService.getAllTVSeriesByCreators(creator), HttpStatus.OK);
    }

    @GetMapping("findAllTVSeriesByTVSeriesStatusType")
    public ResponseEntity<List<TVSeries>> findAllTVSeriesByTVSeriesStatusType(@Param("status_type") String status_type){
        return new ResponseEntity<>(tvSeriesService.findAllTVSeriesByTVSeriesStatusType(status_type), HttpStatus.OK);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addTVSerie")
    public void addTVSerie(@RequestBody TVSeries tvSerie){

        tvSeriesService.addTVSerie(tvSerie);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addTVSeries")
    public void addTVSeries(@RequestBody TVSeries... tvSeries){

        tvSeriesService.addTVSeries(tvSeries);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateTVSeriesById/{id}")
    public void updateTVSeriesById(
            @RequestBody TVSeries tvSeries,
            @PathVariable("id") Long id
    ){
        tvSeriesService.updateTVSeriesById(tvSeries, id);
    }

}
