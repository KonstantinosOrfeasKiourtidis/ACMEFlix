package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Movie;
import com.team5.ACMEFlix.transfer.resource.MovieResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper extends BaseMapper<Movie, MovieResource>{
}
