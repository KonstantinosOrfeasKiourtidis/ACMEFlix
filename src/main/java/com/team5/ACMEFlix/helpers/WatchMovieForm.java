package com.team5.ACMEFlix.helpers;

import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
public class WatchMovieForm {
    @NotNull(message = "Profile's id cannot be null")
    private Long profile_id;
    @NotNull(message = "Movie's id cannot be null")
    private Long movie_id;
    @NotNull(message = "Time watched cannot be null")
    @Min(1)
    private Integer timeWatchedInSeconds;
}
