package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Movie;
import com.team5.ACMEFlix.domain.TVSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface TVSeriesRepository extends JpaRepository<TVSeries, Long> {
    @Query(value = "SELECT * FROM TV_SERIES WHERE CONTENT_ID = ?", nativeQuery = true)
    Optional<TVSeries> findTVSeriesByContentId(Long id);

    @Query(value = "SELECT CONTENTS.ID FROM CONTENTS WHERE UPPER(CONTENTS.TITLE) LIKE %?1% OR LOWER(CONTENTS.TITLE) LIKE %?1% OR CONTENTS.TITLE LIKE %?1%", nativeQuery = true)
    List<Long> findTVSeriesByName(String search);

    @Query(value = "SELECT * FROM TV_SERIES WHERE TV_SERIES_STATUS_TYPE LIKE %?1% OR UPPER(TV_SERIES_STATUS_TYPE) LIKE %?1% OR LOWER(TV_SERIES_STATUS_TYPE) LIKE %?1% ", nativeQuery = true)
    List<TVSeries> findTVSeriesByStatusType(String search);

    @Query(value = "SELECT * FROM TV_SERIES WHERE TV_SERIES.ID IN (:ids)", nativeQuery = true)
    List<TVSeries> findAllTVSeriesById(List<BigInteger> ids);

    @Query(value = "SELECT * FROM TV_SERIES WHERE TV_SERIES.CONTENT_ID IN (:ids)", nativeQuery = true)
    List<TVSeries> findAllTVSeriesByContentId(List<Long> ids);

    @Query(value = "SELECT * FROM CONTENTS INNER JOIN TV_SERIES ON CONTENTS.ID=TV_SERIES.CONTENT_ID WHERE CONTENTS.IS_AGE_RESTRICTED = FALSE", nativeQuery = true)
    List<TVSeries> findTVSeriesByFamilyFriendly();
}