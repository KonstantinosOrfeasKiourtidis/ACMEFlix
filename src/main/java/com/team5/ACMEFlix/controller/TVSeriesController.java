package com.team5.ACMEFlix.controller;


import com.team5.ACMEFlix.mapper.ContentMapper;
import com.team5.ACMEFlix.mapper.TVSeriesMapper;
import com.team5.ACMEFlix.service.TVSeriesService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.ContentResource;
import com.team5.ACMEFlix.transfer.resource.TVSeriesResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    private final ContentMapper contentMapper;
    @Autowired
    private TVSeriesController(TVSeriesService tvSeriesService, TVSeriesMapper tvSeriesMapper, ContentMapper contentMapper) {
        this.tvSeriesService = tvSeriesService;
        this.tvSeriesMapper = tvSeriesMapper;
        this.contentMapper = contentMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllTVSeries(){
        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentMapper.tvSeriesToContentResources(tvSeriesService.findAllTVSeries())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<ContentResource>> findTVSeriesById(@PathVariable("id") Long id){
        return  new ResponseEntity<>(ApiResponse.<ContentResource>builder().data(contentMapper.tvSerieToContentResource(tvSeriesService.findTVSeriesById(id).get())).build(), HttpStatus.OK);
    }

    @GetMapping("findAllTVSeriesFamilyFriendly")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllTVSeriesFamilyFriendly(){
        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentMapper.tvSeriesToContentResources(tvSeriesService.findAllTVSeriesFamilyFriendly())).build(), HttpStatus.OK);
    }



    @GetMapping("findAllTVSeriesByTitle")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllTVSeriesByTitle(@Param("search") String search){
        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentMapper.tvSeriesToContentResources(tvSeriesService.findAllTVSeriesByTitle(search))).build(), HttpStatus.OK);
    }

    @GetMapping("findAllTVSeriesByCreators")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllTVSeriesByCreators(@Param("creator") String[] creator){
        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentMapper.tvSeriesToContentResources(tvSeriesService.getAllTVSeriesByCreators(creator))).build(), HttpStatus.OK);
    }

    @GetMapping("findAllTVSeriesByTVSeriesStatusType")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllTVSeriesByTVSeriesStatusType(@Param("status_type") String status_type){
        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentMapper.tvSeriesToContentResources(tvSeriesService.findAllTVSeriesByTVSeriesStatusType(status_type))).build(), HttpStatus.OK);
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
