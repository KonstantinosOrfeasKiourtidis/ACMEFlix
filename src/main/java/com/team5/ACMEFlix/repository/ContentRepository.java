package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long>, PagingAndSortingRepository<Content, Long> {

    @Query(value = "SELECT DISTINCT(CONTENTS.ID), CONTENTS.TITLE, CONTENTS.DESCRIPTION, " +
            "CONTENTS.SPOKEN_LANGUAGE, CONTENTS.RELEASE_DATE, CONTENTS.IMAGE_URL, CONTENTS.TRAILER_URL, " +
            "CONTENTS.IS_AGE_RESTRICTED, CONTENTS.CONTENT_TYPE, CONTENTS.RUNTIME, 0 AS clazz_  " +
            "FROM CONTENTS INNER JOIN GENRES ON GENRES.CONTENT_ID= CONTENTS.ID GROUP BY GENRES.CONTENT_ID, GENRES.NAME " +
            "HAVING LOWER(CONTENTS.TITLE) LIKE LOWER(CONCAT('%', :search, '%')) AND GENRES.NAME IN (:genres) AND CONTENTS.RELEASE_DATE LIKE  %:year% " +
            "AND CONTENTS.IS_AGE_RESTRICTED = :isAgeRestricted " +
            "AND LOWER(CONTENTS.SPOKEN_LANGUAGE) LIKE LOWER(CONCAT('%', :language, '%')) "+
            "AND LOWER(CONTENTS.CONTENT_TYPE) LIKE LOWER(CONCAT('%', :contentType, '%'))",
            countQuery = "SELECT COUNT(*) FROM CONTENTS",
            nativeQuery = true)
    Page<Content> findContentsByEverything(String search, String[] genres, String year, Boolean isAgeRestricted, String language, String contentType, Pageable pageable);

    @Query(value = "SELECT DISTINCT(CONTENTS.ID), CONTENTS.TITLE, CONTENTS.DESCRIPTION, " +
            "CONTENTS.SPOKEN_LANGUAGE, CONTENTS.RELEASE_DATE, CONTENTS.IMAGE_URL, CONTENTS.TRAILER_URL, " +
            "CONTENTS.IS_AGE_RESTRICTED, CONTENTS.CONTENT_TYPE, CONTENTS.RUNTIME, 0 AS clazz_  " +
            "FROM CONTENTS INNER JOIN GENRES ON GENRES.CONTENT_ID= CONTENTS.ID GROUP BY GENRES.CONTENT_ID, GENRES.NAME " +
            "HAVING LOWER(CONTENTS.TITLE) LIKE LOWER(CONCAT('%', :search, '%')) AND CONTENTS.RELEASE_DATE LIKE  %:year% " +
            "AND CONTENTS.IS_AGE_RESTRICTED = :isAgeRestricted " +
            "AND LOWER(CONTENTS.SPOKEN_LANGUAGE) LIKE LOWER(CONCAT('%', :language, '%')) "+
            "AND LOWER(CONTENTS.CONTENT_TYPE) LIKE LOWER(CONCAT('%', :contentType, '%'))",
            countQuery = "SELECT COUNT(*) FROM CONTENTS",
            nativeQuery = true)
    Page<Content> findContentsByEverythingNoGenre(String search, String year, Boolean isAgeRestricted, String language, String contentType, Pageable pageable);



    @Query(value = "SELECT DISTINCT(CONTENTS.ID), CONTENTS.TITLE, CONTENTS.DESCRIPTION, " +
            "CONTENTS.SPOKEN_LANGUAGE, CONTENTS.RELEASE_DATE, CONTENTS.IMAGE_URL, CONTENTS.TRAILER_URL, " +
            "CONTENTS.IS_AGE_RESTRICTED, CONTENTS.CONTENT_TYPE, CONTENTS.RUNTIME, 0 AS clazz_  " +
            "FROM CONTENTS INNER JOIN GENRES ON GENRES.CONTENT_ID= CONTENTS.ID GROUP BY GENRES.CONTENT_ID, GENRES.NAME " +
            "HAVING LOWER(CONTENTS.TITLE) LIKE LOWER(CONCAT('%', :search, '%')) AND GENRES.NAME IN (:genres) AND CONTENTS.RELEASE_DATE LIKE  %:year% " +
            "AND LOWER(CONTENTS.SPOKEN_LANGUAGE) LIKE LOWER(CONCAT('%', :language, '%')) "+
            "AND LOWER(CONTENTS.CONTENT_TYPE) LIKE LOWER(CONCAT('%', :contentType, '%'))",
            countQuery = "SELECT COUNT(*) FROM CONTENTS",
            nativeQuery = true)
    Page<Content> findContentsByEverythingNoIsAgeRestricted(String search, String[] genres, String year, String language, String contentType, Pageable pageable);

    @Query(value = "SELECT DISTINCT(CONTENTS.ID), CONTENTS.TITLE, CONTENTS.DESCRIPTION, " +
            "CONTENTS.SPOKEN_LANGUAGE, CONTENTS.RELEASE_DATE, CONTENTS.IMAGE_URL, CONTENTS.TRAILER_URL, " +
            "CONTENTS.IS_AGE_RESTRICTED, CONTENTS.CONTENT_TYPE, CONTENTS.RUNTIME, 0 AS clazz_ " +
            "FROM CONTENTS INNER JOIN GENRES ON GENRES.CONTENT_ID= CONTENTS.ID GROUP BY GENRES.CONTENT_ID, GENRES.NAME " +
            "HAVING LOWER(CONTENTS.TITLE) LIKE LOWER(CONCAT('%', :search, '%')) AND CONTENTS.RELEASE_DATE LIKE  %:year% " +
            "AND LOWER(CONTENTS.SPOKEN_LANGUAGE) LIKE LOWER(CONCAT('%', :language, '%')) "+
            "AND LOWER(CONTENTS.CONTENT_TYPE) LIKE LOWER(CONCAT('%', :contentType, '%'))",
            countQuery = "SELECT COUNT(*) FROM CONTENTS",
            nativeQuery = true)
    Page<Content> findContentsByEverythingNoGenresAndNoIsAgeRestricted(String search, String year, String language, String contentType, Pageable pageable);

    @Query(value = "SELECT DISTINCT(CONTENTS.ID), CONTENTS.TITLE, CONTENTS.DESCRIPTION, CONTENTS.CONTENT_TYPE, CONTENTS.IMAGE_URL, CONTENTS.IS_AGE_RESTRICTED, CONTENTS.RELEASE_DATE, CONTENTS.RUNTIME, CONTENTS.SPOKEN_LANGUAGE, CONTENTS.TRAILER_URL, AVG(RATINGS.RATING), 0 AS clazz_ " +
            "FROM CONTENTS INNER JOIN RATINGS ON CONTENTS.ID = RATINGS.CONTENT_ID " +
            "GROUP BY RATINGS.CONTENT_ID ORDER BY AVG(RATINGS.RATING) DESC LIMIT 10",
            nativeQuery = true)
    List<Content> findContent10HighestRated();

    @Query(value = "SELECT DISTINCT(CONTENTS.ID), CONTENTS.TITLE, CONTENTS.DESCRIPTION, CONTENTS.CONTENT_TYPE, CONTENTS.IMAGE_URL, CONTENTS.IS_AGE_RESTRICTED, CONTENTS.RELEASE_DATE, CONTENTS.RUNTIME, CONTENTS.SPOKEN_LANGUAGE, CONTENTS.TRAILER_URL, SUM(VIEWS.TIME_WATCHED_IN_MINUTES), 0 AS clazz_ " +
            "FROM CONTENTS INNER JOIN VIEWS ON CONTENTS.ID = VIEWS.CONTENT_ID " +
            "GROUP BY VIEWS.CONTENT_ID ORDER BY  SUM(VIEWS.TIME_WATCHED_IN_MINUTES) DESC LIMIT 10", nativeQuery = true)
    List<Content> findTop10MostViewedContent();

}
