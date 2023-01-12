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
public class WriterResource extends BaseResource {
    @NotNull(message = "Writer's name cannot be null")
    @Column(length = 150, nullable = false)
    @Pattern(regexp = "^[A-Za-z\\. ]+$", message="Writer's fullname can only contain alphabetical symbols")
    private String fullname;

    private String imageUrl;
}
