package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
    List<Season> findSeasonsByTvSeriesId(Long id);
}
