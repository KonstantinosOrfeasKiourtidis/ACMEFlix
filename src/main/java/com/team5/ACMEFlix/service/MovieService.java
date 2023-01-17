package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.*;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private EntityManager entityManager;
    @Transactional(readOnly = true)
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Movie> findMovieById(Long id) {
        return movieRepository.findById(id);
    }
    public Optional<Movie> findMovieByContentId(Long id) {
        return movieRepository.findMovieByContentId(id);
    }

    @Transactional(readOnly = true)
    public List<Movie> findAllMoviesFamilyFriendly() {
        return movieRepository.findMoviesByFamilyFriendly();
    }

    @Transactional(readOnly = true)
    public List<Movie> findAllMoviesByTitle(String search) {
        return movieRepository.findMoviesByName(search);
    }

    @Transactional(readOnly = true)
    public List<Movie> findAllMoviesByDirectors(String[] director) {
        String query;
        query = "SELECT DIRECTORS.MOVIE_ID FROM DIRECTORS GROUP BY DIRECTORS.MOVIE_ID ";

        for (int i = 0; i < director.length; i++) {
            if(i == 0){
                query += "HAVING ";
            }

            query+= "GROUP_CONCAT(DIRECTORS.FULLNAME) LIKE '%"+ director[i] + "%'";
            if(i != director.length-1){
                query += " AND ";
            }
        }

        List<BigInteger> movieIds = entityManager.createNativeQuery(query).getResultList();

        List<Movie> movies = movieRepository.findAllMoviesById(movieIds);

        return movies;
    }
    @Transactional(readOnly = true)
    public List<Movie> findAllMoviesByWriters(String[] writer) {
        String query;
        query = "SELECT WRITERS.MOVIE_ID FROM WRITERS GROUP BY WRITERS.MOVIE_ID ";

        for (int i = 0; i < writer.length; i++) {
            if(i == 0){
                query += "HAVING ";
            }

            query+= "GROUP_CONCAT(WRITERS.FULLNAME) LIKE '%"+ writer[i] + "%'";
            if(i != writer.length-1){
                query += " AND ";
            }
        }

        List<BigInteger> movieIds = entityManager.createNativeQuery(query).getResultList();

        List<Movie> movies = movieRepository.findAllMoviesById(movieIds);

        return movies;
    }

    @Transactional
    public Movie addMovie(Movie movie) {
        movie.getDirectors()
                .forEach(d -> d.setMovie(movie));
        movie.getWriters()
                .forEach(w -> w.setMovie(movie));

        movie.getContent().getActors()
                .forEach(a -> a.setContent(movie.getContent()));
        movie.getContent().getGenres()
                .forEach(g -> g.setContent(movie.getContent()));

        movieRepository.save(movie);
        return movie;
    }

    @Transactional
    public List<Movie> addMovies(List<Movie> movies) {
        for(Movie movie : movies){
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
        return movies;
    }

    @Transactional
    public void updateMovieById(Long id, Movie movie) {
        Optional<Movie> movieFound = movieRepository.findById(id);
        if(!movieFound.isPresent()){
            throw new NoSuchElementException("Movie does not exist");
        }
        else{

            if (movie.getContent().getTitle() != null &&
                    movie.getContent().getTitle().length() >0 &&
                    !Objects.equals(movieFound.get().getContent().getTitle(), movie.getContent().getTitle())) {
                movieFound.get().getContent().setTitle(movie.getContent().getTitle());
            }

            if (movie.getContent().getDescription() != null &&
                    movie.getContent().getDescription().length() >0 &&
                    !Objects.equals(movieFound.get().getContent().getDescription(), movie.getContent().getDescription())) {
                movieFound.get().getContent().setDescription(movie.getContent().getDescription());
            }

            if (movie.getContent().getContentType() != null &&
                    (movie.getContent().getContentType().equals(ContentType.MOVIE) ||
                            movie.getContent().getContentType().equals(ContentType.TV_SERIES))&&
                    !Objects.equals(movieFound.get().getContent().getContentType(), movie.getContent().getContentType())) {
                movieFound.get().getContent().setContentType(movie.getContent().getContentType());
            }

            if (movie.getContent().getRuntime() != null &&
                    movie.getContent().getRuntime() >0 &&
                    !Objects.equals(movieFound.get().getContent().getRuntime(), movie.getContent().getRuntime())) {
                movieFound.get().getContent().setRuntime(movie.getContent().getRuntime());
            }

            if (movie.getContent().getReleaseDate() != null &&
                    movie.getContent().getReleaseDate().length() >0 &&
                    !Objects.equals(movieFound.get().getContent().getReleaseDate(), movie.getContent().getReleaseDate())) {
                movieFound.get().getContent().setReleaseDate(movie.getContent().getReleaseDate());
            }

            if (movie.getContent().getTrailerUrl() != null &&
                    movie.getContent().getTrailerUrl().length() >0 &&
                    !Objects.equals(movieFound.get().getContent().getTrailerUrl(), movie.getContent().getTrailerUrl())) {
                movieFound.get().getContent().setTrailerUrl(movie.getContent().getTrailerUrl());
            }

            if (movie.getContent().getImageUrl() != null &&
                    movie.getContent().getImageUrl().length() >0 &&
                    !Objects.equals(movieFound.get().getContent().getImageUrl(), movie.getContent().getImageUrl())) {
                movieFound.get().getContent().setImageUrl(movie.getContent().getImageUrl());
            }

            if (movie.getContent().getSpokenLanguage() != null &&
                    movie.getContent().getSpokenLanguage().length() >0 &&
                    !Objects.equals(movieFound.get().getContent().getSpokenLanguage(), movie.getContent().getSpokenLanguage())) {
                movieFound.get().getContent().setSpokenLanguage(movie.getContent().getSpokenLanguage());
            }

            if (movie.getContent().getIsAgeRestricted() != null &&
                    !Objects.equals(movieFound.get().getContent().getIsAgeRestricted(), movie.getContent().getIsAgeRestricted())) {movieFound.get().getContent().setIsAgeRestricted(movie.getContent().getIsAgeRestricted());
            }


            if (movie.getContent().getActors() != null &&
                    !Objects.equals(movieFound.get().getContent().getActors(), movie.getContent().getActors())) {
                List<Actor> actors = movieFound.get().getContent().getActors();
                if (!actors.isEmpty()) {
                    for (int i = 0; i < actors.size(); i++) {
                        if (movie.getContent().getActors().get(i).getFullname() != null &&
                                movie.getContent().getActors().get(i).getFullname().length() >0 &&
                                !Objects.equals(actors.get(i).getFullname(), movie.getContent().getActors().get(i).getFullname())) {
                            actors.get(i).setFullname(movie.getContent().getActors().get(i).getFullname());
                        }

                        if (movie.getContent().getActors().get(i).getImageUrl() != null &&
                                movie.getContent().getActors().get(i).getImageUrl().length() >0 &&
                                !Objects.equals(actors.get(i).getImageUrl(), movie.getContent().getActors().get(i).getImageUrl())) {
                            actors.get(i).setImageUrl(movie.getContent().getActors().get(i).getImageUrl());
                        }
                    }
                }
            }

            if (movie.getContent().getGenres() != null &&
                    !Objects.equals(movieFound.get().getContent().getGenres(), movie.getContent().getGenres())) {
                List<Genre> genres = movieFound.get().getContent().getGenres();
                if (!genres.isEmpty()) {
                    for (int i = 0; i < genres.size(); i++) {
                        if (movie.getContent().getGenres().get(i).getName() != null &&
                                movie.getContent().getGenres().get(i).getName().length() >0 &&
                                !Objects.equals(genres.get(i).getName(), movie.getContent().getGenres().get(i).getName())) {
                            genres.get(i).setName(movie.getContent().getGenres().get(i).getName());
                        }

                    }
                }

            }


            if (movie.getWriters() != null &&
                    !Objects.equals(movieFound.get().getWriters(), movie.getWriters())) {
                List<Writer> writers = movieFound.get().getWriters();
                if (!writers.isEmpty()) {



                    for (int i = 0; i < writers.size()-1; i++) {

                        if (movie.getWriters().get(i).getFullname() != null &&
                                movie.getWriters().get(i).getFullname().length() >0 &&
                                !Objects.equals(writers.get(i).getFullname(), movie.getWriters().get(i).getFullname())) {
                            writers.get(i).setFullname(movie.getWriters().get(i).getFullname());
                        }

                        if (movie.getWriters().get(i).getImageUrl() != null &&
                                movie.getWriters().get(i).getImageUrl().length() >0 &&
                                !Objects.equals(writers.get(i).getImageUrl(), movie.getWriters().get(i).getImageUrl())) {
                            writers.get(i).setImageUrl(movie.getWriters().get(i).getImageUrl());
                        }


                    }
                }

            }

            if (movie.getDirectors() != null &&
                    !Objects.equals(movieFound.get().getDirectors(), movie.getDirectors())) {
                List<Director> directors = movieFound.get().getDirectors();
                if (!directors.isEmpty()) {
                    for (int i = 0; i < directors.size(); i++) {
                        if (movie.getDirectors().get(i).getFullname() != null &&
                                movie.getDirectors().get(i).getFullname().length() >0 &&
                                !Objects.equals(directors.get(i).getFullname(), movie.getDirectors().get(i).getFullname())) {
                            directors.get(i).setFullname(movie.getDirectors().get(i).getFullname());
                        }

                        if (movie.getDirectors().get(i).getImageUrl() != null &&
                                movie.getDirectors().get(i).getImageUrl().length() >0 &&
                                !Objects.equals(directors.get(i).getImageUrl(), movie.getDirectors().get(i).getImageUrl())) {
                            directors.get(i).setImageUrl(movie.getDirectors().get(i).getImageUrl());
                        }

                    }
                }

            }

        }
    }
}
