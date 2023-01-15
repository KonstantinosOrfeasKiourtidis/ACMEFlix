package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.View;
import com.team5.ACMEFlix.transfer.resource.ContentResourceProjection;
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

    @Query(value = "SELECT " +
            "CONTENTS.ID AS id, CONTENTS.TITLE AS title, CONTENTS.DESCRIPTION AS description, CONTENTS.CONTENT_TYPE AS contentType, " +
            "CONTENTS.IMAGE_URL AS imageUrl, CONTENTS.IS_AGE_RESTRICTED AS isAgeRestricted, CONTENTS.RELEASE_DATE AS releaseDate, " +
            "CONTENTS.RUNTIME AS runtime, CONTENTS.SPOKEN_LANGUAGE AS spokenLanguage, CONTENTS.TRAILER_URL AS trailerUrl, MOVIES.ID AS movieId, " +
            "VIEWS.TIME_WATCHED_IN_MINUTES AS timeWatchedInMinutes, VIEWS.WATCHED_DATE AS watchedDate, PROFILES.ID AS profileId " +
            "FROM VIEWS " +
            "INNER JOIN WATCHED_LIST_MOVIES ON WATCHED_LIST_MOVIES.VIEW_ID  = VIEWS.ID " +
            "INNER JOIN MOVIES ON MOVIES.ID=  WATCHED_LIST_MOVIES .MOVIE_ID " +
            "INNER JOIN CONTENTS ON CONTENTS.ID=MOVIES.CONTENT_ID " +
            "INNER JOIN PROFILES ON VIEWS.PROFILE_ID=PROFILES.ID " +
            "ORDER BY VIEWS.WATCHED_DATE DESC", nativeQuery = true)
    List<ContentResourceProjection> findAllViewingHistoryMovies();


    @Query(value = "SELECT " +
            "CONTENTS.ID AS id, CONTENTS.TITLE AS title, CONTENTS.DESCRIPTION AS description, CONTENTS.CONTENT_TYPE AS contentType, " +
            "CONTENTS.IMAGE_URL AS imageUrl, CONTENTS.IS_AGE_RESTRICTED AS isAgeRestricted, CONTENTS.RELEASE_DATE AS releaseDate, " +
            "CONTENTS.RUNTIME AS runtime, CONTENTS.SPOKEN_LANGUAGE AS spokenLanguage, CONTENTS.TRAILER_URL AS trailerUrl, TV_SERIES.ID AS tvSeriesId, " +
            "SEASONS.SEASON_NO AS seasonNo, EPISODES.TITLE AS episodeTitle, EPISODES.DESCRIPTION AS episodeDescription, EPISODES.ID AS episodeId, " +
            "EPISODES.RELEASE_DATE AS episodeReleaseDate, EPISODES.IMAGE_URL AS episodeImageUrl, " +
            "VIEWS.TIME_WATCHED_IN_MINUTES AS timeWatchedInMinutes, VIEWS.WATCHED_DATE AS watchedDate, PROFILES.ID AS profileId " +
            "FROM VIEWS " +
            "INNER JOIN WATCHED_LIST_EPISODES ON WATCHED_LIST_EPISODES.VIEW_ID  = VIEWS.ID " +
            "INNER JOIN EPISODES ON EPISODES.ID=  WATCHED_LIST_EPISODES.EPISODE_ID " +
            "INNER JOIN SEASONS ON SEASONS.ID=  EPISODES.SEASON_ID " +
            "INNER JOIN TV_SERIES ON SEASONS.TV_SERIES_ID=  TV_SERIES.ID " +
            "INNER JOIN CONTENTS ON CONTENTS.ID=TV_SERIES.CONTENT_ID " +
            "INNER JOIN PROFILES ON VIEWS.PROFILE_ID=PROFILES.ID " +
            "ORDER BY VIEWS.WATCHED_DATE DESC", nativeQuery = true)
    List<ContentResourceProjection> findAllViewingHistoryEpisodes();

}
