package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.TVSeries;
import com.team5.ACMEFlix.transfer.resource.TVSeriesResource;
import com.team5.ACMEFlix.transfer.resource.TVSeriesResource2;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TVSeriesMapper2 extends BaseMapper<TVSeries, TVSeriesResource2>{
}
