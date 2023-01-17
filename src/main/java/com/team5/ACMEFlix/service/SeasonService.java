package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Episode;
import com.team5.ACMEFlix.domain.Season;
import com.team5.ACMEFlix.domain.TVSeries;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.repository.ContentRepository;
import com.team5.ACMEFlix.repository.EpisodeRepository;
import com.team5.ACMEFlix.repository.SeasonRepository;
import com.team5.ACMEFlix.repository.TVSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class SeasonService {

    @Autowired
    private SeasonRepository seasonRepository;
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private TVSeriesRepository tVSeriesRepository;
    @Autowired
    private EpisodeRepository episodeRepository;

    @Transactional(readOnly = true)
    public List<Season> findAllSeasons() {
        return seasonRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Season> findSeasonById(Long id) {
        return seasonRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Season> findAllSeasonsByContentId(Long id) {
        Optional<TVSeries> tvSeries = tVSeriesRepository.findTVSeriesByContentId(id);
        if(!tvSeries.isPresent()){
            throw new NoSuchElementException("TV Series does not exist");
        }
        else {
            return seasonRepository.findSeasonsByTvSeriesId(tvSeries.get().getId());
        }
    }

    @Transactional
    public Season addSeasonByTVSeriesId(Long id, Season season) {
        Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findById(id);
        if(!tvSeriesExists.isPresent()){
            throw new NoSuchElementException("TV Series does not exist");
        }
        else{
            System.out.println(tvSeriesExists.get() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            season.setTvSeries(tvSeriesExists.get());
            season.getEpisodes()
                    .forEach(e -> e.setSeason(season));
            seasonRepository.save(season);
        }
        return season;
    }

    @Transactional
    public List<Season> addSeasonsByTVSeriesId(Long id, List<Season> seasons) {
        for(Season season : seasons){
            Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findById(id);
            if(!tvSeriesExists.isPresent()){
                throw new NoSuchElementException("TV Series does not exist");
            }
            else{
                season.setTvSeries(tvSeriesExists.get());
                season.getEpisodes()
                        .forEach(e -> e.setSeason(season));
                seasonRepository.save(season);
            }
        }
        return seasons;
    }

    @Transactional
    public Season addSeasonByContentId(Long id, Season season) {
        Optional<Content> contentExists = contentRepository.findById(id);
        if(!contentExists.isPresent()){
            throw new NoSuchElementException("Content does not exist");
        }
        else if(!contentExists.get().getContentType().equals(ContentType.TV_SERIES)){
            throw new IllegalStateException("Content is not a tv series");
        }
        else{
            Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findTVSeriesByContentId(id);
            if(!tvSeriesExists.isPresent()){
                throw new NoSuchElementException("TV Series does not exist");
            }
            else {
                season.setTvSeries(tvSeriesExists.get());
                season.getEpisodes()
                        .forEach(e -> e.setSeason(season));
                seasonRepository.save(season);
            }

        }
        return season;
    }
    @Transactional
    public List<Season> addSeasonsByContentId(Long id, List<Season> seasons) {
        Optional<Content> contentExists = contentRepository.findById(id);
        if(!contentExists.isPresent()){
            throw new NoSuchElementException("Content does not exist");
        }
        else if(!contentExists.get().getContentType().equals(ContentType.TV_SERIES)){
            throw new IllegalStateException("Content is not a tv series");
        }
        else {
            Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findTVSeriesByContentId(id);
            if (!tvSeriesExists.isPresent()) {
                throw new NoSuchElementException("TV Series does not exist");
            } else {
                for (Season season : seasons) {
                    season.setTvSeries(tvSeriesExists.get());
                    season.getEpisodes()
                            .forEach(e -> e.setSeason(season));
                    seasonRepository.save(season);
                }

            }


        }
        return seasons;
    }

    @Transactional
    public void deleteSeasonById(Long id) {
        boolean exists = seasonRepository.existsById(id);
        if(!exists){
            throw new NoSuchElementException("Season does not exist");
        }
        else{

            seasonRepository.deleteById(id);

        }
    }

    @Transactional
    public void deleteSeasonsByIds(List<Long> ids) {
        for(Long id : ids){
            boolean exists = seasonRepository.existsById(id);
            if(!exists){
                throw new NoSuchElementException("Season does not exist");
            }
            else{

                seasonRepository.deleteById(id);

            }
        }
    }

    @Transactional
    public void updateSeasonById(Long id, Season season) {
        Optional<Season> seasonFound = seasonRepository.findById(id);
        if(!seasonFound.isPresent()){
            throw new NoSuchElementException("Season does not exist");
        }
        else{



            if (season.getEpisodes() != null &&
                    !Objects.equals(seasonFound.get().getEpisodes(), season.getEpisodes())) {
                List<Episode> episodes = episodeRepository.findEpisodesBySeason_Id(id);
                if (!episodes.isEmpty()) {
                    for (int i = 0; i < episodes.size(); i++) {
                        if (season.getEpisodes().get(i).getTitle() != null &&
                                season.getEpisodes().get(i).getTitle().length() >0 &&
                                !Objects.equals(episodes.get(i).getTitle(), season.getEpisodes().get(i).getTitle())) {
                            episodes.get(i).setTitle(season.getEpisodes().get(i).getTitle());
                        }

                        if (season.getEpisodes().get(i).getDescription() != null &&
                                season.getEpisodes().get(i).getDescription().length() > 0 &&
                                !Objects.equals(episodes.get(i).getDescription(), season.getEpisodes().get(i).getDescription())) {
                            episodes.get(i).setDescription(season.getEpisodes().get(i).getDescription());
                        }

                        if (season.getEpisodes().get(i).getImageUrl() != null &&
                                season.getEpisodes().get(i).getImageUrl().length() > 0 &&
                                !Objects.equals(episodes.get(i).getImageUrl(), season.getEpisodes().get(i).getImageUrl())) {
                            episodes.get(i).setImageUrl(season.getEpisodes().get(i).getImageUrl());
                        }

                        if (season.getEpisodes().get(i).getEpisodeNo() != null &&
                                season.getEpisodes().get(i).getEpisodeNo() > 0 &&
                                !Objects.equals(episodes.get(i).getEpisodeNo(), season.getEpisodes().get(i).getEpisodeNo())) {
                            episodes.get(i).setEpisodeNo(season.getEpisodes().get(i).getEpisodeNo());
                        }

                        if (season.getEpisodes().get(i).getReleaseDate() != null &&
                                season.getEpisodes().get(i).getReleaseDate().length() > 0 &&
                                !Objects.equals(episodes.get(i).getReleaseDate(), season.getEpisodes().get(i).getReleaseDate())) {
                            episodes.get(i).setReleaseDate(season.getEpisodes().get(i).getReleaseDate());
                        }

                    }
                }

            }

            if(season.getSeasonNo() !=null && season.getSeasonNo() >0 &&
                    !Objects.equals(seasonFound.get().getSeasonNo(), season.getSeasonNo())){
                seasonFound.get().setSeasonNo(season.getSeasonNo());
            }

        }
    }
}
