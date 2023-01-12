package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.WatchedListEpisode;
import com.team5.ACMEFlix.transfer.resource.WatchedListEpisodeResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WatchedListEpisodeMapper extends BaseMapper<WatchedListEpisode, WatchedListEpisodeResource>{

}
