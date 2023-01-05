package com.team5.ACMEFlix.service;


import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Movie;
import com.team5.ACMEFlix.domain.Writer;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.repository.ContentRepository;
import com.team5.ACMEFlix.repository.MovieRepository;
import com.team5.ACMEFlix.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class WriterService {
    @Autowired
    private WriterRepository writerRepository;
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public List<Writer> findAllWriters() {
        return writerRepository.findAll();
    }
    @Transactional(readOnly = true)
    public ResponseEntity<Writer> findWriterById(Long id) {
        return writerRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Transactional(readOnly = true)
    public List<Writer> findAllWritersByContentId(Long id) {
        Optional<Movie> movie = movieRepository.findMovieByContentId(id);
        if(!movie.isPresent()){
            throw new IllegalStateException("Movie does not exist");
        }
        else {
            return writerRepository.findWriterByByMovieId(movie.get().getId());
        }
    }

    @Transactional
    public void addWriterByContentId(Writer writer, Long id) {
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
                writer.setMovie(movieExists.get());
                writerRepository.save(writer);
            }

        }
    }
    @Transactional
    public void addWritersByContentId(Writer[] writers, Long id) {

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
                for (Writer writer : writers) {
                    writer.setMovie(movieExists.get());
                    writerRepository.save(writer);
                }

            }


        }
    }
    @Transactional
    public void addWriterByMovieId(Writer writer, Long id) {
        Optional<Movie> movieExists = movieRepository.findById(id);
        if(!movieExists.isPresent()){
            throw new IllegalStateException("Movie does not exist");
        }
        else{
            writer.setMovie(movieExists.get());
            writerRepository.save(writer);
        }
    }
    @Transactional
    public void addWritersByMovieId(Writer[] writers, Long id) {
        Optional<Movie> movieExists = movieRepository.findById(id);
        if(!movieExists.isPresent()){
            throw new IllegalStateException("Movie does not exist");
        }
        else{
            for (Writer writer : writers) {
                writer.setMovie(movieExists.get());
                writerRepository.save(writer);
            }
        }

    }

    @Transactional
    public void deleteWriterById(Long id) {
        boolean exists = writerRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Writer does not exist");
        }
        else{

            writerRepository.deleteById(id);

        }
    }
    @Transactional
    public void deleteWritersByIds(Long[] ids) {
        for(Long id : ids){
            boolean exists = writerRepository.existsById(id);
            if(!exists){
                throw new IllegalStateException("Writer does not exist");
            }
            else{

                writerRepository.deleteById(id);

            }
        }
    }

    @Transactional
    public void updateWriterById(Writer writer, Long id) {
        Optional<Writer> writerFound = writerRepository.findById(id);
        if(!writerFound.isPresent()){
            throw new IllegalStateException("Writer does not exist");
        }
        else{
            if(writer.getFullname() !=null &&
                    writer.getFullname().length() > 0 &&
                    !Objects.equals(writerFound.get().getFullname(), writer.getFullname())){
                writerFound.get().setFullname(writer.getFullname());
            }

            if(writer.getImageUrl() !=null &&
                    writer.getImageUrl().length() > 0 &&
                    !Objects.equals(writerFound.get().getImageUrl(), writer.getImageUrl())){
                writerFound.get().setImageUrl(writer.getImageUrl());
            }
        }
    }

}
