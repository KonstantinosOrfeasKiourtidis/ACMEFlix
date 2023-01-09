package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Movie;
import com.team5.ACMEFlix.domain.TVSeries;
import com.team5.ACMEFlix.transfer.resource.ContentResource;
import org.mapstruct.Mapper;

import java.util.List;


public interface ContentMapper extends ContentBaseMapper<Content, ContentResource, Movie, TVSeries>{

}
