package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Profile;
import com.team5.ACMEFlix.domain.Rating;
import com.team5.ACMEFlix.repository.ContentRepository;
import com.team5.ACMEFlix.repository.ProfileRepository;
import com.team5.ACMEFlix.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ContentRepository contentRepository;


    @Transactional(readOnly = true)
    public List<Rating> findAllRatings() {
        return ratingRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Rating> findRatingById(Long id) {
        return ratingRepository.findById(id);
    }

    @Transactional
    public Rating addRating(Rating rating) {

            if(!(rating.getRating() > 0 && rating.getRating() <= 10)){
                throw new IllegalStateException("The rating must be between 1 and 10");
            }

            if(rating.getProfile().getId() == null){
                throw new IllegalStateException("The rating must include a profile id");
            }

            if(rating.getContent().getId() == null){
                throw new IllegalStateException("The rating must include a content id");
            }

            Optional<Profile> profileExists = profileRepository.findById(rating.getProfile().getId());
            if(!profileExists.isPresent()){
                throw new IllegalStateException("The profile does not exist");
            }
            Optional<Content> contentExists = contentRepository.findById(rating.getContent().getId());
            if(!contentExists.isPresent()){
                throw new IllegalStateException("The content does not exist");
            }

            ratingRepository.save(rating);
            return rating;

    }

    @Transactional
    public List<Rating> addRatings(List<Rating> ratings) {
        for(Rating rating: ratings){
            if(!(rating.getRating() > 0 && rating.getRating() <= 10)){
                throw new IllegalStateException("The rating must be between 1 and 10");
            }

            if(rating.getProfile().getId() == null){
                throw new IllegalStateException("The rating must include a profile id");
            }

            if(rating.getContent().getId() == null){
                throw new IllegalStateException("The rating must include a content id");
            }

            Optional<Profile> profileExists = profileRepository.findById(rating.getProfile().getId());
            if(!profileExists.isPresent()){
                throw new NoSuchElementException("The profile does not exist");
            }
            Optional<Content> contentExists = contentRepository.findById(rating.getContent().getId());
            if(!contentExists.isPresent()){
                throw new NoSuchElementException("The content does not exist");
            }

            ratingRepository.save(rating);
        }
        return ratings;
    }

    @Transactional
    public void deleteRatingById(Long id) {
        boolean exists = ratingRepository.existsById(id);
        if(!exists){
            throw new NoSuchElementException("Rating does not exist");
        }
        else{
            ratingRepository.deleteById(id);
        }
    }

    @Transactional
    public void deleteRatingsByIds(List<Long> ids) {
        for(Long id : ids){
            boolean exists = ratingRepository.existsById(id);
            if(!exists){
                throw new NoSuchElementException("Ratings does not exist");
            }
            else{
                ratingRepository.deleteById(id);
            }
        }
    }

    @Transactional
    public void updateRatingById(Long id, Rating rating) {
        Optional<Rating> ratingFound = ratingRepository.findById(id);
        if(!ratingFound.isPresent()){
            throw new NoSuchElementException("Rating does not exist");
        }
        else{
            if(rating.getRating() !=null &&
                    rating.getRating() > 0 &&
                    rating.getRating() <= 10 &&
                    !Objects.equals(ratingFound.get().getRating(),  rating.getRating())){
                ratingFound.get().setRating(rating.getRating());
            }
        }
    }
}
