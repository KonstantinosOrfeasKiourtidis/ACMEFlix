package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Profile;
import com.team5.ACMEFlix.domain.Rating;
import com.team5.ACMEFlix.helpers.RatingForm;
import com.team5.ACMEFlix.repository.ContentRepository;
import com.team5.ACMEFlix.repository.ProfileRepository;
import com.team5.ACMEFlix.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ContentRepository contentRepository;

    @Transactional
    public void addRatings(RatingForm[] ratingForms) {
        for(RatingForm ratingForm: ratingForms){
            if(!(ratingForm.getRating() > 0 && ratingForm.getRating() <= 10)){
                throw new IllegalStateException("The rating must be between 1 and 10");
            }

            if(ratingForm.getProfile_id() == null){
                throw new IllegalStateException("The rating must include a profile id");
            }

            if(ratingForm.getContent_id() == null){
                throw new IllegalStateException("The rating must include a content id");
            }

            Optional<Profile> profileExists = profileRepository.findById(ratingForm.getProfile_id());
            if(!profileExists.isPresent()){
                throw new IllegalStateException("The profile does not exist");
            }
            Optional<Content> contentExists = contentRepository.findById(ratingForm.getContent_id());
            if(!profileExists.isPresent()){
                throw new IllegalStateException("The content does not exist");
            }



            Optional<Rating> ratingExists = ratingRepository.findRatingByProfileIdAndContentId(ratingForm.getProfile_id() ,ratingForm.getContent_id());
            if(ratingExists.isPresent()){
                ratingExists.get().setRating(ratingForm.getRating());
            }
            else{
                Rating rating = new Rating();
                rating.setRating(ratingForm.getRating());
                rating.setProfile(profileExists.get());
                rating.setContent(contentExists.get());
                ratingRepository.save(rating);
            }
        }
    }
    @Transactional
    public void deleteRatingByContentIdAndProfileId(RatingForm ratingForm) {
        if(ratingForm.getProfile_id() == null){
            throw new IllegalStateException("The rating must include a profile id");
        }

        if(ratingForm.getContent_id() == null){
            throw new IllegalStateException("The rating must include a content id");
        }

        Optional<Profile> profileExists = profileRepository.findById(ratingForm.getProfile_id());
        if(!profileExists.isPresent()){
            throw new IllegalStateException("The profile does not exist");
        }
        Optional<Content> contentExists = contentRepository.findById(ratingForm.getProfile_id());
        if(!profileExists.isPresent()){
            throw new IllegalStateException("The content does not exist");
        }

        Optional<Rating> ratingExists = ratingRepository.findRatingByProfileIdAndContentId(ratingForm.getProfile_id() , ratingForm.getContent_id());
        if(ratingExists.isPresent()){
            ratingRepository.deleteById(ratingExists.get().getId());
        }
    }

    @Transactional
    public void rate(RatingForm ratingForm) {

        if(!(ratingForm.getRating() > 0 && ratingForm.getRating() <= 10)){
            throw new IllegalStateException("The rating must be between 1 and 10");
        }

        if(ratingForm.getProfile_id() == null){
            throw new IllegalStateException("The rating must include a profile id");
        }

        if(ratingForm.getContent_id() == null){
            throw new IllegalStateException("The rating must include a content id");
        }

        Optional<Profile> profileExists = profileRepository.findById(ratingForm.getProfile_id());
        if(!profileExists.isPresent()){
            throw new IllegalStateException("The profile does not exist");
        }
        Optional<Content> contentExists = contentRepository.findById(ratingForm.getContent_id());
        if(!profileExists.isPresent()){
            throw new IllegalStateException("The content does not exist");
        }



        Optional<Rating> ratingExists = ratingRepository.findRatingByProfileIdAndContentId(ratingForm.getProfile_id() ,ratingForm.getContent_id());
        if(ratingExists.isPresent()){
            ratingExists.get().setRating(ratingForm.getRating());
        }
        else{
            Rating rating = new Rating();
            rating.setRating(ratingForm.getRating());
            rating.setProfile(profileExists.get());
            rating.setContent(contentExists.get());
            ratingRepository.save(rating);
        }


    }
}
