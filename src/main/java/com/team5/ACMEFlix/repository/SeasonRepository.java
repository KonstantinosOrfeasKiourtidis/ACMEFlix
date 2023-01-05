package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
    @Query(value = "SELECT * FROM SEASONS WHERE TV_SERIES_ID = ?", nativeQuery = true)
    List<Season> findSeasonByTVSeriesId(Long id);
}
