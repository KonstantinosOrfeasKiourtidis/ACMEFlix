package com.team5.ACMEFlix.transfer.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class WriterResource extends BaseResource {
    @NotNull(message = "Writer's name cannot be null")
    @Column(length = 150, nullable = false)
    private String fullname;

    private String imageUrl;
}
