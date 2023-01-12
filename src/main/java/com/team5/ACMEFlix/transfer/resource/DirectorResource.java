package com.team5.ACMEFlix.transfer.resource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.team5.ACMEFlix.domain.Movie;
import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString(callSuper = true)
public class DirectorResource extends BaseResource {

    @NotNull(message = "Director's fullname cannot be null")
    @Column(length = 150, nullable = false)
    @Pattern(regexp = "^[A-Za-z0-9\\. ]+$", message="Director's fullname can only contain alphabetical symbols")
    private String fullname;

    private String imageUrl;
}
