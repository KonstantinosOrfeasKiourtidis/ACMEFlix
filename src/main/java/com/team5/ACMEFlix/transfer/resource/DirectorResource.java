package com.team5.ACMEFlix.transfer.resource;


import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@ToString(callSuper = true)
public class DirectorResource extends BaseResource {

    @NotNull(message = "Director's fullname cannot be null")
    @Column(length = 150, nullable = false)
    private String fullname;

    private String imageUrl;
}
