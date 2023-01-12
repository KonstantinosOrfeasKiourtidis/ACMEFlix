package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.View;
import com.team5.ACMEFlix.transfer.resource.ViewResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ViewMapper extends BaseMapper<View, ViewResource>{
}
