package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.domain.enumeration.TVSeriesStatusType;
import com.team5.ACMEFlix.mapper.ContentMapper;
import com.team5.ACMEFlix.mapper.MovieMapper;
import com.team5.ACMEFlix.mapper.TVSeriesMapper;
import com.team5.ACMEFlix.repository.*;
import com.team5.ACMEFlix.transfer.resource.ContentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.*;

@Service
public class ContentService {
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TVSeriesRepository tVSeriesRepository;
    @Autowired
    private EpisodeRepository episodeRepository;
    @Autowired
    private SeasonRepository seasonRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private WriterRepository writerRepository;
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private CreatorRepository creatorRepository;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ContentMapper contentMapper;

    @Transactional(readOnly = true)
    public List<Content> findAllContents() {
        return contentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<ContentResource> findAllContentsAlternative() {
        List<TVSeries> tvSeries = tVSeriesRepository.findAll();
        List<Movie> movies = movieRepository.findAll();
        List<ContentResource> contentResourceTVSeries = contentMapper.tvSeriesToContentResources(tvSeries);
        List<ContentResource> contentResourceMovies = contentMapper.moviesToContentResources(movies);

        List<ContentResource> contentResources = new ArrayList<>();
        contentResources.addAll(contentResourceTVSeries);
        contentResources.addAll(contentResourceMovies);
        Collections.shuffle(contentResources);
        return contentResources;
    }

    @Transactional(readOnly = true)
    public Optional<Content> findContentById(Long id) {
        return contentRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public ContentResource findContentByIdAlternative(Long id) {
        Optional<Content> content = contentRepository.findById(id);
        ContentResource contentResource = new ContentResource();
        if(!content.isPresent()){
            throw new NoSuchElementException("Content does not exist");
        }
        else{
            if(content.get().getContentType().equals(ContentType.MOVIE)){
                Optional<Movie> movie = movieRepository.findMovieByContentId(id);
                if(!movie.isPresent()){
                    throw new NoSuchElementException("Movie does not exist");
                }
                else{
                    contentResource = contentMapper.movieToContentResource(movie.get());
                }

            }
            else if(content.get().getContentType().equals(ContentType.TV_SERIES)){
                Optional<TVSeries> tvSeries = tVSeriesRepository.findTVSeriesByContentId(id);
                if(!tvSeries.isPresent()){
                    throw new NoSuchElementException("TV Series does not exist");
                }
                else{
                    contentResource = contentMapper.tvSerieToContentResource(tvSeries.get());
                }
            }

        }
        return contentResource;
    }


    @Transactional(readOnly = true)
    public List<ContentResource> findAllContentsByFamilyFriendly() {
        List<Long> moviesIDs = contentRepository.findMoviesIDsByFamilyFriendly();
        List<Movie> movies = movieRepository.findAllById(moviesIDs);
        List<Long> tvSeriesIDs = contentRepository.findTVSeriesIDsByFamilyFriendly();
        List<TVSeries> tvSeries = tVSeriesRepository.findAllById(tvSeriesIDs);

        List<ContentResource> contentResources = new ArrayList<>();
        List<ContentResource> contentFactoriesTVSeries = contentMapper.tvSeriesToContentResources(tvSeries);
        List<ContentResource> contentFactoriesMovies = contentMapper.moviesToContentResources(movies);

        contentResources.addAll(contentFactoriesTVSeries);
        contentResources.addAll(contentFactoriesMovies);
        Collections.shuffle(contentResources);
        return contentResources;
    }

    @Transactional(readOnly = true)
    public List<Content> findAllContentsByFamilyFriendlyAlternative() {
        List<Content> contents = contentRepository.findAllContentsByFamilyFriendly();
        return contents;
    }

    @Transactional(readOnly = true)
    public List<Content> findAllContentsByTitle(String search) {
        return contentRepository.findContentByName(search);
    }


    @Transactional(readOnly = true)
    public List<ContentResource> findAllContentsByTitleAlternative(String search) {
        List<Content> contents = contentRepository.findContentByName(search);
        List<Movie> movies = new ArrayList<>();
        List<TVSeries> tvSeries = new ArrayList<>();
        for (Content content: contents){
            if(content.getContentType().equals(ContentType.MOVIE)){
                movies.add(movieRepository.findMovieByContentId(content.getId()).get());
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                tvSeries.add(tVSeriesRepository.findTVSeriesByContentId(content.getId()).get());
            }
            else{

            }
        }
        List<ContentResource> moviesContentResource = contentMapper.moviesToContentResources(movies);
        List<ContentResource> tvSeriesContentResource = contentMapper.tvSeriesToContentResources(tvSeries);
        List<ContentResource> contentResources = new ArrayList<>();
        contentResources.addAll(moviesContentResource);
        contentResources.addAll(tvSeriesContentResource);
        return contentResources;
    }

    @Transactional(readOnly = true)
    public List<ContentResource> findAllContentsByNameOrByEpisodeName(String search) {
        List<Content> contents = contentRepository.findContentByName(search);
        List<Movie> movies = new ArrayList<>();
        List<TVSeries> tvSeries = new ArrayList<>();
        for (Content content: contents){
            if(content.getContentType().equals(ContentType.MOVIE)){
                movies.add(movieRepository.findMovieByContentId(content.getId()).get());
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                tvSeries.add(tVSeriesRepository.findTVSeriesByContentId(content.getId()).get());
            }
            else{

            }
        }



        List<Episode> episodes = episodeRepository.findEpisodesByName(search);
        List<Long> contentIds = new ArrayList<>();
        for (Episode episode : episodes){
            if(!contentIds.contains(episode.getSeason().getTvSeries().getContent().getId())) {
                contentIds.add(episode.getSeason().getTvSeries().getContent().getId());

            }
        }

        List<TVSeries> tvSeriesToAdd = new ArrayList<>();
        if(!tvSeries.isEmpty()) {
            for (TVSeries tvSerie : tvSeries) {

                if (!contentIds.contains(tvSerie.getContent().getId()) && !contentIds.isEmpty()) {
                    tvSeriesToAdd.add(tVSeriesRepository.findTVSeriesByContentId(tvSerie.getContent().getId()).get());
                }


            }
        }
        else{
            for (Long id: contentIds) {
                tvSeriesToAdd.add(tVSeriesRepository.findTVSeriesByContentId(id).get());
            }
        }

        tvSeries.addAll(tvSeriesToAdd);

        List<ContentResource> moviesContentResource = contentMapper.moviesToContentResources(movies);
        List<ContentResource> tvSeriesContentResource = contentMapper.tvSeriesToContentResources(tvSeries);
        List<ContentResource> contentResources = new ArrayList<>();
        contentResources.addAll(moviesContentResource);
        contentResources.addAll(tvSeriesContentResource);

        return contentResources;
    }

    @Transactional(readOnly = true)
    public List<ContentResource> findAllContentByGenres(String[] genre) {

        String query;
        query = "SELECT GENRES.CONTENT_ID FROM GENRES GROUP BY GENRES.CONTENT_ID ";

        for (int i = 0; i < genre.length; i++) {
            if(i == 0){
                query += "HAVING ";
            }

            query+= "GROUP_CONCAT(GENRES.NAME) LIKE '%"+ genre[i] + "%'";
            if(i != genre.length-1){
                query += " AND ";
            }
        }

        List<BigInteger> contentIds = entityManager.createNativeQuery(query).getResultList();

        List<Content> contents = contentRepository.findAllContentsById(contentIds);
        List<Movie> movies = new ArrayList<>();
        List<TVSeries> tvSeries = new ArrayList<>();
        for (Content content: contents){


            if(content.getContentType().equals(ContentType.MOVIE)){
                movies.add(movieRepository.findMovieByContentId(content.getId()).get());
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                tvSeries.add(tVSeriesRepository.findTVSeriesByContentId(content.getId()).get());
            }
            else{

            }
        }

        List<ContentResource> moviesContentResource = contentMapper.moviesToContentResources(movies);
        List<ContentResource> tvSeriesContentResource = contentMapper.tvSeriesToContentResources(tvSeries);
        List<ContentResource> contentResources = new ArrayList<>();
        contentResources.addAll(moviesContentResource);
        contentResources.addAll(tvSeriesContentResource);


        return contentResources;
    }
    @Transactional(readOnly = true)
    public List<ContentResource> findAllContentByActors(String[] actor) {
        String query;
        query = "SELECT ACTORS.CONTENT_ID FROM ACTORS GROUP BY ACTORS.CONTENT_ID ";

        for (int i = 0; i < actor.length; i++) {
            if(i == 0){
                query += "HAVING ";
            }

            query+= "GROUP_CONCAT(ACTORS.FULLNAME) LIKE '%"+ actor[i] + "%'";
            if(i != actor.length-1){
                query += " AND ";
            }
        }

        List<BigInteger> contentIds = entityManager.createNativeQuery(query).getResultList();

        List<Content> contents = contentRepository.findAllContentsById(contentIds);
        List<Movie> movies = new ArrayList<>();
        List<TVSeries> tvSeries = new ArrayList<>();
        for (Content content: contents){


            if(content.getContentType().equals(ContentType.MOVIE)){
                movies.add(movieRepository.findMovieByContentId(content.getId()).get());
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                tvSeries.add(tVSeriesRepository.findTVSeriesByContentId(content.getId()).get());
            }
            else{

            }
        }

        List<ContentResource> moviesContentResource = contentMapper.moviesToContentResources(movies);
        List<ContentResource> tvSeriesContentResource = contentMapper.tvSeriesToContentResources(tvSeries);
        List<ContentResource> contentResources = new ArrayList<>();
        contentResources.addAll(moviesContentResource);
        contentResources.addAll(tvSeriesContentResource);


        return contentResources;
    }

    @Transactional(readOnly = true)
    public List<ContentResource> findAllContentByLanguage(String language) {
        List<Content> contents = contentRepository.findContentByLanguage(language);



        List<Movie> movies = new ArrayList<>();
        List<TVSeries> tvSeries = new ArrayList<>();
        for (Content content: contents){
            if(content.getContentType().equals(ContentType.MOVIE)){
                movies.add(movieRepository.findMovieByContentId(content.getId()).get());
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                tvSeries.add(tVSeriesRepository.findTVSeriesByContentId(content.getId()).get());
            }
            else{

            }
        }

        List<ContentResource> moviesContentResource = contentMapper.moviesToContentResources(movies);
        List<ContentResource> tvSeriesContentResource = contentMapper.tvSeriesToContentResources(tvSeries);
        List<ContentResource> contentResources = new ArrayList<>();
        contentResources.addAll(moviesContentResource);
        contentResources.addAll(tvSeriesContentResource);


        return contentResources;
    }
    @Transactional(readOnly = true)
    public List<ContentResource> findAllContentByYear(String year) {
        List<Content> contents = contentRepository.findContentByYear(year);



        List<Movie> movies = new ArrayList<>();
        List<TVSeries> tvSeries = new ArrayList<>();
        for (Content content: contents){
            if(content.getContentType().equals(ContentType.MOVIE)){
                movies.add(movieRepository.findMovieByContentId(content.getId()).get());
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                tvSeries.add(tVSeriesRepository.findTVSeriesByContentId(content.getId()).get());
            }
            else{

            }
        }

        List<ContentResource> moviesContentResource = contentMapper.moviesToContentResources(movies);
        List<ContentResource> tvSeriesContentResource = contentMapper.tvSeriesToContentResources(tvSeries);
        List<ContentResource> contentResources = new ArrayList<>();
        contentResources.addAll(moviesContentResource);
        contentResources.addAll(tvSeriesContentResource);


        return contentResources;
    }

    @Transactional (readOnly = true)
    public List<ContentResource> findTop10HighestRatedContent() {

        List<Long> contentIds = ratingRepository.findContent10HighestRated();




        List<Content> contents = contentRepository.findAllById(contentIds);

        List<Movie> movies = new ArrayList<>();
        List<TVSeries> tvSeries = new ArrayList<>();
        for (Content content: contents){
            if(content.getContentType().equals(ContentType.MOVIE)){
                movies.add(movieRepository.findMovieByContentId(content.getId()).get());
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                tvSeries.add(tVSeriesRepository.findTVSeriesByContentId(content.getId()).get());
            }
            else{

            }
        }

        List<ContentResource> moviesContentResource = contentMapper.moviesToContentResources(movies);
        List<ContentResource> tvSeriesContentResource = contentMapper.tvSeriesToContentResources(tvSeries);



        List<ContentResource> contentResources = new ArrayList<>();
        contentResources.addAll(moviesContentResource);
        contentResources.addAll(tvSeriesContentResource);

        Collections.sort(contentResources, new Comparator<ContentResource>() {
            public int compare(ContentResource cr1, ContentResource cr2) {

                int result = Float.compare(cr2.getRating(), cr1.getRating());
                return result;
            }
        });


        return contentResources;
    }


    @Transactional
    public ContentResource addContent(ContentResource contentResource) {

        if(contentResource.getContentType().equals(ContentType.TV_SERIES)){
            TVSeries tvSerie = contentMapper.contentResourceToTVSerie(contentResource);
            tvSerie.getCreators()
                    .forEach(c -> c.setTvSeries(tvSerie));
            tvSerie.getSeasons()
                    .forEach(s -> s.setTvSeries(tvSerie));
            tvSerie.getSeasons()
                    .forEach(s -> s.getEpisodes()
                            .forEach(e -> e.setSeason(s)));
            tvSerie.getContent().getActors()
                    .forEach(a -> a.setContent(tvSerie.getContent()));
            tvSerie.getContent().getGenres()
                    .forEach(g -> g.setContent(tvSerie.getContent()));

            tVSeriesRepository.save(tvSerie);
        }
        else if(contentResource.getContentType().equals(ContentType.MOVIE)){
            Movie movie = contentMapper.contentResourceToMovie(contentResource);
            movie.getDirectors()
                    .forEach(d -> d.setMovie(movie));
            movie.getWriters()
                    .forEach(w -> w.setMovie(movie));

            movie.getContent().getActors()
                    .forEach(a -> a.setContent(movie.getContent()));
            movie.getContent().getGenres()
                    .forEach(g -> g.setContent(movie.getContent()));

            movieRepository.save(movie);
        }
        else{
            throw new IllegalStateException("Not a Movie or a TV Series");
        }
        return contentResource;
    }

    @Transactional
    public List<ContentResource> addContents(List<ContentResource> contentResources) {
        for(ContentResource contentResource : contentResources){
            if(contentResource.getContentType().equals(ContentType.TV_SERIES)){
                TVSeries tvSerie = contentMapper.contentResourceToTVSerie(contentResource);

                tvSerie.getCreators()
                        .forEach(c -> c.setTvSeries(tvSerie));
                tvSerie.getSeasons()
                        .forEach(s -> s.setTvSeries(tvSerie));
                tvSerie.getSeasons()
                        .forEach(s -> s.getEpisodes()
                                .forEach(e -> e.setSeason(s)));
                tvSerie.getContent().getActors()
                        .forEach(a -> a.setContent(tvSerie.getContent()));
                tvSerie.getContent().getGenres()
                        .forEach(g -> g.setContent(tvSerie.getContent()));

                tVSeriesRepository.save(tvSerie);
            }
            else if(contentResource.getContentType().equals(ContentType.MOVIE)){
                Movie movie = contentMapper.contentResourceToMovie(contentResource);
                movie.getDirectors()
                        .forEach(d -> d.setMovie(movie));
                movie.getWriters()
                        .forEach(w -> w.setMovie(movie));

                movie.getContent().getActors()
                        .forEach(a -> a.setContent(movie.getContent()));
                movie.getContent().getGenres()
                        .forEach(g -> g.setContent(movie.getContent()));

                movieRepository.save(movie);
            }
            else{
                throw new IllegalStateException("Not a Movie or a TV Series");
            }

        }
        return contentResources;
    }

    @Transactional
    public void deleteContentById(Long id) {
        boolean exists = contentRepository.existsById(id);
        if(!exists){
            throw new NoSuchElementException("Content does not exist");
        }
        else{
            Optional<Content> content = contentRepository.findById(id);
            if(content.get().getContentType().equals(ContentType.MOVIE)){
                Optional<Movie> movie = movieRepository.findMovieByContentId(id);
                if(!movie.isPresent()){
                    throw new NoSuchElementException("Movie does not exist");
                }
                else{
                    movieRepository.deleteById(movie.get().getId());
                }

            }
            else if(content.get().getContentType().equals(ContentType.TV_SERIES)){
                Optional<TVSeries> tvSeries = tVSeriesRepository.findTVSeriesByContentId(id);
                if(!tvSeries.isPresent()){
                    throw new NoSuchElementException("TV Series does not exist");
                }
                else{
                    tVSeriesRepository.deleteById(tvSeries.get().getId());
                }
            }
            else{

            }

        }
    }
    @Transactional
    public void deleteContentsByIds(List<Long> ids) {
        for (Long id : ids){
            boolean exists = contentRepository.existsById(id);
            if(!exists){
                throw new NoSuchElementException("Content does not exist");
            }
            else{
                Optional<Content> content = contentRepository.findById(id);
                if(content.get().getContentType().equals(ContentType.MOVIE)){
                    Optional<Movie> movie = movieRepository.findMovieByContentId(id);
                    if(!movie.isPresent()){
                        throw new NoSuchElementException("Movie does not exist");
                    }
                    else{
                        movieRepository.deleteById(movie.get().getId());
                    }

                }
                else if(content.get().getContentType().equals(ContentType.TV_SERIES)){
                    Optional<TVSeries> tvSeries = tVSeriesRepository.findTVSeriesByContentId(id);
                    if(!tvSeries.isPresent()){
                        throw new NoSuchElementException("TV Series does not exist");
                    }
                    else{
                        tVSeriesRepository.deleteById(tvSeries.get().getId());
                    }
                }
                else{

                }

            }
        }
    }

    @Transactional
    public void updateContentById(Long id, Content content) {
        Optional<Content> contentFound = contentRepository.findById(id);
        if(!contentFound.isPresent()){
            throw new NoSuchElementException("Content does not exist");
        }
        else{



            if (content.getTitle() != null &&
                    content.getTitle().length() >0 &&
                    !Objects.equals(contentFound.get().getTitle(), content.getTitle())) {
                contentFound.get().setTitle(content.getTitle());
            }

            if (content.getDescription() != null &&
                    content.getDescription().length() >0 &&
                    !Objects.equals(contentFound.get().getDescription(), content.getDescription())) {
                contentFound.get().setDescription(content.getDescription());
            }

            if (content.getContentType() != null &&
                    (content.getContentType().equals(ContentType.MOVIE) ||
                            content.getContentType().equals(ContentType.TV_SERIES))&&
                    !Objects.equals(contentFound.get().getContentType(), content.getContentType())) {
                contentFound.get().setContentType(content.getContentType());
            }

            if (content.getRuntime() != null &&
                    content.getRuntime() >0 &&
                    !Objects.equals(contentFound.get().getRuntime(), content.getRuntime())) {
                contentFound.get().setRuntime(content.getRuntime());
            }

            if (content.getReleaseDate() != null &&
                    content.getReleaseDate().length() >0 &&
                    !Objects.equals(contentFound.get().getReleaseDate(), content.getReleaseDate())) {
                contentFound.get().setReleaseDate(content.getReleaseDate());
            }

            if (content.getTrailerUrl() != null &&
                    content.getTrailerUrl().length() >0 &&
                    !Objects.equals(contentFound.get().getTrailerUrl(), content.getTrailerUrl())) {
                contentFound.get().setTrailerUrl(content.getTrailerUrl());
            }

            if (content.getImageUrl() != null &&
                    content.getImageUrl().length() >0 &&
                    !Objects.equals(contentFound.get().getImageUrl(), content.getImageUrl())) {
                contentFound.get().setImageUrl(content.getImageUrl());
            }

            if (content.getSpokenLanguage() != null &&
                    content.getSpokenLanguage().length() >0 &&
                    !Objects.equals(contentFound.get().getSpokenLanguage(), content.getSpokenLanguage())) {
                contentFound.get().setSpokenLanguage(content.getSpokenLanguage());
            }

            if (content.getIsAgeRestricted() != null &&
                    !Objects.equals(contentFound.get().getIsAgeRestricted(), content.getIsAgeRestricted())) {
                contentFound.get().setIsAgeRestricted(content.getIsAgeRestricted());
            }


            if (content.getActors() != null &&
                    !Objects.equals(contentFound.get().getActors(), content.getActors())) {
                List<Actor> actors = actorRepository.findActorByContentId(id);
                if (!actors.isEmpty()) {
                    for (int i = 0; i < actors.size(); i++) {
                        if (content.getActors().get(i).getFullname() != null &&
                                content.getActors().get(i).getFullname().length() >0 &&
                                !Objects.equals(actors.get(i).getFullname(), content.getActors().get(i).getFullname())) {
                            actors.get(i).setFullname(content.getActors().get(i).getFullname());
                        }

                        if (content.getActors().get(i).getImageUrl() != null &&
                                content.getActors().get(i).getImageUrl().length() >0 &&
                                !Objects.equals(actors.get(i).getImageUrl(), content.getActors().get(i).getImageUrl())) {
                            actors.get(i).setImageUrl(content.getActors().get(i).getImageUrl());
                        }
                    }
                }
            }

            if (content.getGenres() != null &&
                    !Objects.equals(contentFound.get().getGenres(), content.getGenres())) {
                List<Genre> genres = genreRepository.findGenreByContentId(id);
                if (!genres.isEmpty()) {
                    for (int i = 0; i < genres.size(); i++) {
                        if (content.getGenres().get(i).getName() != null &&
                                content.getGenres().get(i).getName().length() >0 &&
                                !Objects.equals(genres.get(i).getName(), content.getGenres().get(i).getName())) {
                            genres.get(i).setName(content.getGenres().get(i).getName());
                        }

                    }
                }

            }
        }
    }
    @Transactional
    public void updateContentByIdAlternative(Long id, ContentResource contentResource) {
        Optional<Content> contentFound = contentRepository.findById(id);
        if(!contentFound.isPresent()){
            throw new NoSuchElementException("Content does not exist");
        }
        else {


            if (contentResource.getDescription() != null && contentResource.getDescription().length() > 0 &&
                    !Objects.equals(contentFound.get().getDescription(), contentResource.getDescription())) {
                contentFound.get().setDescription(contentResource.getDescription());
            }

            if (contentResource.getImageUrl() != null && contentResource.getImageUrl().length() > 0 &&
                    !Objects.equals(contentFound.get().getImageUrl(), contentResource.getImageUrl())) {
                contentFound.get().setImageUrl(contentResource.getImageUrl());
            }

            if (contentResource.getContentType() != null && (contentResource.getContentType().equals(ContentType.MOVIE) ||
                    contentResource.getContentType().equals(ContentType.TV_SERIES)) &&
                    !Objects.equals(contentFound.get().getContentType(), contentResource.getContentType())) {
                contentFound.get().setContentType(contentResource.getContentType());
            }

            if (contentResource.getIsAgeRestricted() != null &&
                    !Objects.equals(contentFound.get().getIsAgeRestricted(), contentResource.getIsAgeRestricted())) {
                contentFound.get().setIsAgeRestricted(contentResource.getIsAgeRestricted());
            }

            if (contentResource.getReleaseDate() != null && contentResource.getReleaseDate().length() > 0 &&
                    !Objects.equals(contentFound.get().getReleaseDate(), contentResource.getReleaseDate())) {
                contentFound.get().setReleaseDate(contentResource.getReleaseDate());
            }

            if (contentResource.getRuntime() != null && contentResource.getRuntime() > 0 &&
                    !Objects.equals(contentFound.get().getRuntime(), contentResource.getRuntime())) {
                contentFound.get().setRuntime(contentResource.getRuntime());
            }

            if (contentResource.getSpokenLanguage() != null && contentResource.getSpokenLanguage().length() > 0 &&
                    !Objects.equals(contentFound.get().getSpokenLanguage(), contentResource.getSpokenLanguage())) {
                contentFound.get().setSpokenLanguage(contentResource.getSpokenLanguage());
            }

            if (contentResource.getTitle() != null && contentResource.getTitle().length() > 0 &&
                    !Objects.equals(contentFound.get().getTitle(), contentResource.getTitle())) {
                contentFound.get().setTitle(contentResource.getTitle());
            }

            if (contentResource.getTrailerUrl() != null && contentResource.getTrailerUrl().length() > 0 &&
                    !Objects.equals(contentFound.get().getTrailerUrl(), contentResource.getTrailerUrl())) {
                contentFound.get().setTrailerUrl(contentResource.getTrailerUrl());
            }

            if (contentResource.getGenres() != null &&
                    !Objects.equals(contentFound.get().getGenres(), contentResource.getGenres())) {
                List<Genre> genres = genreRepository.findGenreByContentId(id);
                if (!genres.isEmpty()) {
                    for (int i = 0; i < genres.size(); i++) {
                        if (contentResource.getGenres().get(i).getName() != null &&
                                contentResource.getGenres().get(i).getName().length() >0 &&
                                !Objects.equals(genres.get(i).getName(), contentResource.getGenres().get(i).getName())) {
                            genres.get(i).setName(contentResource.getGenres().get(i).getName());
                        }

                    }
                }
            }

            if (contentResource.getActors() != null &&
                    !Objects.equals(contentFound.get().getActors(), contentResource.getActors())) {
                List<Actor> actors = actorRepository.findActorByContentId(id);
                if (!actors.isEmpty()) {
                    for (int i = 0; i < actors.size(); i++) {
                        if (contentResource.getActors().get(i).getFullname() != null &&
                                contentResource.getActors().get(i).getFullname().length() >0 &&
                                !Objects.equals(actors.get(i).getFullname(), contentResource.getActors().get(i).getFullname())) {
                            actors.get(i).setFullname(contentResource.getActors().get(i).getFullname());
                        }

                        if (contentResource.getActors().get(i).getImageUrl() != null &&
                                contentResource.getActors().get(i).getImageUrl().length() >0 &&
                                !Objects.equals(actors.get(i).getImageUrl(), contentResource.getActors().get(i).getImageUrl())) {
                            actors.get(i).setImageUrl(contentResource.getActors().get(i).getImageUrl());
                        }

                    }
                }
            }


            if (contentResource.getContentType().equals(ContentType.MOVIE)){
                Optional<Movie> movieFound = movieRepository.findMovieByContentId(id);
                if(!movieFound.isPresent()){
                    throw new NoSuchElementException("Movie does not exist");
                }
                else{
                    if (contentResource.getWriters() != null &&
                            !Objects.equals(movieFound.get().getWriters(), contentResource.getWriters())) {

                        List<Writer> writers = writerRepository.findWriterByByMovieId(movieFound.get().getId());
                        if (!writers.isEmpty()) {
                            for (int i = 0; i < writers.size(); i++) {
                                if (contentResource.getWriters().get(i).getFullname() != null &&
                                        contentResource.getWriters().get(i).getFullname().length() >0 &&
                                        !Objects.equals(writers.get(i).getFullname(), contentResource.getWriters().get(i).getFullname())) {
                                    writers.get(i).setFullname(contentResource.getWriters().get(i).getFullname());
                                }

                                if (contentResource.getWriters().get(i).getImageUrl() != null &&
                                        contentResource.getWriters().get(i).getImageUrl().length() >0 &&
                                        !Objects.equals(writers.get(i).getImageUrl(), contentResource.getWriters().get(i).getImageUrl())) {
                                    writers.get(i).setImageUrl(contentResource.getWriters().get(i).getImageUrl());
                                }
                            }
                        }
                    }

                    if (contentResource.getDirectors() != null &&
                            !Objects.equals(movieFound.get().getDirectors(), contentResource.getDirectors())) {

                        List<Director> directors = directorRepository.findDirectorByByMovieId(movieFound.get().getId());
                        if (!directors.isEmpty()) {
                            for (int i = 0; i < directors.size(); i++) {
                                if (contentResource.getDirectors().get(i).getFullname() != null &&
                                        contentResource.getDirectors().get(i).getFullname().length() >0 &&
                                        !Objects.equals(directors.get(i).getFullname(), contentResource.getDirectors().get(i).getFullname())) {
                                    directors.get(i).setFullname(contentResource.getDirectors().get(i).getFullname());
                                }

                                if (contentResource.getDirectors().get(i).getImageUrl() != null &&
                                        contentResource.getDirectors().get(i).getImageUrl().length() >0 &&
                                        !Objects.equals(directors.get(i).getImageUrl(), contentResource.getDirectors().get(i).getImageUrl())) {
                                    directors.get(i).setFullname(contentResource.getDirectors().get(i).getImageUrl());
                                }

                            }
                        }
                    }
                }

            }
            else if (contentResource.getContentType().equals(ContentType.TV_SERIES)){
                Optional<TVSeries> tvSeriesFound = tVSeriesRepository.findTVSeriesByContentId(id);
                if(!tvSeriesFound.isPresent()){
                    throw new NoSuchElementException("TV Series does not exist");
                }
                else{
                    if (contentResource.getTvSeriesStatusType() != null &&
                            (contentResource.getTvSeriesStatusType().equals(TVSeriesStatusType.UKNOWN) ||
                                    contentResource.getTvSeriesStatusType().equals(TVSeriesStatusType.ONGOING) ||
                                    contentResource.getTvSeriesStatusType().equals(TVSeriesStatusType.COMPLETED))&&
                            !Objects.equals(tvSeriesFound.get().getTvSeriesStatusType(), contentResource.getTvSeriesStatusType())) {
                        tvSeriesFound.get().setTvSeriesStatusType(contentResource.getTvSeriesStatusType());
                    }

                    if (contentResource.getCreators() != null &&
                            !Objects.equals(tvSeriesFound.get().getCreators(), contentResource.getCreators())) {
                        List<Creator> creators = creatorRepository.findCreatorByByTVSeriesId(tvSeriesFound.get().getId());
                        if (!creators.isEmpty()) {
                            for (int i = 0; i < creators.size(); i++) {
                                if (contentResource.getCreators().get(i).getFullname() != null &&
                                        contentResource.getCreators().get(i).getFullname().length() >0 &&
                                        !Objects.equals(creators.get(i).getFullname(), contentResource.getCreators().get(i).getFullname())) {
                                    creators.get(i).setFullname(contentResource.getCreators().get(i).getFullname());
                                }

                                if (contentResource.getCreators().get(i).getImageUrl() != null &&
                                        contentResource.getCreators().get(i).getImageUrl().length() >0 &&
                                        !Objects.equals(creators.get(i).getImageUrl(), contentResource.getCreators().get(i).getImageUrl())) {
                                    creators.get(i).setImageUrl(contentResource.getCreators().get(i).getImageUrl());
                                }


                            }
                        }
                    }


                    if (contentResource.getSeasons() != null &&
                            !Objects.equals(tvSeriesFound.get().getSeasons(), contentResource.getSeasons())) {
                        List<Season> seasons = seasonRepository.findSeasonByTVSeriesId(tvSeriesFound.get().getId());
                        if (!seasons.isEmpty()) {
                            for (int i = 0; i < seasons.size()-1; i++) {
                                if (contentResource.getSeasons().get(i).getSeasonNo() != null &&
                                        contentResource.getSeasons().get(i).getSeasonNo() >0 &&
                                        !Objects.equals(seasons.get(i).getSeasonNo(), contentResource.getSeasons().get(i).getSeasonNo())) {
                                    seasons.get(i).setSeasonNo(contentResource.getSeasons().get(i).getSeasonNo());
                                }

                                if (contentResource.getSeasons().get(i).getEpisodes() != null &&
                                        !Objects.equals(seasons.get(i).getEpisodes(), contentResource.getSeasons().get(i).getEpisodes())) {
                                    List<Episode> episodes = episodeRepository.findEpisodeBySeasonId(seasons.get(i).getId());

                                    for (int y = 0; y < episodes.size(); y++) {
                                        if (contentResource.getSeasons().get(i).getEpisodes().get(y).getTitle() != null &&
                                                contentResource.getSeasons().get(i).getEpisodes().get(y).getTitle().length() > 0 &&
                                                !Objects.equals(episodes.get(i).getTitle(), contentResource.getSeasons().get(i).getEpisodes().get(y).getTitle())) {
                                            episodes.get(y).setTitle(contentResource.getSeasons().get(i).getEpisodes().get(y).getTitle());
                                        }

                                        if (contentResource.getSeasons().get(i).getEpisodes().get(y).getDescription() != null &&
                                                contentResource.getSeasons().get(i).getEpisodes().get(y).getDescription().length() > 0 &&
                                                !Objects.equals(episodes.get(i).getDescription(), contentResource.getSeasons().get(i).getEpisodes().get(y).getDescription())) {
                                            episodes.get(y).setDescription(contentResource.getSeasons().get(i).getEpisodes().get(y).getDescription());
                                        }

                                        if (contentResource.getSeasons().get(i).getEpisodes().get(y).getReleaseDate() != null &&
                                                contentResource.getSeasons().get(i).getEpisodes().get(y).getReleaseDate().length() > 0 &&
                                                !Objects.equals(episodes.get(i).getReleaseDate(), contentResource.getSeasons().get(i).getEpisodes().get(y).getReleaseDate())) {
                                            episodes.get(y).setReleaseDate(contentResource.getSeasons().get(i).getEpisodes().get(y).getReleaseDate());
                                        }

                                        if (contentResource.getSeasons().get(i).getEpisodes().get(y).getImageUrl() != null &&
                                                contentResource.getSeasons().get(i).getEpisodes().get(y).getImageUrl().length() > 0 &&
                                                !Objects.equals(episodes.get(i).getImageUrl(), contentResource.getSeasons().get(i).getEpisodes().get(y).getImageUrl())) {
                                            episodes.get(y).setImageUrl(contentResource.getSeasons().get(i).getEpisodes().get(y).getImageUrl());
                                        }

                                        if (contentResource.getSeasons().get(i).getEpisodes().get(y).getEpisodeNo() != null &&
                                                contentResource.getSeasons().get(i).getEpisodes().get(y).getEpisodeNo() > 0 &&
                                                !Objects.equals(episodes.get(i).getEpisodeNo(), contentResource.getSeasons().get(i).getEpisodes().get(y).getEpisodeNo())) {
                                            episodes.get(y).setEpisodeNo(contentResource.getSeasons().get(i).getEpisodes().get(y).getEpisodeNo());
                                        }

                                    }

                                }

                            }
                        }
                    }


                }
            }

        }
    }


}
