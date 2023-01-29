package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.View;
import com.team5.ACMEFlix.transfer.resource.ContentResourceProjection;
import com.team5.ACMEFlix.transfer.resource.ProfileProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewRepository extends JpaRepository<View, Long> {
    @Query(value = "SELECT VIEWS.PROFILE_ID as id, SUM(VIEWS.TIME_WATCHED_IN_MINUTES)/60 AS viewingHours,  FROM VIEWS " +
            "INNER JOIN PROFILES " +
            "ON PROFILES.ID=VIEWS.PROFILE_ID " +
            "INNER JOIN ACCOUNTS " +
            "ON ACCOUNTS.ID=PROFILES.ACCOUNT_ID " +
            "GROUP BY VIEWS.PROFILE_ID " +
            "HAVING ACCOUNTS.ID = ?1", nativeQuery = true)
    List<ProfileProjection> findViewingHoursByAccountId(Long id);

    @Query(value = "SELECT " +
            "MOVIES.ID AS movieId, " +
            "VIEWS.TIME_WATCHED_IN_MINUTES/60 AS viewingHours, VIEWS.WATCHED_DATE AS watchedDate, PROFILES.ID AS profileId, 0 AS clazz_ " +
            "FROM VIEWS " +
            "INNER JOIN WATCHED_LIST_MOVIES ON WATCHED_LIST_MOVIES.ID  = VIEWS.ID " +
            "INNER JOIN MOVIES ON MOVIES.ID=  WATCHED_LIST_MOVIES.MOVIE_ID " +
            "INNER JOIN CONTENTS ON MOVIES.ID=  CONTENTS.ID " +
            "INNER JOIN PROFILES ON VIEWS.PROFILE_ID=PROFILES.ID " +
            "ORDER BY VIEWS.WATCHED_DATE DESC", nativeQuery = true)
    List<ContentResourceProjection> findAllViewingHistoryMovies();

    @Query(value = "SELECT " +
            "EPISODES.ID AS episodeId, " +
            "VIEWS.TIME_WATCHED_IN_MINUTES/60 AS viewingHours, VIEWS.WATCHED_DATE AS watchedDate, PROFILES.ID AS profileId, 0 AS clazz_ " +
            "FROM VIEWS " +
            "INNER JOIN WATCHED_LIST_EPISODES ON WATCHED_LIST_EPISODES.ID  = VIEWS.ID " +
            "INNER JOIN EPISODES ON EPISODES.ID=  WATCHED_LIST_EPISODES.EPISODE_ID " +
            "INNER JOIN SEASONS ON SEASONS.ID=  EPISODES.SEASON_ID " +
            "INNER JOIN TV_SERIES ON TV_SERIES.ID=  SEASONS.TV_SERIES_ID " +
            "INNER JOIN CONTENTS ON TV_SERIES.ID=  CONTENTS.ID " +
            "INNER JOIN PROFILES ON VIEWS.PROFILE_ID=PROFILES.ID " +
            "ORDER BY VIEWS.WATCHED_DATE DESC", nativeQuery = true)
    List<ContentResourceProjection> findAllViewingHistoryEpisodes();
}
