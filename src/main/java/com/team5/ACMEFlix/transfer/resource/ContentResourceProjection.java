package com.team5.ACMEFlix.transfer.resource;

import java.util.Date;

public interface ContentResourceProjection {
    Long getMovieId();
    Long getEpisodeId();
    Float getViewingHours();
    Date getWatchedDate();
    Long getProfileId();

}
