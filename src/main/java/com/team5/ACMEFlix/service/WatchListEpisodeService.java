package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.SubscriptionType;
import com.team5.ACMEFlix.helpers.SubscribeForm;
import com.team5.ACMEFlix.helpers.WatchEpisodeForm;
import com.team5.ACMEFlix.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class WatchListEpisodeService {
    @Autowired
    private WatchListEpisodeRepository watchListEpisodeRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private EpisodeRepository episodeRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public WatchedListEpisode watchEpisode(WatchEpisodeForm watchEpisodeForm) {





        Profile foundProfile = profileRepository.findById(watchEpisodeForm.getProfile_id()).orElseThrow(() -> new NoSuchElementException(
                "Profile does not exists"
        ));

        Episode foundEpisode = episodeRepository.findById(watchEpisodeForm.getEpisode_id()).orElseThrow(() -> new NoSuchElementException(
                "Episode does not exists"
        ));


        Account foundAccount = accountRepository.findById(foundProfile.getAccount().getId()).orElseThrow(() -> new NoSuchElementException(
                "Account does not exists"
        ));


        if(foundAccount.getSubscriptionType()==SubscriptionType.NO_SUBSCRIPTION){
            throw new IllegalStateException("The account does not have any valid plans in order for you to watch");
        }

        if(!(watchEpisodeForm.getTimeWatchedInSeconds() <= 0 || watchEpisodeForm.getTimeWatchedInSeconds()  > foundEpisode.getSeason().getTvSeries().getContent().getRuntime())){
            throw new IllegalStateException("The amount of time you are trying to watch from this episode is invalid");
        }



        Optional<WatchedListEpisode> watchedEpisodeFound = watchListEpisodeRepository.findWatchedListEpisodeByEpisodeIdAndProfileId(watchEpisodeForm.getEpisode_id(), watchEpisodeForm.getProfile_id());
        WatchedListEpisode watchedListEpisode = new WatchedListEpisode();

       if(!watchedEpisodeFound.isEmpty()){
            watchedListEpisode.setId(watchedEpisodeFound.get().getId());
            watchedListEpisode.setWatchedEpisodeDate(new Date());
            watchedListEpisode.setProfile(watchedEpisodeFound.get().getProfile());
            watchedListEpisode.setEpisode(watchedEpisodeFound.get().getEpisode());
            watchedListEpisode.setTimeWatchedInSeconds(watchEpisodeForm.getTimeWatchedInSeconds());

            watchedEpisodeFound.get().setTimeWatchedInSeconds(watchEpisodeForm.getTimeWatchedInSeconds());
       }
        else{

           watchedListEpisode.setWatchedEpisodeDate(new Date());
           watchedListEpisode.setProfile(foundProfile);
           watchedListEpisode.setEpisode(foundEpisode);
           watchedListEpisode.setTimeWatchedInSeconds(watchEpisodeForm.getTimeWatchedInSeconds());
           watchListEpisodeRepository.save(watchedListEpisode);

        }

        return watchedListEpisode;
    }

}
