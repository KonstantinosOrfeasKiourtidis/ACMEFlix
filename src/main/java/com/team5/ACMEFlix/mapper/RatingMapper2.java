package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Rating;
import com.team5.ACMEFlix.transfer.resource.RatingResource2;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RatingMapper2 extends BaseMapper<Rating, RatingResource2>{
}
