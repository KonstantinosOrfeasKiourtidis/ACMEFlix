package com.team5.ACMEFlix.transfer.resource;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@ToString(callSuper = true)
public class ViewResource extends BaseResource {

    private ProfileResource profile;

    @NotNull(message = "View's time watched cannot be null")
    @Min(1)
    private Float timeWatchedInMinutes;

    @NotNull(message = "View's watched date cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private Date watchedDate = new Date();

    private ContentResource content;
}
