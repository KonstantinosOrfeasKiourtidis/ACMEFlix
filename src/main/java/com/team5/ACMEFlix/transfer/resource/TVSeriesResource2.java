package com.team5.ACMEFlix.transfer.resource;

import com.team5.ACMEFlix.domain.enumeration.TVSeriesStatusType;
import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class TVSeriesResource2 extends BaseResource {
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<SeasonResource> seasons;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<CreatorResource> creators;

    @NotNull(message = "TV Series status type cannot be null")
    @Enumerated(EnumType.STRING)
    private TVSeriesStatusType tvSeriesStatusType;


}