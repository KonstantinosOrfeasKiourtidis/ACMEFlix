package com.team5.ACMEFlix.transfer.resource;


import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString(callSuper = true)
public class EpisodeResource extends BaseResource {
    @NotNull(message = "Episode's title cannot be null")
    @Column(length = 50, nullable = false)
    private String title;

    private String imageUrl;

    private String description;

    @NotNull(message = "Episode's number cannot be null")
    @Min(0)
    private Integer episodeNo;

    @Column(length = 20)
    private String releaseDate;




}
