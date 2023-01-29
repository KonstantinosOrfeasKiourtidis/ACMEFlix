package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.domain.enumeration.TVSeriesStatusType;
import com.team5.ACMEFlix.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TVSeriesService {

    @Autowired
    private TVSeriesRepository tVSeriesRepository;

    @Transactional(readOnly = true)
    public List<TVSeries> findAllTVSeries() {
        return tVSeriesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<TVSeries> findTVSeriesById(Long id) {
        return tVSeriesRepository.findById(id);
    }

    @Transactional
    public TVSeries addTVSerie(TVSeries tvSerie) {
        tvSerie.getCreators()
                .forEach(c -> c.setTvSeries(tvSerie));
        tvSerie.getSeasons()
                .forEach(s -> s.setTvSeries(tvSerie));
        tvSerie.getSeasons()
                .forEach(s -> s.getEpisodes()
                        .forEach(e -> e.setSeason(s)));
        tvSerie.getActors()
                .forEach(a -> a.setContent(tvSerie));
        tvSerie.getGenres()
                .forEach(g -> g.setContent(tvSerie));

        tVSeriesRepository.save(tvSerie);
        return tvSerie;
    }

    @Transactional
    public List<TVSeries> addTVSeries(List<TVSeries> tvSeries) {
        for(TVSeries tvSerie : tvSeries){
            tvSerie.getCreators()
                    .forEach(c -> c.setTvSeries(tvSerie));
            tvSerie.getSeasons()
                    .forEach(s -> s.setTvSeries(tvSerie));
            tvSerie.getSeasons()
                    .forEach(s -> s.getEpisodes()
                            .forEach(e -> e.setSeason(s)));
            tvSerie.getActors()
                    .forEach(a -> a.setContent(tvSerie));
            tvSerie.getGenres()
                    .forEach(g -> g.setContent(tvSerie));

            tVSeriesRepository.save(tvSerie);
        }
        return tvSeries;
    }

    @Transactional
    public void deleteTVSeriesById(Long id) {
        boolean exists = tVSeriesRepository.existsById(id);
        if(!exists){
            throw new NoSuchElementException("TV Series does not exist");
        }
        else{
            tVSeriesRepository.deleteById(id);
        }
    }
    @Transactional
    public void deleteTVSeriesByIds(List<Long> ids) {
        for (Long id : ids){
            boolean exists = tVSeriesRepository.existsById(id);
            if(!exists){
                throw new NoSuchElementException("TV Series does not exist");
            }
            else{
                tVSeriesRepository.deleteById(id);
            }
        }
    }

    @Transactional
    public void updateTVSeriesById(Long id, TVSeries tvSeries) {
        Optional<TVSeries> tvSeriesFound = tVSeriesRepository.findById(id);
        if(!tvSeriesFound.isPresent()){
            throw new NoSuchElementException("TV Series does not exist");
        }
        else{


            if (tvSeries.getTitle() != null &&
                    tvSeries.getTitle().length() >0 &&
                    !Objects.equals(tvSeriesFound.get().getTitle(), tvSeries.getTitle())) {tvSeriesFound.get().setTitle(tvSeries.getTitle());
            }

            if (tvSeries.getDescription() != null &&
                    tvSeries.getDescription().length() >0 &&
                    !Objects.equals(tvSeriesFound.get().getDescription(), tvSeries.getDescription())) {
                tvSeriesFound.get().setDescription(tvSeries.getDescription());
            }

            if (tvSeries.getContentType() != null &&
                    (tvSeries.getContentType().equals(ContentType.MOVIE) ||
                            tvSeries.getContentType().equals(ContentType.TV_SERIES))&&
                    !Objects.equals(tvSeriesFound.get().getContentType(), tvSeries.getContentType())) {tvSeriesFound.get().setContentType(tvSeries.getContentType());
            }

            if (tvSeries.getRuntime() != null &&
                    tvSeries.getRuntime() >0 &&
                    !Objects.equals(tvSeriesFound.get().getRuntime(), tvSeries.getRuntime())) {
                tvSeriesFound.get().setRuntime(tvSeries.getRuntime());
            }

            if (tvSeries.getReleaseDate() != null &&
                    tvSeries.getReleaseDate().length() >0 &&
                    !Objects.equals(tvSeriesFound.get().getReleaseDate(), tvSeries.getReleaseDate())) {
                tvSeriesFound.get().setReleaseDate(tvSeries.getReleaseDate());
            }

            if (tvSeries.getTrailerUrl() != null &&
                    tvSeries.getTrailerUrl().length() >0 &&
                    !Objects.equals(tvSeriesFound.get().getTrailerUrl(), tvSeries.getTrailerUrl())) {
                tvSeriesFound.get().setTrailerUrl(tvSeries.getTrailerUrl());
            }

            if (tvSeries.getImageUrl() != null &&
                    tvSeries.getImageUrl().length() >0 &&
                    !Objects.equals(tvSeriesFound.get().getImageUrl(), tvSeries.getImageUrl())) {
                tvSeriesFound.get().setImageUrl(tvSeries.getImageUrl());
            }

            if (tvSeries.getSpokenLanguage() != null &&
                    tvSeries.getSpokenLanguage().length() >0 &&
                    !Objects.equals(tvSeriesFound.get().getSpokenLanguage(), tvSeries.getSpokenLanguage())) {
                tvSeriesFound.get().setSpokenLanguage(tvSeries.getSpokenLanguage());
            }

            if (tvSeries.getIsAgeRestricted() != null &&
                    !Objects.equals(tvSeriesFound.get().getIsAgeRestricted(), tvSeries.getIsAgeRestricted())) {
                tvSeriesFound.get().setIsAgeRestricted(tvSeries.getIsAgeRestricted());
            }


            if (tvSeries.getActors() != null &&
                    !Objects.equals(tvSeriesFound.get().getActors(), tvSeries.getActors())) {
                List<Actor> actors = tvSeriesFound.get().getActors();
                if (!actors.isEmpty()) {
                    for (int i = 0; i < actors.size(); i++) {
                        if (tvSeries.getActors().get(i).getFullname() != null &&
                                tvSeries.getActors().get(i).getFullname().length() >0 &&
                                !Objects.equals(actors.get(i).getFullname(), tvSeries.getActors().get(i).getFullname())) {
                            actors.get(i).setFullname(tvSeries.getActors().get(i).getFullname());
                        }

                        if (tvSeries.getActors().get(i).getImageUrl() != null &&
                                tvSeries.getActors().get(i).getImageUrl().length() >0 &&
                                !Objects.equals(actors.get(i).getImageUrl(), tvSeries.getActors().get(i).getImageUrl())) {
                            actors.get(i).setImageUrl(tvSeries.getActors().get(i).getImageUrl());
                        }
                    }
                }
            }

            if (tvSeries.getGenres() != null &&
                    !Objects.equals(tvSeriesFound.get().getGenres(), tvSeries.getGenres())) {
                List<Genre> genres = tvSeriesFound.get().getGenres();
                if (!genres.isEmpty()) {
                    for (int i = 0; i < genres.size(); i++) {
                        if (tvSeries.getGenres().get(i).getName() != null &&
                                tvSeries.getGenres().get(i).getName().length() >0 &&
                                !Objects.equals(genres.get(i).getName(), tvSeries.getGenres().get(i).getName())) {
                            genres.get(i).setName(tvSeries.getGenres().get(i).getName());
                        }

                    }
                }

            }

            if (tvSeries.getTvSeriesStatusType() != null &&
                    (tvSeries.getTvSeriesStatusType().equals(TVSeriesStatusType.UKNOWN) ||
                            tvSeries.getTvSeriesStatusType().equals(TVSeriesStatusType.ONGOING) ||
                            tvSeries.getTvSeriesStatusType().equals(TVSeriesStatusType.COMPLETED))&&
                    !Objects.equals(tvSeriesFound.get().getTvSeriesStatusType(), tvSeries.getTvSeriesStatusType())) {
                tvSeriesFound.get().setTvSeriesStatusType(tvSeries.getTvSeriesStatusType());
            }

            if (tvSeries.getCreators() != null &&
                    !Objects.equals(tvSeriesFound.get().getCreators(), tvSeries.getCreators())) {
                List<Creator> creators = tvSeriesFound.get().getCreators();
                if (!creators.isEmpty()) {
                    for (int i = 0; i < creators.size(); i++) {
                        if (tvSeries.getCreators().get(i).getFullname() != null &&
                                tvSeries.getCreators().get(i).getFullname().length() >0 &&
                                !Objects.equals(creators.get(i).getFullname(), tvSeries.getCreators().get(i).getFullname())) {
                            creators.get(i).setFullname(tvSeries.getCreators().get(i).getFullname());
                        }

                        if (tvSeries.getCreators().get(i).getImageUrl() != null &&
                                tvSeries.getCreators().get(i).getImageUrl().length() >0 &&
                                !Objects.equals(creators.get(i).getImageUrl(), tvSeries.getCreators().get(i).getImageUrl())) {
                            creators.get(i).setImageUrl(tvSeries.getCreators().get(i).getImageUrl());
                        }


                    }
                }
            }

            if (tvSeries.getSeasons() != null &&
                    !Objects.equals(tvSeriesFound.get().getSeasons(), tvSeries.getSeasons())) {
                List<Season> seasons = tvSeriesFound.get().getSeasons();
                if (!seasons.isEmpty()) {
                    for (int i = 0; i < seasons.size(); i++) {
                        if (tvSeries.getSeasons().get(i).getSeasonNo() != null &&
                                tvSeries.getSeasons().get(i).getSeasonNo() >0 &&
                                !Objects.equals(seasons.get(i).getSeasonNo(), tvSeries.getSeasons().get(i).getSeasonNo())) {
                            seasons.get(i).setSeasonNo(tvSeries.getSeasons().get(i).getSeasonNo());
                        }

                        if (tvSeries.getSeasons().get(i).getEpisodes() != null &&
                                !Objects.equals(seasons.get(i).getEpisodes(), tvSeries.getSeasons().get(i).getEpisodes())) {
                            List<Episode> episodes = tvSeriesFound.get().getSeasons().get(i).getEpisodes();

                            for (int y = 0; y < episodes.size(); y++) {
                                if (tvSeries.getSeasons().get(i).getEpisodes().get(y).getTitle() != null &&
                                        tvSeries.getSeasons().get(i).getEpisodes().get(y).getTitle().length() > 0 &&
                                        !Objects.equals(episodes.get(i).getTitle(), tvSeries.getSeasons().get(i).getEpisodes().get(y).getTitle())) {
                                    episodes.get(y).setTitle(tvSeries.getSeasons().get(i).getEpisodes().get(y).getTitle());
                                }

                                if (tvSeries.getSeasons().get(i).getEpisodes().get(y).getDescription() != null &&
                                        tvSeries.getSeasons().get(i).getEpisodes().get(y).getDescription().length() > 0 &&
                                        !Objects.equals(episodes.get(i).getDescription(), tvSeries.getSeasons().get(i).getEpisodes().get(y).getDescription())) {
                                    episodes.get(y).setDescription(tvSeries.getSeasons().get(i).getEpisodes().get(y).getDescription());
                                }

                                if (tvSeries.getSeasons().get(i).getEpisodes().get(y).getReleaseDate() != null &&
                                        tvSeries.getSeasons().get(i).getEpisodes().get(y).getReleaseDate().length() > 0 &&
                                        !Objects.equals(episodes.get(i).getReleaseDate(), tvSeries.getSeasons().get(i).getEpisodes().get(y).getReleaseDate())) {
                                    episodes.get(y).setReleaseDate(tvSeries.getSeasons().get(i).getEpisodes().get(y).getReleaseDate());
                                }

                                if (tvSeries.getSeasons().get(i).getEpisodes().get(y).getImageUrl() != null &&
                                        tvSeries.getSeasons().get(i).getEpisodes().get(y).getImageUrl().length() > 0 &&
                                        !Objects.equals(episodes.get(i).getImageUrl(), tvSeries.getSeasons().get(i).getEpisodes().get(y).getImageUrl())) {
                                    episodes.get(y).setImageUrl(tvSeries.getSeasons().get(i).getEpisodes().get(y).getImageUrl());
                                }

                                if (tvSeries.getSeasons().get(i).getEpisodes().get(y).getEpisodeNo() != null &&
                                        tvSeries.getSeasons().get(i).getEpisodes().get(y).getEpisodeNo() > 0 &&
                                        !Objects.equals(episodes.get(i).getEpisodeNo(), tvSeries.getSeasons().get(i).getEpisodes().get(y).getEpisodeNo())) {
                                    episodes.get(y).setEpisodeNo(tvSeries.getSeasons().get(i).getEpisodes().get(y).getEpisodeNo());
                                }

                            }

                        }

                    }
                }
            }


        }
    }



}
