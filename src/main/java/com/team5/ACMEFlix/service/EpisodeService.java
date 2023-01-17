package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.Episode;
import com.team5.ACMEFlix.domain.Season;
import com.team5.ACMEFlix.domain.TVSeries;
import com.team5.ACMEFlix.repository.EpisodeRepository;
import com.team5.ACMEFlix.repository.SeasonRepository;
import com.team5.ACMEFlix.repository.TVSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;
    @Autowired
    private TVSeriesRepository tVSeriesRepository;
    @Autowired
    private SeasonRepository seasonRepository;

    @Transactional(readOnly = true)
    public List<Episode> findAllEpisodes() {
        return episodeRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Episode> findEpisodeById(Long id) {
        return episodeRepository.findById(id);
    }
    @Transactional(readOnly = true)
    public List<Episode> findAllEpisodesByContentId(Long id) {
        Optional<TVSeries> tvSeries = tVSeriesRepository.findTVSeriesByContentId(id);
        if(!tvSeries.isPresent()){
            throw new NoSuchElementException("TV Series does not exist");
        }
        else {
            List<Season> seasons = tvSeries.get().getSeasons();
            List<Episode> episodes = new ArrayList<>();
            for (int i = 0; i < seasons.size(); i++) {
                episodes.addAll(seasons.get(i).getEpisodes());
            }
            return episodes;
        }

    }

    @Transactional(readOnly = true)
    public List<Episode> findAllEpisodesByTitle(String search) {
        return episodeRepository.findEpisodesByName(search);

    }

    @Transactional(readOnly = true)
    public List<Long> findAllEpisodesByEpisodeName(String search, List<Long> contentIds) {
        List<Episode> episodes = episodeRepository.findEpisodesByName(search);
        for (Episode episode : episodes){
            if(!contentIds.contains(episode.getSeason().getTvSeries().getContent().getId())) {
                contentIds.add(episode.getSeason().getTvSeries().getContent().getId());

            }
        }

        return contentIds;

    }

    @Transactional
    public Episode addEpisodeBySeasonId(Long id, Episode episode) {

        Optional<Season> seasonExists = seasonRepository.findById(id);
        if(!seasonExists.isPresent()){
            throw new NoSuchElementException("Season does not exist");
        }
        else{
            episode.setSeason(seasonExists.get());
            episodeRepository.save(episode);
        }
        return episode;
    }

    @Transactional
    public List<Episode> addEpisodesBySeasonId(Long id, List<Episode> episodes) {
        for(Episode episode : episodes){
            Optional<Season> seasonExists = seasonRepository.findById(id);
            if(!seasonExists.isPresent()){
                throw new NoSuchElementException("Season does not exist");
            }
            else{
                episode.setSeason(seasonExists.get());
                episodeRepository.save(episode);
            }
        }
        return episodes;
    }

    @Transactional
    public void deleteEpisodeById(Long id) {
        boolean exists = episodeRepository.existsById(id);
        if(!exists){
            throw new NoSuchElementException("Episode does not exist");
        }
        else{

            episodeRepository.deleteById(id);

        }
    }
    @Transactional
    public void deleteEpisodesByIds(List<Long> ids) {
        for(Long id : ids){
            boolean exists = episodeRepository.existsById(id);
            if(!exists){
                throw new NoSuchElementException("Episode does not exist");
            }
            else{

                episodeRepository.deleteById(id);

            }
        }
    }

    @Transactional
    public void updateEpisodeById(Long id, Episode episode) {
        Optional<Episode> episodeFound = episodeRepository.findById(id);
        if(!episodeFound.isPresent()){
            throw new NoSuchElementException("Episode does not exist");
        }
        else{
            if(episode.getTitle() !=null &&
                    episode.getTitle().length() > 0 &&
                    !Objects.equals(episodeFound.get().getTitle(), episode.getTitle())){
                episodeFound.get().setTitle(episode.getTitle());
            }

            if(episode.getDescription() !=null &&
                    episode.getDescription().length() > 0 &&
                    !Objects.equals(episodeFound.get().getDescription(), episode.getDescription())){
                episodeFound.get().setDescription(episode.getDescription());
            }

            if(episode.getEpisodeNo() !=null &&
                    episode.getEpisodeNo() > 0 &&
                    !Objects.equals(episodeFound.get().getEpisodeNo(), episode.getEpisodeNo())){
                episodeFound.get().setEpisodeNo(episode.getEpisodeNo());
            }

            if(episode.getReleaseDate() !=null &&
                    episode.getReleaseDate().length() > 0 &&
                    !Objects.equals(episodeFound.get().getReleaseDate(), episode.getReleaseDate())){
                episodeFound.get().setReleaseDate(episode.getReleaseDate());
            }

            if(episode.getImageUrl() !=null &&
                    episode.getImageUrl().length() > 0 &&
                    !Objects.equals(episodeFound.get().getImageUrl(), episode.getImageUrl())){
                episodeFound.get().setImageUrl(episode.getImageUrl());
            }

        }
    }

}
