package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.Actor;
import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Movie;
import com.team5.ACMEFlix.domain.TVSeries;
import com.team5.ACMEFlix.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TVSeriesRepository tVSeriesRepository;

    @Transactional(readOnly = true)
    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }
    @Transactional(readOnly = true)
    public ResponseEntity<Actor> findActorById(Long id) {
        return actorRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Transactional
    public List<Actor> findAllActorsByContentId(Long id) {
        return actorRepository.findActorByContentId(id);
    }

    @Transactional(readOnly = true)
    public void addActorByContentId(Actor actor, Long id) {
        Optional<Content> contentExists = contentRepository.findById(id);
        if(!contentExists.isPresent()){
            throw new IllegalStateException("Content does not exist");
        }
        else{
            actor.setContent(contentExists.get());
            actorRepository.save(actor);
        }
    }
    @Transactional
    public void addActorsByContentId(Actor[] actors, Long id) {
        for(Actor actor : actors){
            Optional<Content> contentExists = contentRepository.findById(id);
            if(!contentExists.isPresent()){
                throw new IllegalStateException("Content does not exist");
            }
            else{
                actor.setContent(contentExists.get());
                actorRepository.save(actor);
            }
        }
    }
    @Transactional
    public void addActorByMovieId(Actor actor, Long id) {
        Optional<Movie> movieExists = movieRepository.findById(id);
        if(!movieExists.isPresent()){
            throw new IllegalStateException("Movie does not exist");
        }
        else{
            actor.setContent(movieExists.get().getContent());
            actorRepository.save(actor);
        }
    }

    @Transactional
    public void addActorsByMovieId(Actor[] actors, Long id) {
        for(Actor actor : actors){
            Optional<Movie> movieExists = movieRepository.findById(id);
            if(!movieExists.isPresent()){
                throw new IllegalStateException("Movie does not exist");
            }
            else{
                actor.setContent(movieExists.get().getContent());
                actorRepository.save(actor);
            }
        }
    }

    @Transactional
    public void addActorByTVSeriesId(Actor actor, Long id) {
        Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findById(id);
        if(!tvSeriesExists.isPresent()){
            throw new IllegalStateException("TV Series does not exist");
        }
        else{
            actor.setContent(tvSeriesExists.get().getContent());
            actorRepository.save(actor);
        }
    }

    @Transactional
    public void addActorsByTVSeriesId(Actor[] actors, Long id) {
        for(Actor actor : actors){
            Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findById(id);
            if(!tvSeriesExists.isPresent()){
                throw new IllegalStateException("TV Series does not exist");
            }
            else{
                actor.setContent(tvSeriesExists.get().getContent());
                actorRepository.save(actor);
            }
        }
    }

    @Transactional
    public void deleteActorById(Long id) {
        boolean exists = actorRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Actor does not exist");
        }
        else{

            actorRepository.deleteById(id);

        }
    }
    @Transactional
    public void deleteActorsByIds(Long[] ids) {
        for(Long id : ids){
            boolean exists = actorRepository.existsById(id);
            if(!exists){
                throw new IllegalStateException("Actor does not exist");
            }
            else{

                actorRepository.deleteById(id);

            }
        }
    }

    @Transactional
    public void updateActorById(Actor actor, Long id) {
        Optional<Actor> actorFound = actorRepository.findById(id);
        if(!actorFound.isPresent()){
            throw new IllegalStateException("Actor does not exist");
        }
        else{
            if(actor.getFullname() !=null &&
                    actor.getFullname().length() > 0 &&
                    !Objects.equals(actorFound.get().getFullname(), actor.getFullname())){
                actorFound.get().setFullname(actor.getFullname());
            }

            if(actor.getImageUrl() !=null &&
                    actor.getImageUrl().length() > 0 &&
                    !Objects.equals(actorFound.get().getImageUrl(), actor.getImageUrl())){
                actorFound.get().setImageUrl(actor.getImageUrl());
            }
        }
    }
}
