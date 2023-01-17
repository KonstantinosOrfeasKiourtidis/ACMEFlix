package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreatorRepository extends JpaRepository<Creator, Long> {
    List<Creator> findCreatorsByTvSeriesId(Long id);
}
