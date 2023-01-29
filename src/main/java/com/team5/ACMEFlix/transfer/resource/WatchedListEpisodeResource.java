package com.team5.ACMEFlix.transfer.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WatchedListEpisodeResource extends ViewResource {

    private EpisodeResource episode;
}
