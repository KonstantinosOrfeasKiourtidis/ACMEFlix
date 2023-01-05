package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Director;
import com.team5.ACMEFlix.domain.Movie;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.repository.ContentRepository;
import com.team5.ACMEFlix.repository.DirectorRepository;
import com.team5.ACMEFlix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public List<Director> findAllDirectors() {
        return directorRepository.findAll();
    }
    @Transactional(readOnly = true)
    public ResponseEntity<Director> findDirectorById(Long id) {
        return directorRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Transactional(readOnly = true)
    public List<Director> findAllDirectorsByContentId(Long id) {
        Optional<Movie> movie = movieRepository.findMovieByContentId(id);
        if(!movie.isPresent()){
            throw new IllegalStateException("Movie does not exist");
        }
        else {
            return directorRepository.findDirectorByByMovieId(movie.get().getId());
        }
    }
    @Transactional
    public void addDirectorByContentId(Director director, Long id) {
        Optional<Content> contentExists = contentRepository.findById(id);
        if(!contentExists.isPresent()){
            throw new IllegalStateException("Content does not exist");
        }
        else if(!contentExists.get().getContentType().equals(ContentType.MOVIE)){
            throw new IllegalStateException("Content is not a movie");
        }
        else{
            Optional<Movie> movieExists = movieRepository.findMovieByContentId(id);
            if(!movieExists.isPresent()){
                throw new IllegalStateException("Movie does not exist");
            }
            else {
                director.setMovie(movieExists.get());
                directorRepository.save(director);
            }

        }
    }
    @Transactional
    public void addDirectosrByContentId(Director[] directors, Long id) {
        Optional<Content> contentExists = contentRepository.findById(id);
        if(!contentExists.isPresent()){
            throw new IllegalStateException("Content does not exist");
        }
        else if(!contentExists.get().getContentType().equals(ContentType.MOVIE)){
            throw new IllegalStateException("Content is not a movie");
        }
        else {
            Optional<Movie> movieExists = movieRepository.findMovieByContentId(id);
            if(!movieExists.isPresent()){
                throw new IllegalStateException("Movie does not exist");
            } else {
                for (Director director : directors) {
                    director.setMovie(movieExists.get());
                    directorRepository.save(director);
                }

            }


        }
    }
    @Transactional
    public void addDirectorByMovieId(Director director, Long id) {
        Optional<Movie> movieExists = movieRepository.findById(id);
        if(!movieExists.isPresent()){
            throw new IllegalStateException("Movie does not exist");
        }
        else{
            director.setMovie(movieExists.get());
            directorRepository.save(director);
        }
    }
    @Transactional
    public void addDirectorsByMovieId(Director[] directors, Long id) {
        Optional<Movie> movieExists = movieRepository.findById(id);
        if(!movieExists.isPresent()){
            throw new IllegalStateException("Movie does not exist");
        }
        else{
            for (Director director : directors) {
                director.setMovie(movieExists.get());
                directorRepository.save(director);
            }
        }
    }

    @Transactional
    public void deleteDirectorById(Long id) {
        boolean exists = directorRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Director does not exist");
        }
        else{

            directorRepository.deleteById(id);

        }
    }
    @Transactional
    public void deleteDirectorsByIds(Long[] ids) {
        for(Long id : ids){
            boolean exists = directorRepository.existsById(id);
            if(!exists){
                throw new IllegalStateException("Director does not exist");
            }
            else{

                directorRepository.deleteById(id);

            }
        }
    }

    @Transactional
    public void updateDirectorById(Director director, Long id) {
        Optional<Director> directorFound = directorRepository.findById(id);
        if(!directorFound.isPresent()){
            throw new IllegalStateException("Director does not exist");
        }
        else{
            if(director.getFullname() !=null &&
                    director.getFullname().length() > 0 &&
                    !Objects.equals(directorFound.get().getFullname(), director.getFullname())){
                directorFound.get().setFullname(director.getFullname());
            }

            if(director.getImageUrl() !=null &&
                    director.getImageUrl().length() > 0 &&
                    !Objects.equals(directorFound.get().getImageUrl(), director.getImageUrl())){
                directorFound.get().setImageUrl(director.getImageUrl());
            }
        }
    }
}
