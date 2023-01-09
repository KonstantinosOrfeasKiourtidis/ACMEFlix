package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Writer;
import com.team5.ACMEFlix.transfer.resource.WriterResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WriterMapper extends BaseMapper<Writer, WriterResource>{
}
