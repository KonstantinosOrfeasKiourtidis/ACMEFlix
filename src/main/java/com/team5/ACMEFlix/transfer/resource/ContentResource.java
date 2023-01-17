package com.team5.ACMEFlix.transfer.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.domain.enumeration.TVSeriesStatusType;
import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class ContentResource extends BaseResource {
    @NotNull(message = "Content's title cannot be null")
    @Column(length = 50, nullable = false)
    private String title;

    @NotNull(message = "Content's description cannot be null")
    @Column(length = 255, nullable = false)
    private String description;

    @NotNull(message = "Content's language cannot be null")
    @Column(length = 20, nullable = false)
    @Pattern(regexp = "^[A-Za-z ]+$", message="Content's language can only contain alphabetical symbols")
    private String spokenLanguage;

    @NotNull(message = "Content's release date cannot be null")
    @Column(length = 20, nullable = false)
    @Pattern(regexp = "^[A-Za-z0-9\\. ]+$", message="Content's release date can only contain alphanumeric symbols")
    private String releaseDate;

    private String imageUrl;
    private String trailerUrl;

    @NotNull(message = "Content's age restriction cannot be null")
    private Boolean isAgeRestricted;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<GenreResource> genres;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ActorResource> actors;

    @NotNull(message = "Content's type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private ContentType contentType;

    @NotNull(message = "Content's runtime cannot be null")
    @Min(0)
    private Integer runtime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<SeasonResource> seasons;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CreatorResource> creators;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TVSeriesStatusType tvSeriesStatusType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<WriterResource> writers;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<DirectorResource> directors;

    @Min(0)
    @Max(10)
    private Float rating;

    private Integer profileNo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<RatingResource> ratings;
}
