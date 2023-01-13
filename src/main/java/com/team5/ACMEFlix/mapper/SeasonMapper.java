package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Season;
import com.team5.ACMEFlix.transfer.resource.SeasonResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeasonMapper extends BaseMapper<Season, SeasonResource>{
}
