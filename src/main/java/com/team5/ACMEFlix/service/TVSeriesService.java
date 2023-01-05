package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.domain.enumeration.TVSeriesStatusType;
import com.team5.ACMEFlix.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TVSeriesService {

    @Autowired
    private TVSeriesRepository tVSeriesRepository;
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private SeasonRepository seasonRepository;
    @Autowired
    private CreatorRepository creatorRepository;
    @Autowired
    private EpisodeRepository episodeRepository;


    @Transactional(readOnly = true)
    public List<TVSeries> findAllTVSeries() {
        return tVSeriesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ResponseEntity<TVSeries> findTVSeriesById(Long id) {
        return tVSeriesRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional(readOnly = true)
    public List<TVSeries> findAllTVSeriesFamilyFriendly() {
        return tVSeriesRepository.findTVSeriesByFamilyFriendly();
    }

    @Transactional(readOnly = true)
    public List<TVSeries> findAllTVSeriesByTitle(String search) {
        return tVSeriesRepository.findTVSeriesByName(search);
    }

    @Transactional(readOnly = true)
    public List<TVSeries> getAllTVSeriesByCreators(String[] creator) {
        return tVSeriesRepository.findTVSeriesByCreator(creator);
    }

    @Transactional(readOnly = true)
    public List<TVSeries> findAllTVSeriesByTVSeriesStatusType(String statusType) {
        return tVSeriesRepository.findTVSeriesByStatusType(statusType);
    }

    @Transactional
    public void addTVSerie(TVSeries tvSerie) {
        tvSerie.getCreators()
                .forEach(c -> c.setTvSeries(tvSerie));
        tvSerie.getSeasons()
                .forEach(s -> s.setTvSeries(tvSerie));

        tvSerie.getContent().getActors()
                .forEach(a -> a.setContent(tvSerie.getContent()));
        tvSerie.getContent().getGenres()
                .forEach(g -> g.setContent(tvSerie.getContent()));

        tVSeriesRepository.save(tvSerie);
    }

    @Transactional
    public void addTVSeries(TVSeries[] tvSeries) {
        for(TVSeries tvSerie : tvSeries){
            tvSerie.getCreators()
                    .forEach(c -> c.setTvSeries(tvSerie));
            tvSerie.getSeasons()
                    .forEach(s -> s.setTvSeries(tvSerie));

            tvSerie.getContent().getActors()
                    .forEach(a -> a.setContent(tvSerie.getContent()));
            tvSerie.getContent().getGenres()
                    .forEach(g -> g.setContent(tvSerie.getContent()));

            tVSeriesRepository.save(tvSerie);
        }
    }

    @Transactional
    public void updateTVSeriesById(TVSeries tvSeries, Long id) {
        Optional<TVSeries> tvSeriesFound = tVSeriesRepository.findById(id);
        if(!tvSeriesFound.isPresent()){
            throw new IllegalStateException("TV Series does not exist");
        }
        else{


            if (tvSeries.getContent().getTitle() != null &&
                    tvSeries.getContent().getTitle().length() >0 &&
                    !Objects.equals(tvSeriesFound.get().getContent().getTitle(), tvSeries.getContent().getTitle())) {tvSeriesFound.get().getContent().setTitle(tvSeries.getContent().getTitle());
            }

            if (tvSeries.getContent().getDescription() != null &&
                    tvSeries.getContent().getDescription().length() >0 &&
                    !Objects.equals(tvSeriesFound.get().getContent().getDescription(), tvSeries.getContent().getDescription())) {
                tvSeriesFound.get().getContent().setDescription(tvSeries.getContent().getDescription());
            }

            if (tvSeries.getContent().getContentType() != null &&
                    (tvSeries.getContent().getContentType().equals(ContentType.MOVIE) ||
                            tvSeries.getContent().getContentType().equals(ContentType.TV_SERIES))&&
                    !Objects.equals(tvSeriesFound.get().getContent().getContentType(), tvSeries.getContent().getContentType())) {tvSeriesFound.get().getContent().setContentType(tvSeries.getContent().getContentType());
            }

            if (tvSeries.getContent().getRuntime() != null &&
                    tvSeries.getContent().getRuntime() >0 &&
                    !Objects.equals(tvSeriesFound.get().getContent().getRuntime(), tvSeries.getContent().getRuntime())) {
                tvSeriesFound.get().getContent().setRuntime(tvSeries.getContent().getRuntime());
            }

            if (tvSeries.getContent().getReleaseDate() != null &&
                    tvSeries.getContent().getReleaseDate().length() >0 &&
                    !Objects.equals(tvSeriesFound.get().getContent().getReleaseDate(), tvSeries.getContent().getReleaseDate())) {
                tvSeriesFound.get().getContent().setReleaseDate(tvSeries.getContent().getReleaseDate());
            }

            if (tvSeries.getContent().getTrailerUrl() != null &&
                    tvSeries.getContent().getTrailerUrl().length() >0 &&
                    !Objects.equals(tvSeriesFound.get().getContent().getTrailerUrl(), tvSeries.getContent().getTrailerUrl())) {
                tvSeriesFound.get().getContent().setTrailerUrl(tvSeries.getContent().getTrailerUrl());
            }

            if (tvSeries.getContent().getImageUrl() != null &&
                    tvSeries.getContent().getImageUrl().length() >0 &&
                    !Objects.equals(tvSeriesFound.get().getContent().getImageUrl(), tvSeries.getContent().getImageUrl())) {
                tvSeriesFound.get().getContent().setImageUrl(tvSeries.getContent().getImageUrl());
            }

            if (tvSeries.getContent().getSpokenLanguage() != null &&
                    tvSeries.getContent().getSpokenLanguage().length() >0 &&
                    !Objects.equals(tvSeriesFound.get().getContent().getSpokenLanguage(), tvSeries.getContent().getSpokenLanguage())) {
                tvSeriesFound.get().getContent().setSpokenLanguage(tvSeries.getContent().getSpokenLanguage());
            }

            if (tvSeries.getContent().getIsAgeRestricted() != null &&
                    !Objects.equals(tvSeriesFound.get().getContent().getIsAgeRestricted(), tvSeries.getContent().getIsAgeRestricted())) {
                tvSeriesFound.get().getContent().setIsAgeRestricted(tvSeries.getContent().getIsAgeRestricted());
            }


            if (tvSeries.getContent().getActors() != null &&
                    !Objects.equals(tvSeriesFound.get().getContent().getActors(), tvSeries.getContent().getActors())) {
                List<Actor> actors = actorRepository.findActorByContentId(tvSeriesFound.get().getContent().getId());
                if (!actors.isEmpty()) {
                    for (int i = 0; i < actors.size(); i++) {
                        if (tvSeries.getContent().getActors().get(i).getFullname() != null &&
                                tvSeries.getContent().getActors().get(i).getFullname().length() >0 &&
                                !Objects.equals(actors.get(i).getFullname(), tvSeries.getContent().getActors().get(i).getFullname())) {
                            actors.get(i).setFullname(tvSeries.getContent().getActors().get(i).getFullname());
                        }

                        if (tvSeries.getContent().getActors().get(i).getImageUrl() != null &&
                                tvSeries.getContent().getActors().get(i).getImageUrl().length() >0 &&
                                !Objects.equals(actors.get(i).getImageUrl(), tvSeries.getContent().getActors().get(i).getImageUrl())) {
                            actors.get(i).setImageUrl(tvSeries.getContent().getActors().get(i).getImageUrl());
                        }
                    }
                }
            }

            if (tvSeries.getContent().getGenres() != null &&
                    !Objects.equals(tvSeriesFound.get().getContent().getGenres(), tvSeries.getContent().getGenres())) {
                List<Genre> genres = genreRepository.findGenreByContentId(tvSeriesFound.get().getContent().getId());
                if (!genres.isEmpty()) {
                    for (int i = 0; i < genres.size(); i++) {
                        if (tvSeries.getContent().getGenres().get(i).getName() != null &&
                                tvSeries.getContent().getGenres().get(i).getName().length() >0 &&
                                !Objects.equals(genres.get(i).getName(), tvSeries.getContent().getGenres().get(i).getName())) {
                            genres.get(i).setName(tvSeries.getContent().getGenres().get(i).getName());
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
                List<Creator> creators = creatorRepository.findCreatorByByTVSeriesId(id);
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
                List<Season> seasons = seasonRepository.findSeasonByTVSeriesId(id);
                if (!seasons.isEmpty()) {
                    for (int i = 0; i < seasons.size(); i++) {
                        if (tvSeries.getSeasons().get(i).getSeasonNo() != null &&
                                tvSeries.getSeasons().get(i).getSeasonNo() >0 &&
                                !Objects.equals(seasons.get(i).getSeasonNo(), tvSeries.getSeasons().get(i).getSeasonNo())) {
                            seasons.get(i).setSeasonNo(tvSeries.getSeasons().get(i).getSeasonNo());
                        }

                        if (tvSeries.getSeasons().get(i).getEpisodes() != null &&
                                !Objects.equals(seasons.get(i).getEpisodes(), tvSeries.getSeasons().get(i).getEpisodes())) {
                            List<Episode> episodes = episodeRepository.findEpisodeBySeasonId(seasons.get(i).getId());

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