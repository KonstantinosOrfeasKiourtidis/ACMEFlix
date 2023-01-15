package com.team5.ACMEFlix.transfer.resource;

import com.team5.ACMEFlix.domain.enumeration.ContentType;

import java.sql.Clob;
import java.util.Date;

public interface ContentResourceProjection {

    Long getId();
    String getTitle();
    ContentType getContentType();

    Clob getImageUrl();
    Boolean getIsAgeRestricted();
    String getReleaseDate();
    Integer getRuntime();
    String getSpokenLanguage();

    Clob getTrailerUrl();
    String getDescription();
   Float getTimeWatchedInMinutes();
   Date getWatchedDate();
   Long getProfileId();

   Long getMovieId();

   Long getEpisodeId();

   Long getTvSeriesId();

   Integer getEpisodeNo();

   Integer getSeasonNo();

    String getEpisodeTitle();
    String getEpisodeImageUrl();
    String getEpisodeReleaseDate();
    String getEpisodeDescription();

}
