package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.domain.enumeration.TVSeriesStatusType;
import com.team5.ACMEFlix.helpers.ContentFactory;
import com.team5.ACMEFlix.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private ContentFactory contentFactory;
    @Autowired
    private RatingRepository ratingRepository;


    @Transactional(readOnly = true)
    public List<Content> findAllContents() {
        return contentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<ContentFactory> findAllContentsAlternative() {
        List<TVSeries> tvSeries = tVSeriesRepository.findAll();
        List<Movie> movies = movieRepository.findAll();
        List<ContentFactory> contentFactoriesTVSeries = contentFactory.tvSeriesToContentFactoryList(tvSeries);
        List<ContentFactory> contentFactoriesMovies = contentFactory.moviesToContentFactoryList(movies);
        List<ContentFactory> contentFactories = new ArrayList<>();
        contentFactories.addAll(contentFactoriesTVSeries);
        contentFactories.addAll(contentFactoriesMovies);
        Collections.shuffle(contentFactories);
        return contentFactories;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Content> findContentById(Long id) {
        return contentRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional(readOnly = true)
    public ContentFactory findContentByIdAlternative(Long id) {
        Optional<Content> content = contentRepository.findById(id);
        ContentFactory contentFactory = new ContentFactory();
        if(!content.isPresent()){
            throw new IllegalStateException("Content does not exist");
        }
        else{
            if(content.get().getContentType().equals(ContentType.MOVIE)){
                Optional<Movie> movie = movieRepository.findMovieByContentId(id);
                if(!movie.isPresent()){
                    throw new IllegalStateException("Movie does not exist");
                }
                else{
                    contentFactory = contentFactory.movieToContentFactory(movie.get());
                }

            }
            else if(content.get().getContentType().equals(ContentType.TV_SERIES)){
                Optional<TVSeries> tvSeries = tVSeriesRepository.findTVSeriesByContentId(id);
                if(!tvSeries.isPresent()){
                    throw new IllegalStateException("TV Series does not exist");
                }
                else{
                    contentFactory = contentFactory.tvSerieToContentFactory(tvSeries.get());
                }
            }
            else{

            }

        }
        return contentFactory;
    }


    @Transactional(readOnly = true)
    public List<ContentFactory> findAllContentsByFamilyFriendly() {
        List<Long> moviesIDs = contentRepository.findMoviesIDsByFamilyFriendly();
        List<Movie> movies = movieRepository.findAllById(moviesIDs);
        List<Long> tvSeriesIDs = contentRepository.findTVSeriesIDsByFamilyFriendly();
        List<TVSeries> tvSeries = tVSeriesRepository.findAllById(tvSeriesIDs);

        List<ContentFactory> contentFactories = new ArrayList<>();
        List<ContentFactory> contentFactoriesTVSeries = contentFactory.tvSeriesToContentFactoryList(tvSeries);
        List<ContentFactory> contentFactoriesMovies = contentFactory.moviesToContentFactoryList(movies);
        contentFactories.addAll(contentFactoriesTVSeries);
        contentFactories.addAll(contentFactoriesMovies);
        Collections.shuffle(contentFactories);
        return contentFactories;
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
    public List<ContentFactory> findAllContentsByTitleAlternative(String search) {
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
        List<ContentFactory> moviesContentFactory = contentFactory.moviesToContentFactoryList(movies);
        List<ContentFactory> tvSeriesContentFactory = contentFactory.tvSeriesToContentFactoryList(tvSeries);
        List<ContentFactory> contentFactories = new ArrayList<>();
        contentFactories.addAll(moviesContentFactory);
        contentFactories.addAll(tvSeriesContentFactory);
        return contentFactories;
    }

    @Transactional(readOnly = true)
    public List<ContentFactory> findAllContentsByNameOrByEpisodeName(String search) {
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

        List<ContentFactory> moviesContentFactory = contentFactory.moviesToContentFactoryList(movies);
        List<ContentFactory> tvSeriesContentFactory = contentFactory.tvSeriesToContentFactoryList(tvSeries);
        List<ContentFactory> contentFactories = new ArrayList<>();
        contentFactories.addAll(moviesContentFactory);
        contentFactories.addAll(tvSeriesContentFactory);

        return contentFactories;
    }

    @Transactional(readOnly = true)
    public List<ContentFactory> findAllContentByGenres(String[] genre) {

        //TODO
        List<Content> contents = contentRepository.findContentByGenre(genre);

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

        List<ContentFactory> moviesContentFactory = contentFactory.moviesToContentFactoryList(movies);
        List<ContentFactory> tvSeriesContentFactory = contentFactory.tvSeriesToContentFactoryList(tvSeries);
        List<ContentFactory> contentFactories = new ArrayList<>();
        contentFactories.addAll(moviesContentFactory);
        contentFactories.addAll(tvSeriesContentFactory);


        return contentFactories;
    }
    @Transactional(readOnly = true)
    public List<ContentFactory> findAllContentByActors(String[] actor) {
        //TODO
        List<Content> contents = contentRepository.findContentByActor(actor);



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

        List<ContentFactory> moviesContentFactory = contentFactory.moviesToContentFactoryList(movies);
        List<ContentFactory> tvSeriesContentFactory = contentFactory.tvSeriesToContentFactoryList(tvSeries);
        List<ContentFactory> contentFactories = new ArrayList<>();
        contentFactories.addAll(moviesContentFactory);
        contentFactories.addAll(tvSeriesContentFactory);


        return contentFactories;
    }

    @Transactional(readOnly = true)
    public List<ContentFactory> findAllContentByLanguage(String language) {
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

        List<ContentFactory> moviesContentFactory = contentFactory.moviesToContentFactoryList(movies);
        List<ContentFactory> tvSeriesContentFactory = contentFactory.tvSeriesToContentFactoryList(tvSeries);
        List<ContentFactory> contentFactories = new ArrayList<>();
        contentFactories.addAll(moviesContentFactory);
        contentFactories.addAll(tvSeriesContentFactory);


        return contentFactories;
    }
    @Transactional(readOnly = true)
    public List<ContentFactory> findAllContentByYear(String year) {
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

        List<ContentFactory> moviesContentFactory = contentFactory.moviesToContentFactoryList(movies);
        List<ContentFactory> tvSeriesContentFactory = contentFactory.tvSeriesToContentFactoryList(tvSeries);
        List<ContentFactory> contentFactories = new ArrayList<>();
        contentFactories.addAll(moviesContentFactory);
        contentFactories.addAll(tvSeriesContentFactory);


        return contentFactories;
    }

    @Transactional (readOnly = true)
    public List<ContentFactory> findTop10HighestRatedContent() {

        List<Rating> ratings = ratingRepository.findContent10HighestRated();
        List<Long> contentIds = new ArrayList<>();

        for (Rating rating: ratings){
            contentIds.add(rating.getContent().getId());
        }

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

        List<ContentFactory> moviesContentFactory = contentFactory.moviesToContentFactoryList(movies);
        List<ContentFactory> tvSeriesContentFactory = contentFactory.tvSeriesToContentFactoryList(tvSeries);



        List<ContentFactory> contentFactories = new ArrayList<>();
        contentFactories.addAll(moviesContentFactory);
        contentFactories.addAll(tvSeriesContentFactory);

        Collections.sort(contentFactories, new Comparator<ContentFactory>() {
            public int compare(ContentFactory cf1, ContentFactory cf2) {

                int result = Float.compare(cf2.getRating(), cf1.getRating());
                return result;
            }
        });


        return contentFactories;
    }


    @Transactional
    public void addContent(ContentFactory contentFactory) {

        if(contentFactory.getContent().getContentType().equals(ContentType.TV_SERIES)){
            TVSeries tvSerie = ContentFactory.toTVSeries(contentFactory);
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
        else if(contentFactory.getContent().getContentType().equals(ContentType.MOVIE)){
            Movie movie = ContentFactory.toMovie(contentFactory);
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

    @Transactional
    public void addContents(ContentFactory[] contentFactories) {
        for(ContentFactory contentFactory : contentFactories){
            if(contentFactory.getContent().getContentType().equals(ContentType.TV_SERIES)){
                TVSeries tvSerie = ContentFactory.toTVSeries(contentFactory);
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
            else if(contentFactory.getContent().getContentType().equals(ContentType.MOVIE)){
                Movie movie = ContentFactory.toMovie(contentFactory);
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
    }

    @Transactional
    public void deleteContentById(Long id) {
        boolean exists = contentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Content does not exist");
        }
        else{
            Optional<Content> content = contentRepository.findById(id);
            if(content.get().getContentType().equals(ContentType.MOVIE)){
                Optional<Movie> movie = movieRepository.findMovieByContentId(id);
                if(!movie.isPresent()){
                    throw new IllegalStateException("Movie does not exist");
                }
                else{
                    movieRepository.deleteById(movie.get().getId());
                }

            }
            else if(content.get().getContentType().equals(ContentType.TV_SERIES)){
                Optional<TVSeries> tvSeries = tVSeriesRepository.findTVSeriesByContentId(id);
                if(!tvSeries.isPresent()){
                    throw new IllegalStateException("TV Series does not exist");
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
    public void deleteContentsByIds(Long[] ids) {
        for (Long id : ids){
            boolean exists = contentRepository.existsById(id);
            if(!exists){
                throw new IllegalStateException("Content does not exist");
            }
            else{
                Optional<Content> content = contentRepository.findById(id);
                if(content.get().getContentType().equals(ContentType.MOVIE)){
                    Optional<Movie> movie = movieRepository.findMovieByContentId(id);
                    if(!movie.isPresent()){
                        throw new IllegalStateException("Movie does not exist");
                    }
                    else{
                        movieRepository.deleteById(movie.get().getId());
                    }

                }
                else if(content.get().getContentType().equals(ContentType.TV_SERIES)){
                    Optional<TVSeries> tvSeries = tVSeriesRepository.findTVSeriesByContentId(id);
                    if(!tvSeries.isPresent()){
                        throw new IllegalStateException("TV Series does not exist");
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
    public void updateContentById(Content content, Long id) {
        Optional<Content> contentFound = contentRepository.findById(id);
        if(!contentFound.isPresent()){
            throw new IllegalStateException("Content does not exist");
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
    public void updateContentByIdAlternative(ContentFactory contentFactory, Long id) {
        Optional<Content> contentFound = contentRepository.findById(id);
        if(!contentFound.isPresent()){
            throw new IllegalStateException("Content does not exist");
        }
        else {


            if (contentFactory.getContent().getDescription() != null && contentFactory.getContent().getDescription().length() > 0 &&
                    !Objects.equals(contentFound.get().getDescription(), contentFactory.getContent().getDescription())) {
                contentFound.get().setDescription(contentFactory.getContent().getDescription());
            }

            if (contentFactory.getContent().getImageUrl() != null && contentFactory.getContent().getImageUrl().length() > 0 &&
                    !Objects.equals(contentFound.get().getImageUrl(), contentFactory.getContent().getImageUrl())) {
                contentFound.get().setImageUrl(contentFactory.getContent().getImageUrl());
            }

            if (contentFactory.getContent().getContentType() != null && (contentFactory.getContent().getContentType().equals(ContentType.MOVIE) ||
                    contentFactory.getContent().getContentType().equals(ContentType.TV_SERIES)) &&
                    !Objects.equals(contentFound.get().getContentType(), contentFactory.getContent().getContentType())) {
                contentFound.get().setContentType(contentFactory.getContent().getContentType());
            }

            if (contentFactory.getContent().getIsAgeRestricted() != null &&
                    !Objects.equals(contentFound.get().getIsAgeRestricted(), contentFactory.getContent().getIsAgeRestricted())) {
                contentFound.get().setIsAgeRestricted(contentFactory.getContent().getIsAgeRestricted());
            }

            if (contentFactory.getContent().getReleaseDate() != null && contentFactory.getContent().getReleaseDate().length() > 0 &&
                    !Objects.equals(contentFound.get().getReleaseDate(), contentFactory.getContent().getReleaseDate())) {
                contentFound.get().setReleaseDate(contentFactory.getContent().getReleaseDate());
            }

            if (contentFactory.getContent().getRuntime() != null && contentFactory.getContent().getRuntime() > 0 &&
                    !Objects.equals(contentFound.get().getRuntime(), contentFactory.getContent().getRuntime())) {
                contentFound.get().setRuntime(contentFactory.getContent().getRuntime());
            }

            if (contentFactory.getContent().getSpokenLanguage() != null && contentFactory.getContent().getSpokenLanguage().length() > 0 &&
                    !Objects.equals(contentFound.get().getSpokenLanguage(), contentFactory.getContent().getSpokenLanguage())) {
                contentFound.get().setSpokenLanguage(contentFactory.getContent().getSpokenLanguage());
            }

            if (contentFactory.getContent().getTitle() != null && contentFactory.getContent().getTitle().length() > 0 &&
                    !Objects.equals(contentFound.get().getTitle(), contentFactory.getContent().getTitle())) {
                contentFound.get().setTitle(contentFactory.getContent().getTitle());
            }

            if (contentFactory.getContent().getTrailerUrl() != null && contentFactory.getContent().getTrailerUrl().length() > 0 &&
                    !Objects.equals(contentFound.get().getTrailerUrl(), contentFactory.getContent().getTrailerUrl())) {
                contentFound.get().setTrailerUrl(contentFactory.getContent().getTrailerUrl());
            }

            if (contentFactory.getContent().getGenres() != null &&
                    !Objects.equals(contentFound.get().getGenres(), contentFactory.getContent().getGenres())) {
                List<Genre> genres = genreRepository.findGenreByContentId(id);
                if (!genres.isEmpty()) {
                    for (int i = 0; i < genres.size(); i++) {
                        if (contentFactory.getContent().getGenres().get(i).getName() != null &&
                                contentFactory.getContent().getGenres().get(i).getName().length() >0 &&
                                !Objects.equals(genres.get(i).getName(), contentFactory.getContent().getGenres().get(i).getName())) {
                            genres.get(i).setName(contentFactory.getContent().getGenres().get(i).getName());
                        }

                    }
                }
            }

            if (contentFactory.getContent().getActors() != null &&
                    !Objects.equals(contentFound.get().getActors(), contentFactory.getContent().getActors())) {
                List<Actor> actors = actorRepository.findActorByContentId(id);
                if (!actors.isEmpty()) {
                    for (int i = 0; i < actors.size(); i++) {
                        if (contentFactory.getContent().getActors().get(i).getFullname() != null &&
                                contentFactory.getContent().getActors().get(i).getFullname().length() >0 &&
                                !Objects.equals(actors.get(i).getFullname(), contentFactory.getContent().getActors().get(i).getFullname())) {
                            actors.get(i).setFullname(contentFactory.getContent().getActors().get(i).getFullname());
                        }

                        if (contentFactory.getContent().getActors().get(i).getImageUrl() != null &&
                                contentFactory.getContent().getActors().get(i).getImageUrl().length() >0 &&
                                !Objects.equals(actors.get(i).getImageUrl(), contentFactory.getContent().getActors().get(i).getImageUrl())) {
                            actors.get(i).setImageUrl(contentFactory.getContent().getActors().get(i).getImageUrl());
                        }

                    }
                }
            }


            if (contentFactory.getContent().getContentType().equals(ContentType.MOVIE)){
                Optional<Movie> movieFound = movieRepository.findMovieByContentId(id);
                if(!movieFound.isPresent()){
                    throw new IllegalStateException("Movie does not exist");
                }
                else{
                    if (contentFactory.getWriters() != null &&
                            !Objects.equals(movieFound.get().getWriters(), contentFactory.getWriters())) {

                        List<Writer> writers = writerRepository.findWriterByByMovieId(movieFound.get().getId());
                        if (!writers.isEmpty()) {
                            for (int i = 0; i < writers.size(); i++) {
                                if (contentFactory.getWriters().get(i).getFullname() != null &&
                                        contentFactory.getWriters().get(i).getFullname().length() >0 &&
                                        !Objects.equals(writers.get(i).getFullname(), contentFactory.getWriters().get(i).getFullname())) {
                                    writers.get(i).setFullname(contentFactory.getWriters().get(i).getFullname());
                                }

                                if (contentFactory.getWriters().get(i).getImageUrl() != null &&
                                        contentFactory.getWriters().get(i).getImageUrl().length() >0 &&
                                        !Objects.equals(writers.get(i).getImageUrl(), contentFactory.getWriters().get(i).getImageUrl())) {
                                    writers.get(i).setImageUrl(contentFactory.getWriters().get(i).getImageUrl());
                                }
                            }
                        }
                    }

                    if (contentFactory.getDirectors() != null &&
                            !Objects.equals(movieFound.get().getDirectors(), contentFactory.getDirectors())) {

                        List<Director> directors = directorRepository.findDirectorByByMovieId(movieFound.get().getId());
                        if (!directors.isEmpty()) {
                            for (int i = 0; i < directors.size(); i++) {
                                if (contentFactory.getDirectors().get(i).getFullname() != null &&
                                        contentFactory.getDirectors().get(i).getFullname().length() >0 &&
                                        !Objects.equals(directors.get(i).getFullname(), contentFactory.getDirectors().get(i).getFullname())) {
                                    directors.get(i).setFullname(contentFactory.getDirectors().get(i).getFullname());
                                }

                                if (contentFactory.getDirectors().get(i).getImageUrl() != null &&
                                        contentFactory.getDirectors().get(i).getImageUrl().length() >0 &&
                                        !Objects.equals(directors.get(i).getImageUrl(), contentFactory.getDirectors().get(i).getImageUrl())) {
                                    directors.get(i).setFullname(contentFactory.getDirectors().get(i).getImageUrl());
                                }

                            }
                        }
                    }
                }

            }
            else if (contentFactory.getContent().getContentType().equals(ContentType.TV_SERIES)){
                Optional<TVSeries> tvSeriesFound = tVSeriesRepository.findTVSeriesByContentId(id);
                if(!tvSeriesFound.isPresent()){
                    throw new IllegalStateException("TV Series does not exist");
                }
                else{
                    if (contentFactory.getTvSeriesStatusType() != null &&
                            (contentFactory.getTvSeriesStatusType().equals(TVSeriesStatusType.UKNOWN) ||
                                    contentFactory.getTvSeriesStatusType().equals(TVSeriesStatusType.ONGOING) ||
                                    contentFactory.getTvSeriesStatusType().equals(TVSeriesStatusType.COMPLETED))&&
                            !Objects.equals(tvSeriesFound.get().getTvSeriesStatusType(), contentFactory.getTvSeriesStatusType())) {
                        tvSeriesFound.get().setTvSeriesStatusType(contentFactory.getTvSeriesStatusType());
                    }

                    if (contentFactory.getCreators() != null &&
                            !Objects.equals(tvSeriesFound.get().getCreators(), contentFactory.getCreators())) {
                        List<Creator> creators = creatorRepository.findCreatorByByTVSeriesId(tvSeriesFound.get().getId());
                        if (!creators.isEmpty()) {
                            for (int i = 0; i < creators.size(); i++) {
                                if (contentFactory.getCreators().get(i).getFullname() != null &&
                                        contentFactory.getCreators().get(i).getFullname().length() >0 &&
                                        !Objects.equals(creators.get(i).getFullname(), contentFactory.getCreators().get(i).getFullname())) {
                                    creators.get(i).setFullname(contentFactory.getCreators().get(i).getFullname());
                                }

                                if (contentFactory.getCreators().get(i).getImageUrl() != null &&
                                        contentFactory.getCreators().get(i).getImageUrl().length() >0 &&
                                        !Objects.equals(creators.get(i).getImageUrl(), contentFactory.getCreators().get(i).getImageUrl())) {
                                    creators.get(i).setImageUrl(contentFactory.getCreators().get(i).getImageUrl());
                                }


                            }
                        }
                    }


                    if (contentFactory.getSeasons() != null &&
                            !Objects.equals(tvSeriesFound.get().getSeasons(), contentFactory.getSeasons())) {
                        List<Season> seasons = seasonRepository.findSeasonByTVSeriesId(tvSeriesFound.get().getId());
                        if (!seasons.isEmpty()) {
                            for (int i = 0; i < seasons.size(); i++) {
                                if (contentFactory.getSeasons().get(i).getSeasonNo() != null &&
                                        contentFactory.getSeasons().get(i).getSeasonNo() >0 &&
                                        !Objects.equals(seasons.get(i).getSeasonNo(), contentFactory.getSeasons().get(i).getSeasonNo())) {
                                    seasons.get(i).setSeasonNo(contentFactory.getSeasons().get(i).getSeasonNo());
                                }

                                if (contentFactory.getSeasons().get(i).getEpisodes() != null &&
                                        !Objects.equals(seasons.get(i).getEpisodes(), contentFactory.getSeasons().get(i).getEpisodes())) {
                                    List<Episode> episodes = episodeRepository.findEpisodeBySeasonId(seasons.get(i).getId());

                                    for (int y = 0; y < episodes.size(); y++) {
                                        if (contentFactory.getSeasons().get(i).getEpisodes().get(y).getTitle() != null &&
                                                contentFactory.getSeasons().get(i).getEpisodes().get(y).getTitle().length() > 0 &&
                                                !Objects.equals(episodes.get(i).getTitle(), contentFactory.getSeasons().get(i).getEpisodes().get(y).getTitle())) {
                                            episodes.get(y).setTitle(contentFactory.getSeasons().get(i).getEpisodes().get(y).getTitle());
                                        }

                                        if (contentFactory.getSeasons().get(i).getEpisodes().get(y).getDescription() != null &&
                                                contentFactory.getSeasons().get(i).getEpisodes().get(y).getDescription().length() > 0 &&
                                                !Objects.equals(episodes.get(i).getDescription(), contentFactory.getSeasons().get(i).getEpisodes().get(y).getDescription())) {
                                            episodes.get(y).setDescription(contentFactory.getSeasons().get(i).getEpisodes().get(y).getDescription());
                                        }

                                        if (contentFactory.getSeasons().get(i).getEpisodes().get(y).getReleaseDate() != null &&
                                                contentFactory.getSeasons().get(i).getEpisodes().get(y).getReleaseDate().length() > 0 &&
                                                !Objects.equals(episodes.get(i).getReleaseDate(), contentFactory.getSeasons().get(i).getEpisodes().get(y).getReleaseDate())) {
                                            episodes.get(y).setReleaseDate(contentFactory.getSeasons().get(i).getEpisodes().get(y).getReleaseDate());
                                        }

                                        if (contentFactory.getSeasons().get(i).getEpisodes().get(y).getImageUrl() != null &&
                                                contentFactory.getSeasons().get(i).getEpisodes().get(y).getImageUrl().length() > 0 &&
                                                !Objects.equals(episodes.get(i).getImageUrl(), contentFactory.getSeasons().get(i).getEpisodes().get(y).getImageUrl())) {
                                            episodes.get(y).setImageUrl(contentFactory.getSeasons().get(i).getEpisodes().get(y).getImageUrl());
                                        }

                                        if (contentFactory.getSeasons().get(i).getEpisodes().get(y).getEpisodeNo() != null &&
                                                contentFactory.getSeasons().get(i).getEpisodes().get(y).getEpisodeNo() > 0 &&
                                                !Objects.equals(episodes.get(i).getEpisodeNo(), contentFactory.getSeasons().get(i).getEpisodes().get(y).getEpisodeNo())) {
                                            episodes.get(y).setEpisodeNo(contentFactory.getSeasons().get(i).getEpisodes().get(y).getEpisodeNo());
                                        }

                                    }

                                }

                            }
                        }
                    }


                }
            }
            else{

            }
        }
    }


}
