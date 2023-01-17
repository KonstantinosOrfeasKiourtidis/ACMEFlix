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
public class GenreResource extends BaseResource {
    @NotNull(message = "Genre's name cannot be null")
    @Column(length = 20, nullable = false)
    private String name;

}
