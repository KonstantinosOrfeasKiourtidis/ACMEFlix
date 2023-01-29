package com.team5.ACMEFlix.transfer.resource;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class WatchedListMovieResource extends ViewResource {

    private MovieResource movie;
}
