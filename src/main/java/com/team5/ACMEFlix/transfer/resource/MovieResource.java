package com.team5.ACMEFlix.transfer.resource;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Director;
import com.team5.ACMEFlix.domain.Writer;
import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class MovieResource extends BaseResource {

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<WriterResource> writers;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<DirectorResource> directors;

    private ContentResource content;
}
