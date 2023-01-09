package com.team5.ACMEFlix.transfer.resource;

import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString(callSuper = true)
public class ActorResource extends BaseResource {
    @NotNull(message = "Actor's name cannot be null")
    @Column(length = 150, nullable = false)
    @Pattern(regexp = "^[A-Za-z\\. ]+$", message="Actor's fullname can only contain alphabetical symbols")
    private String fullname;

    private String imageUrl;

}
