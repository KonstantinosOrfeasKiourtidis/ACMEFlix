package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.mapper.WatchedListEpisodeMapper;
import com.team5.ACMEFlix.service.WatchListEpisodeService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.WatchedListEpisodeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/watchlist/watchListEpisode")
public class WatchListEpisodeController {
    private final WatchListEpisodeService watchListEpisodeService;
    private final WatchedListEpisodeMapper watchedListEpisodeMapper;

    @Autowired
    private WatchListEpisodeController( WatchListEpisodeService watchListEpisodeService, WatchedListEpisodeMapper watchedListEpisodeMapper) {
        this.watchListEpisodeService = watchListEpisodeService;
        this.watchedListEpisodeMapper = watchedListEpisodeMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<WatchedListEpisodeResource>>> findAllWatchListEpisodes(){
        return  new ResponseEntity<>(ApiResponse.<List<WatchedListEpisodeResource>>builder().data(watchedListEpisodeMapper.toResources(watchListEpisodeService.findAllWatchListEpisodes())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<WatchedListEpisodeResource>> findWatchListEpisodeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<WatchedListEpisodeResource>builder().data(watchedListEpisodeMapper.toResource(watchListEpisodeService.findWatchListEpisodeById(id).get())).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addWatchListEpisode")
    public ResponseEntity<ApiResponse<WatchedListEpisodeResource>> addWatchListEpisode(@Valid @RequestBody WatchedListEpisodeResource watchedListEpisode){
        return new ResponseEntity<>(ApiResponse.<WatchedListEpisodeResource>builder().data(watchedListEpisodeMapper.toResource(watchListEpisodeService.addWatchListEpisode(watchedListEpisodeMapper.toDomain(watchedListEpisode)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addWatchListEpisodes")
    public ResponseEntity<ApiResponse<List<WatchedListEpisodeResource>>> addWatchListEpisodes(@Valid @RequestBody List<WatchedListEpisodeResource> watchedListEpisodes){

        return new ResponseEntity<>(ApiResponse.<List<WatchedListEpisodeResource>>builder().data(watchedListEpisodeMapper.toResources(watchListEpisodeService.addWatchListEpisodes(watchedListEpisodeMapper.toDomains(watchedListEpisodes)))).build(), HttpStatus.CREATED);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteWatchListEpisodeById/{id}")
    public void deleteWatchListEpisodeById(@PathVariable("id") Long id){
        watchListEpisodeService.deleteWatchListEpisodeById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteWatchListEpisodesByIds/{ids}")
    public void deleteWatchListEpisodesByIds(@PathVariable("ids") List<Long> ids){
        watchListEpisodeService.deleteWatchListEpisodesByIds(ids);
    }


    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateWatchListEpisodeById/{id}")
    public void updateWatchListEpisodeByIdPatch(
            @PathVariable("id") Long id,
            @Valid @RequestBody WatchedListEpisodeResource watchedListEpisode
    ){
        watchListEpisodeService.updateWatchListEpisodeByIdPatch(id, watchedListEpisodeMapper.toDomain(watchedListEpisode));
    }
}
