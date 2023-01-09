package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Genre;
import com.team5.ACMEFlix.transfer.resource.GenreResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper extends BaseMapper<Genre, GenreResource>{
}
