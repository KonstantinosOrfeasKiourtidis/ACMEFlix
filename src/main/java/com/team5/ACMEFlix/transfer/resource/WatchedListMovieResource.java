package com.team5.ACMEFlix.transfer.resource;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString(callSuper = true)
public class WatchedListMovieResource extends BaseResource {

    private ViewResource view;


    private MovieResource movie;
}
