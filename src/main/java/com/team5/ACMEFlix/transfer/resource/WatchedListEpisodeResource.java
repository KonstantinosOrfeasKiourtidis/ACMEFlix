package com.team5.ACMEFlix.transfer.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.team5.ACMEFlix.domain.Profile;
import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class WatchedListEpisodeResource extends BaseResource {

    private ProfileResource profile;

    @NotNull(message = "Episode's time watched cannot be null")
    @Min(1)
    private Integer timeWatchedInSeconds;

    @NotNull(message = "Episode's watched date cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private Date watchedEpisodeDate = new Date();


    private EpisodeResource episode;
}
