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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public ResponseEntity<Genre> findGenreById(Long id) {
        return genreRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Transactional(readOnly = true)
    public List<Genre> findAllGenresByContentId(Long id) {
        return genreRepository.findGenreByContentId(id);
    }

    @Transactional
    public void addGenreByContentId(Genre genre, Long id) {

        Optional<Content> contentExists = contentRepository.findById(id);
        if(!contentExists.isPresent()){
            throw new IllegalStateException("Content does not exist");
        }
        else{
            genre.setContent(contentExists.get());
            genreRepository.save(genre);
        }

    }

    @Transactional
    public void addGenresByContentId(Genre[] genres, Long id) {
        for(Genre genre : genres){
            Optional<Content> contentExists = contentRepository.findById(id);
            if(!contentExists.isPresent()){
                throw new IllegalStateException("Content does not exist");
            }
            else{
                genre.setContent(contentExists.get());
                genreRepository.save(genre);
            }
        }
    }

    @Transactional
    public void addGenreByMovieId(Genre genre, Long id) {

        Optional<Movie> movieExists = movieRepository.findById(id);
        if(!movieExists.isPresent()){
            throw new IllegalStateException("Movie does not exist");
        }
        else{
            genre.setContent(movieExists.get().getContent());
            genreRepository.save(genre);
        }

    }

    @Transactional
    public void addGenresByMovieId(Genre[] genres, Long id) {
        for(Genre genre : genres){
            Optional<Movie> movieExists = movieRepository.findById(id);
            if(!movieExists.isPresent()){
                throw new IllegalStateException("Movie does not exist");
            }
            else{
                genre.setContent(movieExists.get().getContent());
                genreRepository.save(genre);
            }
        }
    }

    @Transactional
    public void addGenreByTVSeriesId(Genre genre, Long id) {
        Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findById(id);
        if(!tvSeriesExists.isPresent()){
            throw new IllegalStateException("TV Series does not exist");
        }
        else{
            genre.setContent(tvSeriesExists.get().getContent());
            genreRepository.save(genre);
        }
    }

    @Transactional
    public void addGenresByTVSeriesId(Genre[] genres, Long id) {
        for(Genre genre : genres){
            Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findById(id);
            if(!tvSeriesExists.isPresent()){
                throw new IllegalStateException("TV Series does not exist");
            }
            else{
                genre.setContent(tvSeriesExists.get().getContent());
                genreRepository.save(genre);
            }
        }
    }

    @Transactional
    public void deleteGenreById(Long id) {
        boolean exists = genreRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Genre does not exist");
        }
        else{

            genreRepository.deleteById(id);

        }
    }
    @Transactional
    public void deleteGenresByIds(Long[] ids) {
        for(Long id : ids){
            boolean exists = genreRepository.existsById(id);
            if(!exists){
                throw new IllegalStateException("Genre does not exist");
            }
            else{

                genreRepository.deleteById(id);

            }
        }
    }

    @Transactional
    public void updateGenreById(Genre genre, Long id) {
        Optional<Genre> genreFound = genreRepository.findById(id);
        if(!genreFound.isPresent()){
            throw new IllegalStateException("Genre does not exist");
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
