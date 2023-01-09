package com.team5.ACMEFlix.mapper;

import java.util.List;

public interface BaseMapper<D,R> {

    R toResource(D domain);
    D toDomain(R resource);

    List<R> toResources(List<D> domains);
    List<D> toDomains(List<R> resources);
}
