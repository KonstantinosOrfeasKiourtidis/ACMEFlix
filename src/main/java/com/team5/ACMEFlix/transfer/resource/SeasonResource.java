package com.team5.ACMEFlix.transfer.resource;


import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class SeasonResource extends BaseResource {
    @NotNull(message = "Season's number cannot be null")
    @Column(nullable = false)
    @Min(1)
    private Integer seasonNo;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<EpisodeResource> episodes;


}
