package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Creator;
import com.team5.ACMEFlix.transfer.resource.CreatorResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreatorMapper extends BaseMapper<Creator, CreatorResource>{
}
