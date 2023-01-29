package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.WatchedListEpisode;
import com.team5.ACMEFlix.repository.WatchListEpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class WatchListEpisodeService {
    @Autowired
    private WatchListEpisodeRepository watchListEpisodeRepository;


    @Transactional(readOnly = true)
    public List<WatchedListEpisode> findAllWatchListEpisodes() {
        return watchListEpisodeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<WatchedListEpisode> findWatchListEpisodeById(Long id) {
        return watchListEpisodeRepository.findById(id);
    }

    @Transactional
    public WatchedListEpisode addWatchListEpisode(WatchedListEpisode watchedListEpisode) {
        watchListEpisodeRepository.save(watchedListEpisode);
        return watchedListEpisode;
    }

    @Transactional
    public List<WatchedListEpisode> addWatchListEpisodes(List<WatchedListEpisode> watchedListEpisodes) {
        for(WatchedListEpisode watchedListEpisode : watchedListEpisodes){

            watchListEpisodeRepository.save(watchedListEpisode);
        }
        return watchedListEpisodes;
    }

    @Transactional
    public void deleteWatchListEpisodeById(Long id) {
        boolean exists = watchListEpisodeRepository.existsById(id);
        if(!exists){
            throw new NoSuchElementException("Watch List Episode does not exist");
        }
        else{

            watchListEpisodeRepository.deleteById(id);
        }
    }

    @Transactional
    public void deleteWatchListEpisodesByIds(List<Long> ids) {
        for(Long id : ids){
            boolean exists = watchListEpisodeRepository.existsById(id);
            if(!exists){
                throw new NoSuchElementException("Watch List Episode does not exist");
            }
            else{

                watchListEpisodeRepository.deleteById(id);
            }
        }
    }


    @Transactional
    public void updateWatchListEpisodeByIdPatch(Long id, WatchedListEpisode watchedListEpisode) {
        WatchedListEpisode foundWatchedListEpisode = watchListEpisodeRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                "Watch List Episode does not exist"
        ));

        if(foundWatchedListEpisode.getTimeWatchedInMinutes() !=null && foundWatchedListEpisode.getTimeWatchedInMinutes()>0 &&
                !Objects.equals(foundWatchedListEpisode.getTimeWatchedInMinutes(), watchedListEpisode.getTimeWatchedInMinutes())){

            foundWatchedListEpisode.setTimeWatchedInMinutes(watchedListEpisode.getTimeWatchedInMinutes());
        }

        if(foundWatchedListEpisode.getEpisode().getId() !=null &&
                !Objects.equals(foundWatchedListEpisode.getEpisode().getId(), watchedListEpisode.getEpisode().getId())){

            foundWatchedListEpisode.getEpisode().setId(watchedListEpisode.getId());
        }

        if(foundWatchedListEpisode.getProfile().getId() !=null &&
                !Objects.equals(foundWatchedListEpisode.getProfile().getId(), watchedListEpisode.getProfile().getId())){

            foundWatchedListEpisode.getProfile().setId(watchedListEpisode.getId());
        }

        if(foundWatchedListEpisode.getContent().getId() !=null &&
                !Objects.equals(foundWatchedListEpisode.getContent().getId(), watchedListEpisode.getContent().getId())){

            foundWatchedListEpisode.getContent().setId(watchedListEpisode.getId());
        }

        foundWatchedListEpisode.setWatchedDate(new Date());

    }
}
