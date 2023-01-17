package com.team5.ACMEFlix.controller;


import com.team5.ACMEFlix.mapper.SeasonMapper;
import com.team5.ACMEFlix.service.SeasonService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.SeasonResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/content/tvseries/season")
public class SeasonController {
    private final SeasonService seasonService;
    private final SeasonMapper seasonMapper;
    @Autowired
    private SeasonController(SeasonService seasonService, SeasonMapper seasonMapper) {
        this.seasonService = seasonService;
        this.seasonMapper = seasonMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SeasonResource>>> findAllSeasons(){
        return  new ResponseEntity<>(ApiResponse.<List<SeasonResource>>builder().data(seasonMapper.toResources(seasonService.findAllSeasons())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<SeasonResource>> findSeasonById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<SeasonResource>builder().data(seasonMapper.toResource(seasonService.findSeasonById(id).get())).build(), HttpStatus.OK);
    }

    @GetMapping("findAllSeasonsByContentId/{id}")
    public ResponseEntity<ApiResponse<List<SeasonResource>>> findAllSeasonsByContentId(@PathVariable("id") Long id){
        return  new ResponseEntity<>(ApiResponse.<List<SeasonResource>>builder().data(seasonMapper.toResources(seasonService.findAllSeasonsByContentId(id))).build(), HttpStatus.OK);

    }

    @PostMapping(path = "addSeasonByTVSeriesId/{id}")
    public ResponseEntity<ApiResponse<SeasonResource>> addSeasonByTVSeriesId(@PathVariable("id") Long id, @Valid @RequestBody SeasonResource season){
        return new ResponseEntity<>(ApiResponse.<SeasonResource>builder().data(seasonMapper.toResource(seasonService.addSeasonByTVSeriesId(id, seasonMapper.toDomain(season)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addSeasonsByTVSeriesId/{id}")
    public ResponseEntity<ApiResponse<List<SeasonResource>>> addSeasonsByTVSeriesId(@PathVariable("id") Long id, @Valid @RequestBody List<SeasonResource> seasons){
        return  new ResponseEntity<>(ApiResponse.<List<SeasonResource>>builder().data(seasonMapper.toResources(seasonService.addSeasonsByTVSeriesId(id, seasonMapper.toDomains(seasons)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addSeasonByContentId/{id}")
    public ResponseEntity<ApiResponse<SeasonResource>> addSeasonByContentId(@PathVariable("id") Long id, @Valid @RequestBody SeasonResource season){
        return new ResponseEntity<>(ApiResponse.<SeasonResource>builder().data(seasonMapper.toResource(seasonService.addSeasonByContentId(id, seasonMapper.toDomain(season)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addSeasonsByContentId/{id}")
    public ResponseEntity<ApiResponse<List<SeasonResource>>> addSeasonsByContentId(@PathVariable("id") Long id, @Valid @RequestBody List<SeasonResource> seasons){
        return  new ResponseEntity<>(ApiResponse.<List<SeasonResource>>builder().data(seasonMapper.toResources(seasonService.addSeasonsByContentId(id, seasonMapper.toDomains(seasons)))).build(), HttpStatus.CREATED);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteSeasonById/{id}")
    public void deleteSeasonById(@PathVariable("id") Long id){
        seasonService.deleteSeasonById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteSeasonsByIds/{ids}")
    public void deleteSeasonsByIds(@PathVariable("ids") List<Long> ids){
        seasonService.deleteSeasonsByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateSeasonById/{id}")
    public void updateSeasonById(
            @PathVariable("id") Long id,
            @Valid @RequestBody SeasonResource season
    ){
        seasonService.updateSeasonById(id, seasonMapper.toDomain(season));
    }
}
