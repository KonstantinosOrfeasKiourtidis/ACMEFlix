package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.domain.enumeration.SubscriptionType;
import com.team5.ACMEFlix.helpers.WatchEpisodeForm;
import com.team5.ACMEFlix.helpers.WatchMovieForm;
import com.team5.ACMEFlix.mapper.AccountMapperViewingHours;
import com.team5.ACMEFlix.mapper.ContentMapper;
import com.team5.ACMEFlix.mapper.ProfileMapper;
import com.team5.ACMEFlix.repository.*;
import com.team5.ACMEFlix.transfer.resource.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Stream;

@Service
public class ViewService {

    @Autowired
    private ViewRepository viewRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private EpisodeRepository episodeRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private WatchListEpisodeRepository watchedListEpisodeRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieService movieService;
    @Autowired
    private TVSeriesService tvSeriesService;
    @Autowired
    private WatchListMovieRepository watchListMovieRepository;
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private ContentMapper contentMapper;


    @Transactional(readOnly = true)
    public List<ContentResource> findTop10MostViewedContent() {
        List<Long> contentIds= viewRepository.findTop10MostViewedContent();
        List<Content> contents = contentRepository.findAllById(contentIds);
        List<ContentResource> contentResources = contentMapper.domainToResources(contents);

        List<ContentResource> contentResourcesReturn = new ArrayList<>();
        for(ContentResource content: contentResources){
            if(content.getContentType().equals(ContentType.MOVIE)){
                contentResources.add(contentMapper.movieToContentResource(movieService.findMovieByContentId(content.getId()).get()));
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                contentResources.add(contentMapper.tvSerieToContentResource(tvSeriesService.findTVSeriesByContentId(content.getId()).get()));
            }
        }

        return contentResourcesReturn;
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

    public AccountResourceViewingHours findViewingHoursByAccountId(Long id) {
        List<Long> profileIds =  viewRepository.findProfileIdsByAccountId(id);
        List<Float> viewingMinutes =  viewRepository.findViewingHoursByAccountId(id);


        List<Float> viewingHours = new ArrayList<>();
        for (Float viewingMinute: viewingMinutes){
            viewingHours.add(viewingMinute/60);
        }

        Optional<Account> accountFound = accountRepository.findById(id);
        if(!accountFound.isPresent()){
            throw new NoSuchElementException("Account does not exist");
        }

        AccountResourceViewingHours accountResourceViewingHours = new AccountResourceViewingHours();
        accountResourceViewingHours.setFirstname(accountFound.get().getFirstname());
        accountResourceViewingHours.setLastname(accountFound.get().getLastname());
        accountResourceViewingHours.setPhoneNo(accountFound.get().getPhoneNo());
        accountResourceViewingHours.setUsername(accountFound.get().getUsername());
        accountResourceViewingHours.setSubscriptionType(accountFound.get().getSubscriptionType());
        accountResourceViewingHours.setCreationDate(accountFound.get().getSubscriptionDate());
        accountResourceViewingHours.setEmail(accountFound.get().getEmail());

        List<Profile> profiles = profileRepository.findProfileByByAccountId(id);
        List<ProfileResourceViewingHours> profileResourceViewingHoursReturn = new ArrayList<>();

        for (int i = 0; i < profiles.size(); i++) {


            ProfileResourceViewingHours profileResourceViewingHours = new ProfileResourceViewingHours();
            profileResourceViewingHours.setImageUrl(profiles.get(i).getImageUrl());
            profileResourceViewingHours.setAgeRestricted(profiles.get(i).getAgeRestricted());
            profileResourceViewingHours.setFirstname(profiles.get(i).getFirstname());
            profileResourceViewingHours.setId(profiles.get(i).getId());



                if(profileIds.contains(profiles.get(i).getId()) ){
                    int index= profileIds.indexOf(profiles.get(i).getId());
                    profileResourceViewingHours.setViewingHours(viewingHours.get(index));
                }




            profileResourceViewingHoursReturn.add(profileResourceViewingHours);

        }

        accountResourceViewingHours.setProfiles(profileResourceViewingHoursReturn);


        return accountResourceViewingHours;
    }
}