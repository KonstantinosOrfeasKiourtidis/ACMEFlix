package com.team5.ACMEFlix.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString(callSuper = true)
public class WatchedListEpisodeResource extends BaseResource {

    private ViewResource view;


    private EpisodeResource episode;
}
