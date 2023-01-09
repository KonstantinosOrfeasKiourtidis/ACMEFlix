package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WatchListMovieService {
    @Autowired
    private WatchListMovieRepository watchListMovieRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private AccountRepository accountRepository;
}
