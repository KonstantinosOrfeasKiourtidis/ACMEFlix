package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.mapper.WatchedListMovieMapper;
import com.team5.ACMEFlix.service.WatchListMovieService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.WatchedListMovieResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/watchlist/watchListMovie")
public class WatchListMovieController {
    private final WatchListMovieService watchListMovieService;
    private final WatchedListMovieMapper watchedListMovieMapper;

    @Autowired
    private WatchListMovieController( WatchListMovieService watchListMovieService, WatchedListMovieMapper watchedListMovieMapper) {
        this.watchListMovieService = watchListMovieService;
        this.watchedListMovieMapper = watchedListMovieMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<WatchedListMovieResource>>> findAllWatchListMovies(){
        return  new ResponseEntity<>(ApiResponse.<List<WatchedListMovieResource>>builder().data(watchedListMovieMapper.toResources(watchListMovieService.findAllWatchListMovies())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<WatchedListMovieResource>> findWatchListMovieById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<WatchedListMovieResource>builder().data(watchedListMovieMapper.toResource(watchListMovieService.findWatchListMovieById(id).get())).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addWatchListMovie")
    public ResponseEntity<ApiResponse<WatchedListMovieResource>> addWatchListMovie(@Valid @RequestBody WatchedListMovieResource watchedListMovie){
        return new ResponseEntity<>(ApiResponse.<WatchedListMovieResource>builder().data(watchedListMovieMapper.toResource(watchListMovieService.addWatchListMovie(watchedListMovieMapper.toDomain(watchedListMovie)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addWatchListMovies")
    public ResponseEntity<ApiResponse<List<WatchedListMovieResource>>> addWatchListMovies(@Valid @RequestBody List<WatchedListMovieResource> watchedListMovies){

        return new ResponseEntity<>(ApiResponse.<List<WatchedListMovieResource>>builder().data(watchedListMovieMapper.toResources(watchListMovieService.addWatchListMovies(watchedListMovieMapper.toDomains(watchedListMovies)))).build(), HttpStatus.CREATED);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteWatchListMovieById/{id}")
    public void deleteWatchListMovieById(@PathVariable("id") Long id){
        watchListMovieService.deleteWatchListMovieById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteWatchListMoviesByIds/{ids}")
    public void deleteWatchListMoviesByIds(@PathVariable("ids") List<Long> ids){
        watchListMovieService.deleteWatchListMoviesByIds(ids);
    }


    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateWatchListMovieById/{id}")
    public void updateWatchListMovieByIdPatch(
            @PathVariable("id") Long id,
            @Valid @RequestBody WatchedListMovieResource watchedListMovie
    ){
        watchListMovieService.updateWatchListMovieByIdPatch(id, watchedListMovieMapper.toDomain(watchedListMovie));
    }
}
