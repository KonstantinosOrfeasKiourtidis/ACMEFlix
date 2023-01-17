package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.mapper.EpisodeMapper;
import com.team5.ACMEFlix.service.EpisodeService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.EpisodeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/content/tvseries/season/episode")
public class EpisodeController {

    private final EpisodeService episodeService;
    private final EpisodeMapper episodeMapper;
    @Autowired
    private EpisodeController(EpisodeService episodeService, EpisodeMapper episodeMapper) {
        this.episodeService = episodeService;
        this.episodeMapper = episodeMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EpisodeResource>>> findAllEpisodes(){
        return  new ResponseEntity<>(ApiResponse.<List<EpisodeResource>>builder().data(episodeMapper.toResources(episodeService.findAllEpisodes())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<EpisodeResource>> findEpisodeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<EpisodeResource>builder().data(episodeMapper.toResource(episodeService.findEpisodeById(id).get())).build(), HttpStatus.OK);
    }

    @GetMapping("findAllEpisodesByContentId/{id}")
    public ResponseEntity<ApiResponse<List<EpisodeResource>>> findAllEpisodesByContentId(@PathVariable("id") Long id){
        return  new ResponseEntity<>(ApiResponse.<List<EpisodeResource>>builder().data(episodeMapper.toResources(episodeService.findAllEpisodesByContentId(id))).build(), HttpStatus.OK);
    }

    @GetMapping("findAllEpisodesByTitle")
    public ResponseEntity<ApiResponse<List<EpisodeResource>>> findAllEpisodesByTitle(@Param("search") String search){
        return  new ResponseEntity<>(ApiResponse.<List<EpisodeResource>>builder().data(episodeMapper.toResources(episodeService.findAllEpisodesByTitle(search))).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addEpisodeBySeasonId/{id}")
    public ResponseEntity<ApiResponse<EpisodeResource>> addEpisodeBySeasonId(@PathVariable("id") Long id, @Valid @RequestBody EpisodeResource episode){
        return new ResponseEntity<>(ApiResponse.<EpisodeResource>builder().data(episodeMapper.toResource(episodeService.addEpisodeBySeasonId(id, episodeMapper.toDomain(episode)))).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addEpisodesBySeasonId/{id}")
    public ResponseEntity<ApiResponse<List<EpisodeResource>>> addEpisodesBySeasonId(@PathVariable("id") Long id, @Valid @RequestBody List<EpisodeResource> episodes){
        return  new ResponseEntity<>(ApiResponse.<List<EpisodeResource>>builder().data(episodeMapper.toResources(episodeService.addEpisodesBySeasonId(id, episodeMapper.toDomains(episodes)))).build(), HttpStatus.CREATED);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteEpisodeById/{id}")
    public void deleteEpisodeById(@PathVariable("id") Long id){
        episodeService.deleteEpisodeById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteEpisodesByIds/{ids}")
    public void deleteEpisodesByIds(@PathVariable("ids") List<Long> ids){
        episodeService.deleteEpisodesByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateEpisodeById/{id}")
    public void updateEpisodeById(
            @PathVariable("id") Long id,
            @Valid @RequestBody EpisodeResource episode
    ){
        episodeService.updateEpisodeById(id, episodeMapper.toDomain(episode));
    }
}
