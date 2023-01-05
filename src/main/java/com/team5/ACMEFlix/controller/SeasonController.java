package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Season;
import com.team5.ACMEFlix.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/content/tvseries/season")
public class SeasonController {
    private final SeasonService seasonService;
    @Autowired
    private SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @GetMapping
    public ResponseEntity<List<Season>> findAllSeasons(){
        return new ResponseEntity<>(seasonService.findAllSeasons(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Season> findSeasonById(@PathVariable("id") Long id){
        return seasonService.findSeasonById(id);
    }

    @GetMapping("findAllSeasonsByContentId/{id}")
    public ResponseEntity<List<Season>> findAllSeasonsByContentId(@PathVariable("id") Long id){
        return new ResponseEntity<>(seasonService.findAllSeasonsByContentId(id), HttpStatus.OK);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addSeasonByTVSeriesId/{id}")
    public void addSeasonByTVSeriesId(@RequestBody Season season, @PathVariable("id") Long id){



        seasonService.addSeasonByTVSeriesId(season, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addSeasonsByTVSeriesId/{id}")
    public void addSeasonsByTVSeriesId(@RequestBody Season[] seasons, @PathVariable("id") Long id){



        seasonService.addSeasonsByTVSeriesId(seasons, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addSeasonByContentId/{id}")
    public void addSeasonByContentId(@RequestBody Season season, @PathVariable("id") Long id){



        seasonService.addSeasonByContentId(season, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addSeasonsByContentId/{id}")
    public void addSeasonsByContentId(@RequestBody Season[] seasons, @PathVariable("id") Long id){



        seasonService.addSeasonsByContentId(seasons, id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteSeasonById/{id}")
    public void deleteSeasonById(@PathVariable("id") Long id){
        seasonService.deleteSeasonById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteSeasonsByIds/{ids}")
    public void deleteSeasonsByIds(@PathVariable("ids") Long[] ids){
        seasonService.deleteSeasonsByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateSeasonById/{id}")
    public void updateSeasonById(
            @RequestBody Season season,
            @PathVariable("id") Long id
    ){
        seasonService.updateSeasonById(season, id);
    }
}
