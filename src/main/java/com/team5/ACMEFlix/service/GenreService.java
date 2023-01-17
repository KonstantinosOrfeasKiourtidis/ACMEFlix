package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Genre;
import com.team5.ACMEFlix.domain.Movie;
import com.team5.ACMEFlix.domain.TVSeries;
import com.team5.ACMEFlix.repository.ContentRepository;
import com.team5.ACMEFlix.repository.GenreRepository;
import com.team5.ACMEFlix.repository.MovieRepository;
import com.team5.ACMEFlix.repository.TVSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TVSeriesRepository tVSeriesRepository;

    @Transactional(readOnly = true)
    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Genre> findGenreById(Long id) {
        return genreRepository.findById(id);
    }
    @Transactional(readOnly = true)
    public List<Genre> findAllGenresByContentId(Long id) {
        return genreRepository.findGenreByContentId(id);
    }

    @Transactional
    public Genre addGenreByContentId(Long id, Genre genre) {

        Optional<Content> contentExists = contentRepository.findById(id);
        if(!contentExists.isPresent()){
            throw new NoSuchElementException("Content does not exist");
        }
        else{
            genre.setContent(contentExists.get());
            genreRepository.save(genre);
        }
        return genre;
    }

    @Transactional
    public List<Genre> addGenresByContentId(Long id, List<Genre> genres) {
        for(Genre genre : genres){
            Optional<Content> contentExists = contentRepository.findById(id);
            if(!contentExists.isPresent()){
                throw new NoSuchElementException("Content does not exist");
            }
            else{
                genre.setContent(contentExists.get());
                genreRepository.save(genre);
            }
        }
        return genres;
    }

    @Transactional
    public Genre addGenreByMovieId(Long id, Genre genre) {

        Optional<Movie> movieExists = movieRepository.findById(id);
        if(!movieExists.isPresent()){
            throw new NoSuchElementException("Movie does not exist");
        }
        else{
            genre.setContent(movieExists.get().getContent());
            genreRepository.save(genre);
        }
        return genre;
    }

    @Transactional
    public List<Genre> addGenresByMovieId(Long id, List<Genre> genres) {
        for(Genre genre : genres){
            Optional<Movie> movieExists = movieRepository.findById(id);
            if(!movieExists.isPresent()){
                throw new NoSuchElementException("Movie does not exist");
            }
            else{
                genre.setContent(movieExists.get().getContent());
                genreRepository.save(genre);
            }
        }
        return genres;
    }

    @Transactional
    public Genre addGenreByTVSeriesId(Long id, Genre genre) {
        Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findById(id);
        if(!tvSeriesExists.isPresent()){
            throw new NoSuchElementException("TV Series does not exist");
        }
        else{
            genre.setContent(tvSeriesExists.get().getContent());
            genreRepository.save(genre);
        }
        return genre;
    }

    @Transactional
    public List<Genre> addGenresByTVSeriesId(Long id, List<Genre> genres) {
        for(Genre genre : genres){
            Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findById(id);
            if(!tvSeriesExists.isPresent()){
                throw new NoSuchElementException("TV Series does not exist");
            }
            else{
                genre.setContent(tvSeriesExists.get().getContent());
                genreRepository.save(genre);
            }
        }
        return genres;
    }

    @Transactional
    public void deleteGenreById(Long id) {
        boolean exists = genreRepository.existsById(id);
        if(!exists){
            throw new NoSuchElementException("Genre does not exist");
        }
        else{

            genreRepository.deleteById(id);

        }
    }
    @Transactional
    public void deleteGenresByIds(List<Long> ids) {
        for(Long id : ids){
            boolean exists = genreRepository.existsById(id);
            if(!exists){
                throw new NoSuchElementException("Genre does not exist");
            }
            else{

                genreRepository.deleteById(id);

            }
        }
    }

    @Transactional
    public void updateGenreById(Long id, Genre genre) {
        Optional<Genre> genreFound = genreRepository.findById(id);
        if(!genreFound.isPresent()){
            throw new NoSuchElementException("Genre does not exist");
        }
        else{
            if(genre.getName() !=null &&
                    genre.getName().length() > 0 &&
                    !Objects.equals(genreFound.get().getName(), genre.getName())){
                genreFound.get().setName(genre.getName());
            }
        }
    }

}
