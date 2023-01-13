package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.helpers.WatchEpisodeForm;
import com.team5.ACMEFlix.mapper.WatchedListEpisodeMapper;
import com.team5.ACMEFlix.service.WatchListEpisodeService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.AccountResource;
import com.team5.ACMEFlix.transfer.resource.WatchedListEpisodeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/watchlist")
public class WatchListEpisodeController {

    private final WatchListEpisodeService watchListEpisodeService;
    private final WatchedListEpisodeMapper watchedListEpisodeMapper;

    @Autowired
    private WatchListEpisodeController( WatchListEpisodeService watchListEpisodeService, WatchedListEpisodeMapper watchedListEpisodeMapper) {
        this.watchListEpisodeService = watchListEpisodeService;
        this.watchedListEpisodeMapper = watchedListEpisodeMapper;
    }

    @PostMapping(path = "watchEpisode")
    public ResponseEntity<ApiResponse<WatchedListEpisodeResource>> watchEpisode(@Valid @RequestBody WatchEpisodeForm watchEpisodeForm){
        return new ResponseEntity<>(ApiResponse.<WatchedListEpisodeResource>builder().data(watchedListEpisodeMapper.toResource(watchListEpisodeService.watchEpisode(watchEpisodeForm))).build(), HttpStatus.CREATED);
    }

}
