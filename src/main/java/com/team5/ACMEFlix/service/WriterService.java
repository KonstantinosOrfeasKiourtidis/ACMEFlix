package com.team5.ACMEFlix.service;


import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Movie;
import com.team5.ACMEFlix.domain.Writer;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.repository.ContentRepository;
import com.team5.ACMEFlix.repository.MovieRepository;
import com.team5.ACMEFlix.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
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
    public Optional<Writer> findWriterById(Long id) {
        return writerRepository.findById(id);
    }
    @Transactional(readOnly = true)
    public List<Writer> findAllWritersByContentId(Long id) {
        Optional<Movie> movie = movieRepository.findMovieByContentId(id);
        if(!movie.isPresent()){
            throw new NoSuchElementException("Movie does not exist");
        }
        else {
            return writerRepository.findWritersByMovieId(movie.get().getId());
        }
    }

    @Transactional
    public Writer addWriterByContentId(Long id, Writer writer) {
        Optional<Content> contentExists = contentRepository.findById(id);
        if(!contentExists.isPresent()){
            throw new NoSuchElementException("Content does not exist");
        }
        else if(!contentExists.get().getContentType().equals(ContentType.MOVIE)){
            throw new IllegalStateException("Content is not a movie");
        }
        else{
            Optional<Movie> movieExists = movieRepository.findMovieByContentId(id);
            if(!movieExists.isPresent()){
                throw new NoSuchElementException("Movie does not exist");
            }
            else {
                writer.setMovie(movieExists.get());
                writerRepository.save(writer);
            }

        }
        return writer;
    }
    @Transactional
    public List<Writer> addWritersByContentId(Long id, List<Writer> writers) {

        Optional<Content> contentExists = contentRepository.findById(id);
        if(!contentExists.isPresent()){
            throw new NoSuchElementException("Content does not exist");
        }
        else if(!contentExists.get().getContentType().equals(ContentType.MOVIE)){
            throw new IllegalStateException("Content is not a movie");
        }
        else {
            Optional<Movie> movieExists = movieRepository.findMovieByContentId(id);
            if(!movieExists.isPresent()){
                throw new NoSuchElementException("Movie does not exist");
            } else {
                for (Writer writer : writers) {
                    writer.setMovie(movieExists.get());
                    writerRepository.save(writer);
                }

            }


        }
        return writers;
    }
    @Transactional
    public Writer addWriterByMovieId(Long id, Writer writer) {
        Optional<Movie> movieExists = movieRepository.findById(id);
        if(!movieExists.isPresent()){
            throw new NoSuchElementException("Movie does not exist");
        }
        else{
            writer.setMovie(movieExists.get());
            writerRepository.save(writer);
        }
        return writer;
    }
    @Transactional
    public List<Writer> addWritersByMovieId(Long id, List<Writer> writers) {
        Optional<Movie> movieExists = movieRepository.findById(id);
        if(!movieExists.isPresent()){
            throw new NoSuchElementException("Movie does not exist");
        }
        else{
            for (Writer writer : writers) {
                writer.setMovie(movieExists.get());
                writerRepository.save(writer);
            }
        }
        return writers;
    }

    @Transactional
    public void deleteWriterById(Long id) {
        boolean exists = writerRepository.existsById(id);
        if(!exists){
            throw new NoSuchElementException("Writer does not exist");
        }
        else{

            writerRepository.deleteById(id);

        }
    }
    @Transactional
    public void deleteWritersByIds(List<Long> ids) {
        for(Long id : ids){
            boolean exists = writerRepository.existsById(id);
            if(!exists){
                throw new NoSuchElementException("Writer does not exist");
            }
            else{

                writerRepository.deleteById(id);

            }
        }
    }

    @Transactional
    public void updateWriterById(Long id, Writer writer) {
        Optional<Writer> writerFound = writerRepository.findById(id);
        if(!writerFound.isPresent()){
            throw new NoSuchElementException("Writer does not exist");
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
