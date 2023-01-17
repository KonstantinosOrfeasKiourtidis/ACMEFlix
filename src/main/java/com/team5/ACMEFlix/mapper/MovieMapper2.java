package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Movie;
import com.team5.ACMEFlix.transfer.resource.MovieResource;
import com.team5.ACMEFlix.transfer.resource.MovieResource2;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper2 extends BaseMapper<Movie, MovieResource2>{
}
