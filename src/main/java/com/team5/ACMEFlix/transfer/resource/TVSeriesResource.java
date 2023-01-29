package com.team5.ACMEFlix.transfer.resource;

import com.team5.ACMEFlix.domain.enumeration.TVSeriesStatusType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class TVSeriesResource extends ContentResource {

    private List<SeasonResource> seasons;

    private List<CreatorResource> creators;

    @NotNull(message = "TV Series status type cannot be null")
    @Enumerated(EnumType.STRING)
    private TVSeriesStatusType tvSeriesStatusType;
}
