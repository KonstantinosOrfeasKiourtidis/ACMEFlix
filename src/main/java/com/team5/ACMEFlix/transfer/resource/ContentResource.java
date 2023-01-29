package com.team5.ACMEFlix.transfer.resource;

import com.team5.ACMEFlix.domain.enumeration.ContentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
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

    private List<GenreResource> genres;

    private List<ActorResource> actors;

    @NotNull(message = "Content's type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private ContentType contentType;

    @NotNull(message = "Content's runtime cannot be null")
    @Min(0)
    private Integer runtime;

    @Min(0)
    @Max(10)
    private Double rating;

    private Integer profileNo;

    private List<RatingResource> ratings;
}
