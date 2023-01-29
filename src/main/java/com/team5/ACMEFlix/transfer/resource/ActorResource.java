package com.team5.ACMEFlix.transfer.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ActorResource extends BaseResource {
    @NotNull(message = "Actor's name cannot be null")
    @Column(length = 150, nullable = false)
    private String fullname;

    private String imageUrl;

}
