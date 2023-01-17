package com.team5.ACMEFlix.forms;

import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
public class RatingForm {
    @NotNull (message = "Rating cannot be null")
    @Min(0)
    @Max(10)
    private float rating;
    @NotNull (message = "profile id cannot be null")
    private Long profile_id;
    @NotNull (message = "content id cannot be null")
    private Long content_id;

}
