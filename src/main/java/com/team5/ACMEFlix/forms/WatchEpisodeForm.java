package com.team5.ACMEFlix.forms;


import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
public class WatchEpisodeForm {
    @NotNull(message = "Profile's id cannot be null")
    private Long profile_id;
    @NotNull(message = "Episode's id cannot be null")
    private Long episode_id;
    @NotNull(message = "Time watched cannot be null")
    @Min(1)
    private Float timeWatchedInMinutes;
}
