package com.team5.ACMEFlix.controller;


import com.team5.ACMEFlix.mapper.WatchedListMovieMapper;
import com.team5.ACMEFlix.service.WatchListMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/watchlist")
public class WatchListMovieController {

    private final WatchListMovieService watchListMovieService;
    private final WatchedListMovieMapper watchedListMovieMapper;

    @Autowired
    private WatchListMovieController( WatchListMovieService watchListMovieService, WatchedListMovieMapper watchedListMovieMapper) {
        this.watchListMovieService = watchListMovieService;
        this.watchedListMovieMapper = watchedListMovieMapper;
    }
}
