package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Episode;
import com.team5.ACMEFlix.transfer.resource.EpisodeResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EpisodeMapper extends BaseMapper<Episode, EpisodeResource>{
}
