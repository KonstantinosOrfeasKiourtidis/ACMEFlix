package com.team5.ACMEFlix.service;


import com.team5.ACMEFlix.domain.Creator;
import com.team5.ACMEFlix.domain.TVSeries;
import com.team5.ACMEFlix.repository.CreatorRepository;
import com.team5.ACMEFlix.repository.TVSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class CreatorService {
    @Autowired
    private CreatorRepository creatorRepository;
    @Autowired
    private TVSeriesRepository tVSeriesRepository;

    @Transactional(readOnly = true)
    public List<Creator> findAllCreators() {
        return creatorRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Creator> findCreatorById(Long id) {
        return creatorRepository.findById(id);
    }
    @Transactional(readOnly = true)
    public List<Creator> findAllCreatorsByTVSeriesId(Long id) {
        Optional<TVSeries> tvSeries = tVSeriesRepository.findById(id);
        if(!tvSeries.isPresent()){
            throw new NoSuchElementException("TV Series does not exist");
        }
        else {
            return creatorRepository.findCreatorsByTvSeriesId(tvSeries.get().getId());
        }
    }

    @Transactional
    public Creator addCreatorByTVSeriesId(Long id, Creator creator) {
        Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findById(id);
        if(!tvSeriesExists.isPresent()){
            throw new NoSuchElementException("TV Series does not exist");
        }
        else{
            creator.setTvSeries(tvSeriesExists.get());
            creatorRepository.save(creator);
        }
        return creator;
    }
    @Transactional
    public List<Creator> addCreatorsByTVSeriesId(Long id, List<Creator> creators) {
        Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findById(id);
        if(!tvSeriesExists.isPresent()){
            throw new NoSuchElementException("TV Series does not exist");
        }
        else{
            for (Creator creator : creators) {
                creator.setTvSeries(tvSeriesExists.get());
                creatorRepository.save(creator);
            }
        }
        return creators;
    }

    @Transactional
    public void deleteCreatorById(Long id) {
        boolean exists = creatorRepository.existsById(id);
        if(!exists){
            throw new NoSuchElementException("Creator does not exist");
        }
        else{

            creatorRepository.deleteById(id);

        }
    }

    @Transactional
    public void deleteCreatorsByIds(List<Long> ids) {
        for(Long id : ids){
            boolean exists = creatorRepository.existsById(id);
            if(!exists){
                throw new NoSuchElementException("Creator does not exist");
            }
            else{

                creatorRepository.deleteById(id);

            }
        }
    }

    @Transactional
    public void updateCreatorById(Long id, Creator creator) {
        Optional<Creator> creatorFound = creatorRepository.findById(id);
        if(!creatorFound.isPresent()){
            throw new NoSuchElementException("Creator does not exist");
        }
        else{
            if(creator.getFullname() !=null &&
                    creator.getFullname().length() > 0 &&
                    !Objects.equals(creatorFound.get().getFullname(), creator.getFullname())){
                creatorFound.get().setFullname(creator.getFullname());
            }

            if(creator.getImageUrl() !=null &&
                    creator.getImageUrl().length() > 0 &&
                    !Objects.equals(creatorFound.get().getImageUrl(), creator.getImageUrl())){
                creatorFound.get().setImageUrl(creator.getImageUrl());
            }
        }
    }
}
