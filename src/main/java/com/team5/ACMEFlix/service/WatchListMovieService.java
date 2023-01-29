package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.repository.WatchListMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class WatchListMovieService {
    @Autowired
    private WatchListMovieRepository watchListMovieRepository;

    @Transactional(readOnly = true)
    public List<WatchedListMovie> findAllWatchListMovies() {
        return watchListMovieRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<WatchedListMovie> findWatchListMovieById(Long id) {
        return watchListMovieRepository.findById(id);
    }

    @Transactional
    public WatchedListMovie addWatchListMovie(WatchedListMovie watchedListMovie) {
        watchListMovieRepository.save(watchedListMovie);
        return watchedListMovie;
    }

    @Transactional
    public List<WatchedListMovie> addWatchListMovies(List<WatchedListMovie> watchedListMovies) {
        for(WatchedListMovie watchedListMovie : watchedListMovies){

            watchListMovieRepository.save(watchedListMovie);
        }
        return watchedListMovies;
    }

    @Transactional
    public void deleteWatchListMovieById(Long id) {
        boolean exists = watchListMovieRepository.existsById(id);
        if(!exists){
            throw new NoSuchElementException("Watch List Movie does not exist");
        }
        else{

            watchListMovieRepository.deleteById(id);
        }
    }

    @Transactional
    public void deleteWatchListMoviesByIds(List<Long> ids) {
        for(Long id : ids){
            boolean exists = watchListMovieRepository.existsById(id);
            if(!exists){
                throw new NoSuchElementException("Watch List Movie does not exist");
            }
            else{

                watchListMovieRepository.deleteById(id);
            }
        }
    }


    @Transactional
    public void updateWatchListMovieByIdPatch(Long id, WatchedListMovie watchedListMovie) {
        WatchedListMovie foundWatchedListMovie = watchListMovieRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                "Watch List Movie does not exist"
        ));

        if(foundWatchedListMovie.getTimeWatchedInMinutes() !=null && foundWatchedListMovie.getTimeWatchedInMinutes()>0 &&
                !Objects.equals(foundWatchedListMovie.getTimeWatchedInMinutes(), watchedListMovie.getTimeWatchedInMinutes())){

            foundWatchedListMovie.setTimeWatchedInMinutes(watchedListMovie.getTimeWatchedInMinutes());
        }

        if(foundWatchedListMovie.getMovie().getId() !=null &&
                !Objects.equals(foundWatchedListMovie.getMovie().getId(), watchedListMovie.getMovie().getId())){

            foundWatchedListMovie.getMovie().setId(watchedListMovie.getId());
        }

        if(foundWatchedListMovie.getProfile().getId() !=null &&
                !Objects.equals(foundWatchedListMovie.getProfile().getId(), watchedListMovie.getProfile().getId())){

            foundWatchedListMovie.getProfile().setId(watchedListMovie.getId());
        }

        if(foundWatchedListMovie.getContent().getId() !=null &&
                !Objects.equals(foundWatchedListMovie.getContent().getId(), watchedListMovie.getContent().getId())){

            foundWatchedListMovie.getContent().setId(watchedListMovie.getId());
        }

        foundWatchedListMovie.setWatchedDate(new Date());

    }
}
