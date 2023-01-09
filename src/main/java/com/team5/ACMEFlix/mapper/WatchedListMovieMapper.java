package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.WatchedListMovie;
import com.team5.ACMEFlix.transfer.resource.WatchedListMovieResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WatchedListMovieMapper extends BaseMapper<WatchedListMovie, WatchedListMovieResource>{
}
