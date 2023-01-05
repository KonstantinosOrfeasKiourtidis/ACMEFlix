package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Episode;
import com.team5.ACMEFlix.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/content/tvseries/season/episode")
public class EpisodeController {

    private final EpisodeService episodeService;
    @Autowired
    private EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping
    public ResponseEntity<List<Episode>> findAllEpisodes(){
        return new ResponseEntity<>(episodeService.findAllEpisodes(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Episode> findEpisodeById(@PathVariable("id") Long id){
        return episodeService.findEpisodeById(id);
    }

    @GetMapping("findAllEpisodesByContentId/{id}")
    public ResponseEntity<List<Episode>> findAllEpisodesByContentId(@PathVariable("id") Long id){
        return new ResponseEntity<>(episodeService.findAllEpisodesByContentId(id), HttpStatus.OK);
    }

    @GetMapping("findAllEpisodesByTitle")
    public ResponseEntity<List<Episode>> findAllEpisodesByTitle(@Param("search") String search){
        return new ResponseEntity<>(episodeService.findAllEpisodesByTitle(search), HttpStatus.OK);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addEpisodeBySeasonId/{id}")
    public void addEpisodeBySeasonId(@RequestBody Episode episode, @PathVariable("id") Long id){



        episodeService.addEpisodeBySeasonId(episode, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addEpisodesBySeasonId/{id}")
    public void addEpisodesBySeasonId(@RequestBody Episode[] episodes, @PathVariable("id") Long id){



        episodeService.addEpisodesBySeasonId(episodes, id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteEpisodeById/{id}")
    public void deleteEpisodeById(@PathVariable("id") Long id){
        episodeService.deleteEpisodeById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteEpisodesByIds/{ids}")
    public void deleteEpisodesByIds(@PathVariable("ids") Long[] ids){
        episodeService.deleteEpisodesByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateEpisodeById/{id}")
    public void updateEpisodeById(
            @RequestBody Episode episode,
            @PathVariable("id") Long id
    ){
        episodeService.updateEpisodeById(episode, id);
    }
}
