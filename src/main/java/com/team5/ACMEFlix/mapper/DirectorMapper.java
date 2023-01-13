package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Director;
import com.team5.ACMEFlix.transfer.resource.DirectorResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DirectorMapper extends BaseMapper<Director, DirectorResource>{
}
