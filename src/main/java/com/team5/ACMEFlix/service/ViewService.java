package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.domain.enumeration.SubscriptionType;
import com.team5.ACMEFlix.helpers.WatchEpisodeForm;
import com.team5.ACMEFlix.helpers.WatchMovieForm;
import com.team5.ACMEFlix.mapper.ContentMapper;
import com.team5.ACMEFlix.repository.*;
import com.team5.ACMEFlix.transfer.resource.ContentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ViewService {
    @Autowired
    private WatchListEpisodeRepository watchListEpisodeRepository;
    @Autowired
    private ViewRepository viewRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private EpisodeRepository episodeRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TVSeriesRepository tVSeriesRepository;
    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private WatchListEpisodeRepository watchedListEpisodeRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private WatchListMovieRepository watchListMovieRepository;
    @Autowired
    private ContentRepository contentRepository;

    @Transactional(readOnly = true)
    public List<ContentResource> findTop10MostViewedContent() {
        List<Long> contentIds= viewRepository.findTop10MostViewedContent();
        List<Content> contents = contentRepository.findAllById(contentIds);
        List<ContentResource> contentResources = new ArrayList<>();
        for(Content content: contents){
            if(content.getContentType().equals(ContentType.MOVIE)){
                contentResources.add(contentMapper.movieToContentResource(movieRepository.findMovieByContentId(content.getId()).get()));
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                contentResources.add(contentMapper.tvSerieToContentResource(tVSeriesRepository.findTVSeriesByContentId(content.getId()).get()));
            }
        }

        return contentResources;
    }

    @Transactional(readOnly = true)
    public List<String> findTop5MostPopularGenres() {
        return viewRepository.findTop5MostPopularGenres();
    }

    @Transactional
    public View watchEpisode(WatchEpisodeForm watchEpisodeForm) {


        Profile foundProfile = profileRepository.findById(watchEpisodeForm.getProfile_id()).orElseThrow(() -> new NoSuchElementException(
                "Profile does not exists"
        ));

        Episode foundEpisode = episodeRepository.findById(watchEpisodeForm.getEpisode_id()).orElseThrow(() -> new NoSuchElementException(
                "Episode does not exists"
        ));


        Account foundAccount = accountRepository.findById(foundProfile.getAccount().getId()).orElseThrow(() -> new NoSuchElementException(
                "Account does not exists"
        ));


        if(foundAccount.getSubscriptionType()== SubscriptionType.NO_SUBSCRIPTION){
            throw new IllegalStateException("The account does not have any valid plans in order for you to watch");
        }


        if(!(watchEpisodeForm.getTimeWatchedInMinutes() > 0 && watchEpisodeForm.getTimeWatchedInMinutes()  <= foundEpisode.getSeason().getTvSeries().getContent().getRuntime())){
            throw new IllegalStateException("The amount of time you are trying to watch from this episode is invalid");
        }



        Optional<View> viewFound = viewRepository.findViewByEpisodeIdAndProfileId(watchEpisodeForm.getEpisode_id(), watchEpisodeForm.getProfile_id());
        WatchedListEpisode watchedListEpisode = new WatchedListEpisode();

        View view = new View();

        if(!viewFound.isEmpty()){
            viewFound.get().setWatchedDate(new Date());
            viewFound.get().setTimeWatchedInMinutes(watchEpisodeForm.getTimeWatchedInMinutes());

        }
        else{

            view.setWatchedDate(new Date());
            view.setProfile(foundProfile);
            view.setTimeWatchedInMinutes(watchEpisodeForm.getTimeWatchedInMinutes());
            view.setContent(foundEpisode.getSeason().getTvSeries().getContent());

            watchedListEpisode.setEpisode(foundEpisode);
            watchedListEpisode.setView(view);

            watchedListEpisodeRepository.save(watchedListEpisode);
            viewRepository.save(view);

        }

        return view;
    }

    @Transactional
    public View watchMovie(WatchMovieForm watchMovieForm) {


        Profile foundProfile = profileRepository.findById(watchMovieForm.getProfile_id()).orElseThrow(() -> new NoSuchElementException(
                "Profile does not exists"
        ));

        Movie foundMovie = movieRepository.findById(watchMovieForm.getMovie_id()).orElseThrow(() -> new NoSuchElementException(
                "Movie does not exists"
        ));


        Account foundAccount = accountRepository.findById(foundProfile.getAccount().getId()).orElseThrow(() -> new NoSuchElementException(
                "Account does not exists"
        ));


        if(foundAccount.getSubscriptionType()== SubscriptionType.NO_SUBSCRIPTION){
            throw new IllegalStateException("The account does not have any valid plans in order for you to watch");
        }


        if(!(watchMovieForm.getTimeWatchedInMinutes() > 0 && watchMovieForm.getTimeWatchedInMinutes()  <= foundMovie.getContent().getRuntime())){
            throw new IllegalStateException("The amount of time you are trying to watch from this movie is invalid");
        }



        Optional<View> viewFound = viewRepository.findViewByMovieIdAndProfileId(watchMovieForm.getMovie_id(), watchMovieForm.getProfile_id());

        WatchedListMovie watchedListMovie = new WatchedListMovie();

        View view = new View();

        if(!viewFound.isEmpty()){
            viewFound.get().setWatchedDate(new Date());
            viewFound.get().setTimeWatchedInMinutes(watchMovieForm.getTimeWatchedInMinutes());

        }
        else{

            view.setWatchedDate(new Date());
            view.setProfile(foundProfile);
            view.setTimeWatchedInMinutes(watchMovieForm.getTimeWatchedInMinutes());
            view.setContent(foundMovie.getContent());

            watchedListMovie.setMovie(foundMovie);
            watchedListMovie.setView(view);

            watchListMovieRepository.save(watchedListMovie);
            viewRepository.save(view);

        }

        return view;
    }
}
