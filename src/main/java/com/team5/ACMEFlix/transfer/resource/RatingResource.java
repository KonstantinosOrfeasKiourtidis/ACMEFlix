package com.team5.ACMEFlix.transfer.resource;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RatingResource extends BaseResource {
    @Min(0)
    @Max(10)
    @NotNull(message = "Rating cannot be null")
    private Double rating;

    private ProfileResource profile;

}
