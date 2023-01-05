package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.helpers.RatingForm;
import com.team5.ACMEFlix.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/rating")
public class RatingController {
    private final RatingService ratingService;
    @Autowired
    private RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addRatings")
    public void addRatings(
            @RequestBody RatingForm... ratingForms
    ){
        ratingService.addRatings(ratingForms);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteRatingByContentIdAndProfileId")
    public void deleteRatingByContentIdAndProfileId(
            @RequestBody RatingForm ratingForm
    ){
        ratingService.deleteRatingByContentIdAndProfileId(ratingForm);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "rate")
    public void rate(
            @RequestBody RatingForm ratingForm
    ){
        ratingService.rate(ratingForm);
    }
}
