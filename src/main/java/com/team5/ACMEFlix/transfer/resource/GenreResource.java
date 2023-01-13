package com.team5.ACMEFlix.transfer.resource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.team5.ACMEFlix.domain.Content;
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
public class GenreResource extends BaseResource {
    @NotNull(message = "Genre's name cannot be null")
    @Column(length = 20, nullable = false)
    @Pattern(regexp = "^[A-Za-z0-9\\. ]+$", message="Genre's name can only contain alphanumeric symbols")
    private String name;

}
