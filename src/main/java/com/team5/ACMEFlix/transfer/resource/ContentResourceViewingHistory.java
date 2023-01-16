package com.team5.ACMEFlix.transfer.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.domain.enumeration.TVSeriesStatusType;
import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContentResourceViewingHistory extends BaseResource {

    private String title;
    private String description;
    private String spokenLanguage;
    private String releaseDate;

    private String imageUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String trailerUrl;
    private Boolean isAgeRestricted;
    private List<GenreResource> genres;
    private List<ActorResource> actors;
    private ContentType contentType;
    private Integer runtime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer episodeNo;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer SeasonNo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String episodeTitle;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String episodeDescription;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String episodeReleaseDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String episodeImageUrl;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CreatorResource> creators;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TVSeriesStatusType tvSeriesStatusType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<WriterResource> writers;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<DirectorResource> directors;

    private Float viewingHours;
    private Date watchedDate;

}
