package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.domain.enumeration.SubscriptionType;
import com.team5.ACMEFlix.forms.WatchEpisodeForm;
import com.team5.ACMEFlix.forms.WatchMovieForm;
import com.team5.ACMEFlix.mapper.*;
import com.team5.ACMEFlix.repository.*;
import com.team5.ACMEFlix.transfer.resource.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.*;

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
    @Autowired
    private GenreMapper genreMapper;
    @Autowired
    private ActorMapper actorMapper;
    @Autowired
    private DirectorMapper directorMapper;
    @Autowired
    private WriterMapper writerMapper;
    @Autowired
    private CreatorMapper creatorMapper;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private WriterRepository writerRepository;
    @Autowired
    private CreatorRepository creatorRepository;


    @Transactional(readOnly = true)
    public List<ContentResource> findTop10MostViewedContent() {
        List<Long> contentIds= viewRepository.findTop10MostViewedContent();
        List<Content> contents = new ArrayList<>();
        for(Long id : contentIds){
            contents.add(contentRepository.findById(id).get());
        }



        List<ContentResource> contentResources = contentMapper.domainToResources(contents);

        List<ContentResource> contentResourcesReturn = new ArrayList<>();
        for(ContentResource content: contentResources){

            if(content.getContentType().equals(ContentType.MOVIE)){
                contentResourcesReturn.add(contentMapper.movieToContentResource(movieService.findMovieByContentId(content.getId()).get()));
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                contentResourcesReturn.add(contentMapper.tvSerieToContentResource(tvSeriesService.findTVSeriesByContentId(content.getId()).get()));
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

        List<Profile> profiles = profileRepository.findProfilesByAccount_Id(id);
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

    public List<AccountResourceViewingHistory> findAllViewingHistory() throws SQLException {

        List<Account> accounts = accountRepository.findAll();
        List<AccountResourceViewingHistory> accountResourcesViewingHistory = new ArrayList<>();

        List<ContentResourceProjection> movieResources = viewRepository.findAllViewingHistoryMovies();
        List<ContentResourceProjection> episodeResources = viewRepository.findAllViewingHistoryEpisodes();


        for(Account account: accounts){
            AccountResourceViewingHistory accountResourceViewingHistory = new AccountResourceViewingHistory();
            accountResourceViewingHistory.setId(account.getId());
            accountResourceViewingHistory.setEmail(account.getEmail());
            accountResourceViewingHistory.setFirstname(account.getFirstname());
            accountResourceViewingHistory.setUsername(account.getUsername());
            accountResourceViewingHistory.setLastname(account.getLastname());
            accountResourceViewingHistory.setCreationDate(account.getCreationDate());
            accountResourceViewingHistory.setSubscriptionType(account.getSubscriptionType());
            accountResourceViewingHistory.setSubscriptionDate(account.getSubscriptionDate());
            accountResourceViewingHistory.setPhoneNo(account.getPhoneNo());
            List<ProfileResourceViewingHistory> profileResourcesViewingHistory = new ArrayList<>();


            for(Profile profile : account.getProfiles()) {
                Float sumViewingHours = 0f;
                List<ContentResourceViewingHistory> contens = new ArrayList<>();

                ProfileResourceViewingHistory profileResourceViewingHistory = new ProfileResourceViewingHistory();

                profileResourceViewingHistory.setId(profile.getId());
                profileResourceViewingHistory.setImageUrl(profile.getImageUrl());
                profileResourceViewingHistory.setAgeRestricted(profile.getAgeRestricted());
                profileResourceViewingHistory.setFirstname(profile.getFirstname());


                for(ContentResourceProjection contentResourceProjection : movieResources){

                    if (profile.getId() == contentResourceProjection.getProfileId()) {

                        ContentResourceViewingHistory contentResourceViewingHistory = new ContentResourceViewingHistory();



                        contentResourceViewingHistory.setId(contentResourceProjection.getMovieId());
                        contentResourceViewingHistory.setTitle(contentResourceProjection.getTitle());
                        contentResourceViewingHistory.setDescription(contentResourceProjection.getTitle());
                        contentResourceViewingHistory.setSpokenLanguage(contentResourceProjection.getSpokenLanguage());
                        contentResourceViewingHistory.setIsAgeRestricted(contentResourceProjection.getIsAgeRestricted());
                        contentResourceViewingHistory.setContentType(contentResourceProjection.getContentType());
                        contentResourceViewingHistory.setRuntime(contentResourceProjection.getRuntime());
                        contentResourceViewingHistory.setReleaseDate(contentResourceProjection.getReleaseDate());


                        Clob imageUrl= contentResourceProjection.getImageUrl();
                        if(imageUrl!=null)
                            contentResourceViewingHistory.setImageUrl(imageUrl.getSubString(1, (int) imageUrl.length()));


                        Clob trailerUrl= contentResourceProjection.getTrailerUrl();
                        if(trailerUrl!=null)
                            contentResourceViewingHistory.setTrailerUrl(trailerUrl.getSubString(1, (int) trailerUrl.length()));

                        contentResourceViewingHistory.setWatchedDate(contentResourceProjection.getWatchedDate());
                        contentResourceViewingHistory.setViewingHours(contentResourceProjection.getTimeWatchedInMinutes()/60);
                        sumViewingHours += contentResourceProjection.getTimeWatchedInMinutes()/60;

                        List<Genre> genres = genreRepository.findGenreByContentId(contentResourceProjection.getId());
                        contentResourceViewingHistory.setGenres(genreMapper.toResources(genres));

                        List<Actor> actors = actorRepository.findActorByContentId(contentResourceProjection.getId());
                        contentResourceViewingHistory.setActors(actorMapper.toResources(actors));

                        List<Director> directors = directorRepository.findDirectorsByMovie_Id(contentResourceProjection.getMovieId());
                        contentResourceViewingHistory.setDirectors(directorMapper.toResources(directors));

                        List<Writer> writers = writerRepository.findWritersByMovieId(contentResourceProjection.getMovieId());
                        contentResourceViewingHistory.setWriters(writerMapper.toResources(writers));

                        contens.add(contentResourceViewingHistory);


                    }
                }

                for(ContentResourceProjection contentResourceProjection : episodeResources){

                    if (profile.getId() == contentResourceProjection.getProfileId()) {

                        ContentResourceViewingHistory contentResourceViewingHistory = new ContentResourceViewingHistory();



                        contentResourceViewingHistory.setId(contentResourceProjection.getEpisodeId());
                        contentResourceViewingHistory.setTitle(contentResourceProjection.getTitle());
                        contentResourceViewingHistory.setDescription(contentResourceProjection.getDescription());
                        contentResourceViewingHistory.setSpokenLanguage(contentResourceProjection.getSpokenLanguage());
                        contentResourceViewingHistory.setIsAgeRestricted(contentResourceProjection.getIsAgeRestricted());
                        contentResourceViewingHistory.setContentType(contentResourceProjection.getContentType());
                        contentResourceViewingHistory.setRuntime(contentResourceProjection.getRuntime());
                        contentResourceViewingHistory.setReleaseDate(contentResourceProjection.getReleaseDate());

                        Clob imageUrl= contentResourceProjection.getImageUrl();
                        if(imageUrl!=null)
                            contentResourceViewingHistory.setImageUrl(imageUrl.getSubString(1, (int) imageUrl.length()));


                        Clob trailerUrl= contentResourceProjection.getTrailerUrl();
                        if(trailerUrl!=null)
                            contentResourceViewingHistory.setTrailerUrl(trailerUrl.getSubString(1, (int) trailerUrl.length()));

                        contentResourceViewingHistory.setEpisodeImageUrl(contentResourceProjection.getEpisodeImageUrl());
                        contentResourceViewingHistory.setEpisodeNo(contentResourceProjection.getEpisodeNo());
                        contentResourceViewingHistory.setSeasonNo(contentResourceProjection.getSeasonNo());
                        contentResourceViewingHistory.setEpisodeTitle(contentResourceProjection.getEpisodeTitle());
                        contentResourceViewingHistory.setEpisodeDescription(contentResourceProjection.getEpisodeDescription());
                        contentResourceViewingHistory.setEpisodeReleaseDate(contentResourceProjection.getEpisodeReleaseDate());
                        contentResourceViewingHistory.setWatchedDate(contentResourceProjection.getWatchedDate());
                        contentResourceViewingHistory.setViewingHours(contentResourceProjection.getTimeWatchedInMinutes()/60);

                        sumViewingHours += contentResourceProjection.getTimeWatchedInMinutes()/60;

                        List<Genre> genres = genreRepository.findGenreByContentId(contentResourceProjection.getId());
                        contentResourceViewingHistory.setGenres(genreMapper.toResources(genres));

                        List<Actor> actors = actorRepository.findActorByContentId(contentResourceProjection.getId());
                        contentResourceViewingHistory.setActors(actorMapper.toResources(actors));

                        List<Creator> creators = creatorRepository.findCreatorsByTvSeriesId(contentResourceProjection.getTvSeriesId());
                        contentResourceViewingHistory.setCreators(creatorMapper.toResources(creators));



                        contens.add(contentResourceViewingHistory);


                    }
                }



                profileResourceViewingHistory.setViewingHours(sumViewingHours);

                Collections.sort(contens, new Comparator<ContentResourceViewingHistory>() {
                    public int compare(ContentResourceViewingHistory o1, ContentResourceViewingHistory o2) {
                        if (o1.getWatchedDate() == null || o2.getWatchedDate() == null)
                            return 0;
                        return o2.getWatchedDate().compareTo(o1.getWatchedDate());
                    }
                });



                profileResourceViewingHistory.setContents(contens);

                profileResourcesViewingHistory.add(profileResourceViewingHistory);


            }



            accountResourceViewingHistory.setProfiles(profileResourcesViewingHistory);



            accountResourcesViewingHistory.add(accountResourceViewingHistory);

        }



        return accountResourcesViewingHistory;
    }
}
