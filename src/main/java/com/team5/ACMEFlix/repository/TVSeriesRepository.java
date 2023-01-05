package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Movie;
import com.team5.ACMEFlix.domain.TVSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TVSeriesRepository extends JpaRepository<TVSeries, Long> {
    @Query(value = "SELECT * FROM TV_SERIES WHERE CONTENT_ID = ?", nativeQuery = true)
    Optional<TVSeries> findTVSeriesByContentId(Long id);

    @Query(value = "SELECT * FROM CONTENTS INNER JOIN TV_SERIES ON CONTENTS.ID=TV_SERIES.CONTENT_ID WHERE CONTENTS.IS_AGE_RESTRICTED = 0", nativeQuery = true)
    List<TVSeries> findTVSeriesByFamilyFriendly();

    @Query(value = "SELECT * FROM CONTENTS INNER JOIN TV_SERIES ON CONTENTS.ID=TV_SERIES.CONTENT_ID WHERE CONTENTS.TITLE LIKE %?%", nativeQuery = true)
    List<TVSeries> findTVSeriesByName(String search);

    @Query(value = "SELECT TV_SERIES.ID, TV_SERIES.CONTENT_ID, TV_SERIES.TV_SERIES_STATUS_TYPE, GROUP_CONCAT(CREATORS.FULLNAME), GROUP_CONCAT(CREATORS.IMAGE_URL) FROM TV_SERIES INNER JOIN CREATORS ON TV_SERIES.ID=CREATORS.TV_SERIES_ID WHERE CREATORS.FULLNAME IN (:search)", nativeQuery = true)
    List<TVSeries> findTVSeriesByCreator(String[] search);

    @Query(value = "SELECT * FROM TV_SERIES WHERE TV_SERIES_STATUS_TYPE LIKE %?%", nativeQuery = true)
    List<TVSeries> findTVSeriesByStatusType(String search);

}
