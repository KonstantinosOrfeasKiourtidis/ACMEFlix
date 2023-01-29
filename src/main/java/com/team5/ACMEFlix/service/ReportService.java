package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.mapper.ActorMapper;
import com.team5.ACMEFlix.mapper.GenreMapper;
import com.team5.ACMEFlix.mapper.ProfileViewingHoursMapper;
import com.team5.ACMEFlix.repository.*;
import com.team5.ACMEFlix.transfer.resource.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ReportService {
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ViewRepository viewRepository;
    @Autowired
    private ProfileViewingHoursMapper profileViewingHoursMapper;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ActorMapper actorMapper;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private GenreMapper genreMapper;
    @Autowired
    private EpisodeRepository episodeRepository;

    @Transactional(readOnly = true)
    public List<Content> findTop10HighestRatedContent() {
        List<Content> contents = contentRepository.findContent10HighestRated();
        return contents;
    }

    @Transactional(readOnly = true)
    public List<Content> findTop10MostViewedContent() {
        List<Content> contents= contentRepository.findTop10MostViewedContent();
        return contents;
    }

    @Transactional(readOnly = true)
    public List<String> findTop5MostPopularGenres() {
        return genreRepository.findTop5MostPopularGenres();
    }

    @Transactional(readOnly = true)
    public AccountViewingHours findViewingHoursByAccountId(Long id) {
        AccountViewingHours accountViewingHours = new AccountViewingHours();
        Account foundAccount = accountRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                "Account does not exists"
        ));
        accountViewingHours.setId(foundAccount.getId());
        accountViewingHours.setEmail(foundAccount.getEmail());

        accountViewingHours.setFirstname(foundAccount.getFirstname());
        accountViewingHours.setLastname(foundAccount.getLastname());
        accountViewingHours.setSubscriptionType(foundAccount.getSubscriptionType());
        accountViewingHours.setCreationDate(foundAccount.getCreationDate());
        accountViewingHours.setSubscriptionDate(foundAccount.getSubscriptionDate());
        accountViewingHours.setProfiles(profileViewingHoursMapper.toResources(foundAccount.getProfiles()));

        List<ProfileProjection> profileProjections = viewRepository.findViewingHoursByAccountId(id);
        List<Long> profileIds = new ArrayList<>();

        for (ProfileProjection profileProjection : profileProjections){
            profileIds.add(profileProjection.getId());
        }

        for (ProfileViewingHours profileViewingHours : accountViewingHours.getProfiles()){
            if(profileIds.contains(profileViewingHours.getId())){
                int index= profileIds.indexOf(profileViewingHours.getId());
                profileViewingHours.setViewingHours(profileProjections.get(index).getViewingHours());
            }
            else{
                profileViewingHours.setViewingHours(0F);
            }
        }
        return accountViewingHours;
    }

    @Transactional(readOnly = true)
    public List<AccountResourceViewingHistory> findAllViewingHistory() {

        List<Account> accounts = accountRepository.findAll();
        List<AccountResourceViewingHistory> accountResourcesViewingHistory = new ArrayList<>();

        List<ContentResourceProjection> movieResourceProjections =viewRepository.findAllViewingHistoryMovies();
        List<ContentResourceProjection> episodeResourceProjections =viewRepository.findAllViewingHistoryEpisodes();


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
            List<ProfileResourceViewingHistory> profileResourcesViewingHistory = new ArrayList<>();

            for(Profile profile : account.getProfiles()) {
                Float sumViewingHours = 0f;
                List<ContentResourceViewingHistory> contents = new ArrayList<>();

                ProfileResourceViewingHistory profileResourceViewingHistory = new ProfileResourceViewingHistory();

                profileResourceViewingHistory.setId(profile.getId());
                profileResourceViewingHistory.setImageUrl(profile.getImageUrl());
                profileResourceViewingHistory.setAgeRestricted(profile.getAgeRestricted());
                profileResourceViewingHistory.setFirstname(profile.getFirstname());


                for(ContentResourceProjection movieResourceProjection : movieResourceProjections){
                    if (profile.getId() == movieResourceProjection.getProfileId()) {
                        ContentResourceViewingHistory contentResourceViewingHistory = new ContentResourceViewingHistory();

                        Movie movie = movieRepository.findById(movieResourceProjection.getMovieId()).get();

                        contentResourceViewingHistory.setId(movie.getId());
                        contentResourceViewingHistory.setTitle(movie.getTitle());
                        contentResourceViewingHistory.setDescription(movie.getDescription());
                        contentResourceViewingHistory.setSpokenLanguage(movie.getSpokenLanguage());
                        contentResourceViewingHistory.setIsAgeRestricted(movie.getIsAgeRestricted());
                        contentResourceViewingHistory.setContentType(movie.getContentType());
                        contentResourceViewingHistory.setRuntime(movie.getRuntime());
                        contentResourceViewingHistory.setReleaseDate(movie.getReleaseDate());
                        contentResourceViewingHistory.setImageUrl(movie.getImageUrl());
                        contentResourceViewingHistory.setTrailerUrl(movie.getTrailerUrl());
                        contentResourceViewingHistory.setActors(actorMapper.toResources(movie.getActors()));
                        contentResourceViewingHistory.setGenres(genreMapper.toResources(movie.getGenres()));

                        contentResourceViewingHistory.setWatchedDate(movieResourceProjection.getWatchedDate());
                        contentResourceViewingHistory.setViewingHours(movieResourceProjection.getViewingHours());
                        sumViewingHours += movieResourceProjection.getViewingHours();

                        contents.add(contentResourceViewingHistory);
                    }

                }

                for(ContentResourceProjection episodeResourceProjection : episodeResourceProjections){
                    if (profile.getId() == episodeResourceProjection.getProfileId()) {
                        ContentResourceViewingHistory contentResourceViewingHistory = new ContentResourceViewingHistory();

                        Episode episode = episodeRepository.findById(episodeResourceProjection.getEpisodeId()).get();

                        contentResourceViewingHistory.setId(episode.getSeason().getTvSeries().getId());
                        contentResourceViewingHistory.setTitle(episode.getSeason().getTvSeries().getTitle());
                        contentResourceViewingHistory.setDescription(episode.getSeason().getTvSeries().getDescription());
                        contentResourceViewingHistory.setSpokenLanguage(episode.getSeason().getTvSeries().getSpokenLanguage());
                        contentResourceViewingHistory.setIsAgeRestricted(episode.getSeason().getTvSeries().getIsAgeRestricted());
                        contentResourceViewingHistory.setContentType(episode.getSeason().getTvSeries().getContentType());
                        contentResourceViewingHistory.setRuntime(episode.getSeason().getTvSeries().getRuntime());
                        contentResourceViewingHistory.setReleaseDate(episode.getSeason().getTvSeries().getReleaseDate());
                        contentResourceViewingHistory.setImageUrl(episode.getSeason().getTvSeries().getImageUrl());
                        contentResourceViewingHistory.setTrailerUrl(episode.getSeason().getTvSeries().getTrailerUrl());
                        contentResourceViewingHistory.setActors(actorMapper.toResources(episode.getSeason().getTvSeries().getActors()));
                        contentResourceViewingHistory.setGenres(genreMapper.toResources(episode.getSeason().getTvSeries().getGenres()));

                        contentResourceViewingHistory.setEpisodeNo(episode.getEpisodeNo());
                        contentResourceViewingHistory.setEpisodeTitle(episode.getTitle());
                        contentResourceViewingHistory.setEpisodeDescription(episode.getDescription());
                        contentResourceViewingHistory.setEpisodeImageUrl(episode.getImageUrl());
                        contentResourceViewingHistory.setEpisodeReleaseDate(episode.getReleaseDate());
                        contentResourceViewingHistory.setSeasonNo(episode.getSeason().getSeasonNo());

                        contentResourceViewingHistory.setWatchedDate(episodeResourceProjection.getWatchedDate());
                        contentResourceViewingHistory.setViewingHours(episodeResourceProjection.getViewingHours());
                        sumViewingHours += episodeResourceProjection.getViewingHours();

                        contents.add(contentResourceViewingHistory);
                    }
                }


                profileResourceViewingHistory.setViewingHours(sumViewingHours);

                Collections.sort(contents, new Comparator<ContentResourceViewingHistory>() {
                    public int compare(ContentResourceViewingHistory o1, ContentResourceViewingHistory o2) {
                        if (o1.getWatchedDate() == null || o2.getWatchedDate() == null)
                            return 0;
                        return o2.getWatchedDate().compareTo(o1.getWatchedDate());
                    }
                });



                profileResourceViewingHistory.setContents(contents);

                profileResourcesViewingHistory.add(profileResourceViewingHistory);

            }

            accountResourceViewingHistory.setProfiles(profileResourcesViewingHistory);



            accountResourcesViewingHistory.add(accountResourceViewingHistory);


        }



        return accountResourcesViewingHistory;
    }
}
