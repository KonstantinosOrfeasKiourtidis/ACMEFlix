package com.team5.ACMEFlix.controller;


import com.team5.ACMEFlix.mapper.TVSeriesMapper;
import com.team5.ACMEFlix.service.TVSeriesService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.TVSeriesResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/content/tvseries")
public class TVSeriesController {

    private final TVSeriesService tvSeriesService;
    private final TVSeriesMapper tvSeriesMapper;
    @Autowired
    private TVSeriesController(TVSeriesService tvSeriesService, TVSeriesMapper tvSeriesMapper) {
        this.tvSeriesService = tvSeriesService;
        this.tvSeriesMapper = tvSeriesMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TVSeriesResource>>> findAllTVSeries(){
        return  new ResponseEntity<>(ApiResponse.<List<TVSeriesResource>>builder().data(tvSeriesMapper.toResources(tvSeriesService.findAllTVSeries())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<TVSeriesResource>> findTVSeriesById(@PathVariable("id") Long id){
        return  new ResponseEntity<>(ApiResponse.<TVSeriesResource>builder().data(tvSeriesMapper.toResource(tvSeriesService.findTVSeriesById(id).get())).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addTVSerie")
    public ResponseEntity<ApiResponse<TVSeriesResource>> addTVSerie(@Valid @RequestBody TVSeriesResource tvSerie){
        return  new ResponseEntity<>(ApiResponse.<TVSeriesResource>builder().data(tvSeriesMapper.toResource(tvSeriesService.addTVSerie(tvSeriesMapper.toDomain(tvSerie)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addTVSeries")
    public ResponseEntity<ApiResponse<List<TVSeriesResource>>> addTVSeries(@Valid @RequestBody List<TVSeriesResource> tvSeries){
        return  new ResponseEntity<>(ApiResponse.<List<TVSeriesResource>>builder().data(tvSeriesMapper.toResources(tvSeriesService.addTVSeries(tvSeriesMapper.toDomains(tvSeries)))).build(), HttpStatus.CREATED);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteTVSeriesById/{id}")
    public void deleteTVSeriesById(@PathVariable("id") Long id){
        tvSeriesService.deleteTVSeriesById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteTVSeriesByIds/{ids}")
    public void deleteTVSeriesByIds(@PathVariable("ids") List<Long> ids){
        tvSeriesService.deleteTVSeriesByIds(ids);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateTVSeriesById/{id}")
    public void updateTVSeriesById(
            @PathVariable("id") Long id,
            @Valid @RequestBody TVSeriesResource tvSeries
    ){
        tvSeriesService.updateTVSeriesById(id, tvSeriesMapper.toDomain(tvSeries));
    }

}
