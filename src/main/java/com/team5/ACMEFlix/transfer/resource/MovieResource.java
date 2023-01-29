package com.team5.ACMEFlix.transfer.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieResource extends ContentResource {

    private List<WriterResource> writers;


    private List<DirectorResource> directors;

}
