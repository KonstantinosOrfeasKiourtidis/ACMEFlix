package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ViewRepository extends JpaRepository<View, Long> {
    @Query(value = "SELECT * FROM VIEWS INNER JOIN WATCHED_LIST_EPISODES ON WATCHED_LIST_EPISODES.VIEW_ID = VIEWS.ID " +
            "WHERE WATCHED_LIST_EPISODES.EPISODE_ID = ?1 AND VIEWS.PROFILE_ID= ?2", nativeQuery = true)
    Optional<View> findViewByEpisodeIdAndProfileId(Long episodeId, Long profileId);

    @Query(value = "SELECT * FROM VIEWS INNER JOIN WATCHED_LIST_MOVIES ON WATCHED_LIST_MOVIES.VIEW_ID = VIEWS.ID " +
            "WHERE WATCHED_LIST_MOVIES.MOVIE_ID = ?1 AND VIEWS.PROFILE_ID= ?2", nativeQuery = true)
    Optional<View> findViewByMovieIdAndProfileId(Long movieId, Long profileId);

    @Query(value = "SELECT VIEWS.CONTENT_ID FROM VIEWS " +
            "GROUP BY VIEWS.CONTENT_ID " +
            "ORDER BY  SUM(VIEWS.TIME_WATCHED_IN_MINUTES) DESC LIMIT 10", nativeQuery = true)
    List<Long> findTop10MostViewedContent();

    @Query(value = "SELECT GENRES.NAME " +
            "FROM VIEWS " +
            "INNER JOIN GENRES ON GENRES.CONTENT_ID =VIEWS.CONTENT_ID " +
            "GROUP BY GENRES.NAME " +
            "ORDER BY  SUM(VIEWS.TIME_WATCHED_IN_MINUTES) DESC " +
            "LIMIT 5", nativeQuery = true)
    List<String> findTop5MostPopularGenres();

    @Query(value = "SELECT SUM(VIEWS.TIME_WATCHED_IN_MINUTES) FROM VIEWS " +
            "INNER JOIN PROFILES " +
            "ON PROFILES.ID=VIEWS.PROFILE_ID " +
            "INNER JOIN ACCOUNTS " +
            "ON ACCOUNTS.ID=PROFILES.ACCOUNT_ID " +
            "GROUP BY VIEWS.PROFILE_ID " +
            "HAVING ACCOUNTS.ID = ?1", nativeQuery = true)
    List<Float> findViewingHoursByAccountId(Long id);

    @Query(value = "SELECT VIEWS.PROFILE_ID FROM VIEWS " +
            "INNER JOIN PROFILES " +
            "ON PROFILES.ID=VIEWS.PROFILE_ID " +
            "INNER JOIN ACCOUNTS " +
            "ON ACCOUNTS.ID=PROFILES.ACCOUNT_ID " +
            "GROUP BY VIEWS.PROFILE_ID " +
            "HAVING ACCOUNTS.ID = ?1", nativeQuery = true)
    List<Long> findProfileIdsByAccountId(Long id);
}
