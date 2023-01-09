package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.domain.TVSeries;
import com.team5.ACMEFlix.mapper.TVSeriesMapper;
import com.team5.ACMEFlix.service.GenreService;
import com.team5.ACMEFlix.service.TVSeriesService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.TVSeriesResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("findAllTVSeriesFamilyFriendly")
    public ResponseEntity<ApiResponse<List<TVSeriesResource>>> findAllTVSeriesFamilyFriendly(){
        return  new ResponseEntity<>(ApiResponse.<List<TVSeriesResource>>builder().data(tvSeriesMapper.toResources(tvSeriesService.findAllTVSeriesFamilyFriendly())).build(), HttpStatus.OK);
    }



    @GetMapping("findAllTVSeriesByTitle")
    public ResponseEntity<ApiResponse<List<TVSeriesResource>>> findAllTVSeriesByTitle(@Param("search") String search){
        return  new ResponseEntity<>(ApiResponse.<List<TVSeriesResource>>builder().data(tvSeriesMapper.toResources(tvSeriesService.findAllTVSeriesByTitle(search))).build(), HttpStatus.OK);
    }

    @GetMapping("findAllTVSeriesByCreators")
    public ResponseEntity<ApiResponse<List<TVSeriesResource>>> findAllTVSeriesByCreators(@Param("creator") String[] creator){
        return  new ResponseEntity<>(ApiResponse.<List<TVSeriesResource>>builder().data(tvSeriesMapper.toResources(tvSeriesService.getAllTVSeriesByCreators(creator))).build(), HttpStatus.OK);
    }

    @GetMapping("findAllTVSeriesByTVSeriesStatusType")
    public ResponseEntity<ApiResponse<List<TVSeriesResource>>> findAllTVSeriesByTVSeriesStatusType(@Param("status_type") String status_type){
        return  new ResponseEntity<>(ApiResponse.<List<TVSeriesResource>>builder().data(tvSeriesMapper.toResources(tvSeriesService.findAllTVSeriesByTVSeriesStatusType(status_type))).build(), HttpStatus.OK);
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
    @PatchMapping(path = "updateTVSeriesById/{id}")
    public void updateTVSeriesById(
            @PathVariable("id") Long id,
            @Valid @RequestBody TVSeriesResource tvSeries
    ){
        tvSeriesService.updateTVSeriesById(id, tvSeriesMapper.toDomain(tvSeries));
    }

}
