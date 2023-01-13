package com.team5.ACMEFlix.transfer.resource;

import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString(callSuper = true)
public class EpisodeResource extends BaseResource {
    @NotNull(message = "Episode's title cannot be null")
    @Column(length = 50, nullable = false)
    private String title;

    private String imageUrl;

    @NotNull(message = "Episode's description cannot be null")
    @Column(length = 255, nullable = false)
    private String description;

    @NotNull(message = "Episode's number cannot be null")
    @Min(0)
    private Integer episodeNo;

    @NotNull(message = "Episode's release date cannot be null")
    @Column(length = 20, nullable = false)
    @Pattern(regexp = "^[A-Za-z0-9\\. ]+$", message="Episode's release date can only contain alphanumeric symbols")
    private String releaseDate;



}
