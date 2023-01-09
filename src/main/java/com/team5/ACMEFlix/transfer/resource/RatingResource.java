package com.team5.ACMEFlix.transfer.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Profile;
import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString(callSuper = true)
public class RatingResource extends BaseResource {
    @Min(0)
    @Max(10)
    @NotNull(message = "Rating cannot be null")
    private Float rating;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ProfileResource profile;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ContentResource content;
}
