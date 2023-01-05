package com.team5.ACMEFlix.helpers;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RatingForm {
    @NotNull (message = "Rating cannot be null")
    @Min(0)
    @Max(10)
    private float rating;
    @NotNull (message = "profile id cannot be null")
    private Long profile_id;
    @NotNull (message = "content id cannot be null")
    private Long content_id;

    public RatingForm() {
    }

    public RatingForm(float rating, Long profile_id, Long content_id) {
        this.rating = rating;
        this.profile_id = profile_id;
        this.content_id = content_id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Long getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Long profile_id) {
        this.profile_id = profile_id;
    }

    public Long getContent_id() {
        return content_id;
    }

    public void setContent_id(Long content_id) {
        this.content_id = content_id;
    }
}
