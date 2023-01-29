package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Rating;
import com.team5.ACMEFlix.transfer.resource.ContentResource;
import org.mapstruct.*;



@Mapper(componentModel = "spring")
public interface ContentMapper extends BaseMapper<Content, ContentResource>{
    @Mapping(source = "ratings", target = "ratings")
    @Mapping(target = "profileNo", expression = "java(content.getRatings().size())")
    ContentResource toResource(Content content);

    @InheritInverseConfiguration
    Content toDomain(ContentResource contentResource);

    @AfterMapping
    default void setRating(Content content, @MappingTarget ContentResource resource) {
        double totalRating = content.getRatings().stream()
                .mapToDouble(Rating::getRating)
                .sum();
        resource.setRating(totalRating / content.getRatings().size());
    }


}
