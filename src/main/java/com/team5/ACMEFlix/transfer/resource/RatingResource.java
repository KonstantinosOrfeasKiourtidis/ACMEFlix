package com.team5.ACMEFlix.transfer.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ContentResource content;
}
