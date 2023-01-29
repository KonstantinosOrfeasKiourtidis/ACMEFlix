package com.team5.ACMEFlix.transfer.resource;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class SeasonResource extends BaseResource {
    @NotNull(message = "Season's number cannot be null")
    @Column(nullable = false)
    @Min(1)
    private Integer seasonNo;

    private List<EpisodeResource> episodes;


}
