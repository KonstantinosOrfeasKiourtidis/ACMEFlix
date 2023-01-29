package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Movie> findMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @Transactional
    public Movie addMovie(Movie movie) {
        movie.getDirectors()
                .forEach(d -> d.setMovie(movie));
        movie.getWriters()
                .forEach(w -> w.setMovie(movie));

        movie.getActors()
                .forEach(a -> a.setContent(movie));
        movie.getGenres()
                .forEach(g -> g.setContent(movie));

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

            movie.getActors()
                    .forEach(a -> a.setContent(movie));
            movie.getGenres()
                    .forEach(g -> g.setContent(movie));

            movieRepository.save(movie);
        }
        return movies;
    }

    @Transactional
    public void deleteMovieById(Long id) {
        boolean exists = movieRepository.existsById(id);
        if(!exists){
            throw new NoSuchElementException("Movie does not exist");
        }
        else{
            movieRepository.deleteById(id);
        }
    }
    @Transactional
    public void deleteMoviesByIds(List<Long> ids) {
        for (Long id : ids){
            boolean exists = movieRepository.existsById(id);
            if(!exists){
                throw new NoSuchElementException("Movie does not exist");
            }
            else{
                movieRepository.deleteById(id);
            }
        }
    }

    @Transactional
    public void updateMovieById(Long id, Movie movie) {
        Optional<Movie> movieFound = movieRepository.findById(id);
        if(!movieFound.isPresent()){
            throw new NoSuchElementException("Movie does not exist");
        }
        else{

            if (movie.getTitle() != null &&
                    movie.getTitle().length() >0 &&
                    !Objects.equals(movieFound.get().getTitle(), movie.getTitle())) {
                movieFound.get().setTitle(movie.getTitle());
            }

            if (movie.getDescription() != null &&
                    movie.getDescription().length() >0 &&
                    !Objects.equals(movieFound.get().getDescription(), movie.getDescription())) {
                movieFound.get().setDescription(movie.getDescription());
            }

            if (movie.getContentType() != null &&
                    (movie.getContentType().equals(ContentType.MOVIE) ||
                            movie.getContentType().equals(ContentType.TV_SERIES))&&
                    !Objects.equals(movieFound.get().getContentType(), movie.getContentType())) {
                movieFound.get().setContentType(movie.getContentType());
            }

            if (movie.getRuntime() != null &&
                    movie.getRuntime() >0 &&
                    !Objects.equals(movieFound.get().getRuntime(), movie.getRuntime())) {
                movieFound.get().setRuntime(movie.getRuntime());
            }

            if (movie.getReleaseDate() != null &&
                    movie.getReleaseDate().length() >0 &&
                    !Objects.equals(movieFound.get().getReleaseDate(), movie.getReleaseDate())) {
                movieFound.get().setReleaseDate(movie.getReleaseDate());
            }

            if (movie.getTrailerUrl() != null &&
                    movie.getTrailerUrl().length() >0 &&
                    !Objects.equals(movieFound.get().getTrailerUrl(), movie.getTrailerUrl())) {
                movieFound.get().setTrailerUrl(movie.getTrailerUrl());
            }

            if (movie.getImageUrl() != null &&
                    movie.getImageUrl().length() >0 &&
                    !Objects.equals(movieFound.get().getImageUrl(), movie.getImageUrl())) {
                movieFound.get().setImageUrl(movie.getImageUrl());
            }

            if (movie.getSpokenLanguage() != null &&
                    movie.getSpokenLanguage().length() >0 &&
                    !Objects.equals(movieFound.get().getSpokenLanguage(), movie.getSpokenLanguage())) {
                movieFound.get().setSpokenLanguage(movie.getSpokenLanguage());
            }

            if (movie.getIsAgeRestricted() != null &&
                    !Objects.equals(movieFound.get().getIsAgeRestricted(), movie.getIsAgeRestricted())) {movieFound.get().setIsAgeRestricted(movie.getIsAgeRestricted());
            }


            if (movie.getActors() != null &&
                    !Objects.equals(movieFound.get().getActors(), movie.getActors())) {
                List<Actor> actors = movieFound.get().getActors();
                if (!actors.isEmpty()) {
                    for (int i = 0; i < actors.size(); i++) {
                        if (movie.getActors().get(i).getFullname() != null &&
                                movie.getActors().get(i).getFullname().length() >0 &&
                                !Objects.equals(actors.get(i).getFullname(), movie.getActors().get(i).getFullname())) {
                            actors.get(i).setFullname(movie.getActors().get(i).getFullname());
                        }

                        if (movie.getActors().get(i).getImageUrl() != null &&
                                movie.getActors().get(i).getImageUrl().length() >0 &&
                                !Objects.equals(actors.get(i).getImageUrl(), movie.getActors().get(i).getImageUrl())) {
                            actors.get(i).setImageUrl(movie.getActors().get(i).getImageUrl());
                        }
                    }
                }
            }

            if (movie.getGenres() != null &&
                    !Objects.equals(movieFound.get().getGenres(), movie.getGenres())) {
                List<Genre> genres = movieFound.get().getGenres();
                if (!genres.isEmpty()) {
                    for (int i = 0; i < genres.size(); i++) {
                        if (movie.getGenres().get(i).getName() != null &&
                                movie.getGenres().get(i).getName().length() >0 &&
                                !Objects.equals(genres.get(i).getName(), movie.getGenres().get(i).getName())) {
                            genres.get(i).setName(movie.getGenres().get(i).getName());
                        }

                    }
                }

            }


            if (movie.getWriters() != null &&
                    !Objects.equals(movieFound.get().getWriters(), movie.getWriters())) {
                List<Writer> writers = movieFound.get().getWriters();
                if (!writers.isEmpty()) {



                    for (int i = 0; i < writers.size(); i++) {

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
