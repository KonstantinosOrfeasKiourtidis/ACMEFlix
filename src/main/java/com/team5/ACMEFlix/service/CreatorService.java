package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Creator;
import com.team5.ACMEFlix.domain.TVSeries;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.repository.ContentRepository;
import com.team5.ACMEFlix.repository.CreatorRepository;
import com.team5.ACMEFlix.repository.TVSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CreatorService {
    @Autowired
    private CreatorRepository creatorRepository;
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private TVSeriesRepository tVSeriesRepository;

    @Transactional(readOnly = true)
    public List<Creator> findAllCreators() {
        return creatorRepository.findAll();
    }
    @Transactional(readOnly = true)
    public ResponseEntity<Creator> findCreatorById(Long id) {
        return creatorRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Transactional(readOnly = true)
    public List<Creator> findAllCreatorsByContentId(Long id) {
        Optional<TVSeries> tvSeries = tVSeriesRepository.findTVSeriesByContentId(id);
        if(!tvSeries.isPresent()){
            throw new IllegalStateException("TV Series does not exist");
        }
        else {
            return creatorRepository.findCreatorByByTVSeriesId(tvSeries.get().getId());
        }
    }

    @Transactional
    public void addCreatorByContentId(Creator creator, Long id) {
        Optional<Content> contentExists = contentRepository.findById(id);
        if(!contentExists.isPresent()){
            throw new IllegalStateException("Content does not exist");
        }
        else if(!contentExists.get().getContentType().equals(ContentType.TV_SERIES)){
            throw new IllegalStateException("Content is not a tv series");
        }
        else{
            Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findTVSeriesByContentId(id);
            if(!tvSeriesExists.isPresent()){
                throw new IllegalStateException("TV Series does not exist");
            }
            else {
                creator.setTvSeries(tvSeriesExists.get());
                creatorRepository.save(creator);
            }

        }
    }
    @Transactional
    public void addCreatorsByContentId(Creator[] creators, Long id) {
        Optional<Content> contentExists = contentRepository.findById(id);
        if(!contentExists.isPresent()){
            throw new IllegalStateException("Content does not exist");
        }
        else if(!contentExists.get().getContentType().equals(ContentType.TV_SERIES)){
            throw new IllegalStateException("TV Series is not a movie");
        }
        else {
            Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findTVSeriesByContentId(id);
            if(!tvSeriesExists.isPresent()){
                throw new IllegalStateException("TV Series does not exist");
            } else {
                for (Creator creator : creators) {
                    creator.setTvSeries(tvSeriesExists.get());
                    creatorRepository.save(creator);
                }

            }


        }
    }
    @Transactional
    public void addCreatorByTVSeriesId(Creator creator, Long id) {
        Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findById(id);
        if(!tvSeriesExists.isPresent()){
            throw new IllegalStateException("TV Series does not exist");
        }
        else{
            creator.setTvSeries(tvSeriesExists.get());
            creatorRepository.save(creator);
        }
    }
    @Transactional
    public void addCreatorsByTVSeriesId(Creator[] creators, Long id) {
        Optional<TVSeries> tvSeriesExists = tVSeriesRepository.findById(id);
        if(!tvSeriesExists.isPresent()){
            throw new IllegalStateException("TV Series does not exist");
        }
        else{
            for (Creator creator : creators) {
                creator.setTvSeries(tvSeriesExists.get());
                creatorRepository.save(creator);
            }
        }
    }

    @Transactional
    public void deleteCreatorById(Long id) {
        boolean exists = creatorRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Creator does not exist");
        }
        else{

            creatorRepository.deleteById(id);

        }
    }

    @Transactional
    public void deleteCreatorsByIds(Long[] ids) {
        for(Long id : ids){
            boolean exists = creatorRepository.existsById(id);
            if(!exists){
                throw new IllegalStateException("Creator does not exist");
            }
            else{

                creatorRepository.deleteById(id);

            }
        }
    }

    @Transactional
    public void updateCreatorById(Creator creator, Long id) {
        Optional<Creator> creatorFound = creatorRepository.findById(id);
        if(!creatorFound.isPresent()){
            throw new IllegalStateException("Creator does not exist");
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
