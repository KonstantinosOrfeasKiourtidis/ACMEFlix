package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Actor;
import com.team5.ACMEFlix.transfer.resource.ActorResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActorMapper extends BaseMapper<Actor, ActorResource>{
}
