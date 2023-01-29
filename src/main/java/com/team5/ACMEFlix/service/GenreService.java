package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Genre;
import com.team5.ACMEFlix.repository.ContentRepository;
import com.team5.ACMEFlix.repository.GenreRepository;
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
