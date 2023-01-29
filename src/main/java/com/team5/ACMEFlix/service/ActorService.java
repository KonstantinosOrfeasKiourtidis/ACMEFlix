package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.Actor;
import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private ContentRepository contentRepository;

    @Transactional(readOnly = true)
    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Actor> findActorById(Long id) {
        return actorRepository.findById(id);
    }
    @Transactional
    public List<Actor> findAllActorsByContentId(Long id) {
        return actorRepository.findActorByContentId(id);
    }

    @Transactional
    public Actor addActorByContentId(Long id, Actor actor) {
        Optional<Content> contentExists = contentRepository.findById(id);
        if(!contentExists.isPresent()){
            throw new NoSuchElementException("Content does not exist");
        }
        else{
            actor.setContent(contentExists.get());
            actorRepository.save(actor);
        }
        return actor;
    }
    @Transactional
    public List<Actor> addActorsByContentId(Long id, List<Actor> actors) {
        for(Actor actor : actors){
            Optional<Content> contentExists = contentRepository.findById(id);
            if(!contentExists.isPresent()){
                throw new NoSuchElementException("Content does not exist");
            }
            else{
                actor.setContent(contentExists.get());
                actorRepository.save(actor);
            }
        }
        return actors;
    }


    @Transactional
    public void deleteActorById(Long id) {
        boolean exists = actorRepository.existsById(id);
        if(!exists){
            throw new NoSuchElementException("Actor does not exist");
        }
        else{

            actorRepository.deleteById(id);

        }
    }
    @Transactional
    public void deleteActorsByIds(List<Long> ids) {
        for(Long id : ids){
            boolean exists = actorRepository.existsById(id);
            if(!exists){
                throw new NoSuchElementException("Actor does not exist");
            }
            else{

                actorRepository.deleteById(id);

            }
        }
    }

    @Transactional
    public void updateActorById(Long id, Actor actor) {
        Optional<Actor> actorFound = actorRepository.findById(id);
        if(!actorFound.isPresent()){
            throw new NoSuchElementException("Actor does not exist");
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
