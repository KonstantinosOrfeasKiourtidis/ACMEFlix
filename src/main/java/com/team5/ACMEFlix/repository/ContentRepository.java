package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long>, PagingAndSortingRepository<Content, Long> {
    @Query(value = "SELECT m.ID FROM MOVIES m INNER JOIN CONTENTS cs ON m.CONTENT_ID = cs.ID WHERE cs.IS_AGE_RESTRICTED = FALSE", nativeQuery = true)
    List<Long> findMoviesIDsByFamilyFriendly();

    @Query(value = "SELECT tv.ID FROM TV_SERIES tv INNER JOIN CONTENTS cs ON tv.CONTENT_ID = cs.ID WHERE cs.IS_AGE_RESTRICTED = FALSE", nativeQuery = true)
    List<Long> findTVSeriesIDsByFamilyFriendly();

    @Query(value = "SELECT * FROM CONTENTS WHERE IS_AGE_RESTRICTED = FALSE", nativeQuery = true)
    List<Content> findAllContentsByFamilyFriendly();

    @Query(value = "SELECT * FROM CONTENTS WHERE UPPER(CONTENTS.TITLE) LIKE %?1% OR LOWER(CONTENTS.TITLE) LIKE %?1% OR CONTENTS.TITLE LIKE %?1%", nativeQuery = true)
    List<Content> findContentByName(String search);

    @Query(value = "SELECT * FROM CONTENTS WHERE UPPER(CONTENTS.SPOKEN_LANGUAGE) LIKE %?1% OR LOWER(CONTENTS.SPOKEN_LANGUAGE) LIKE %?1% OR CONTENTS.SPOKEN_LANGUAGE LIKE %?1%", nativeQuery = true)
    List<Content> findContentByLanguage(String search);

    @Query(value = "SELECT * FROM CONTENTS WHERE CONTENTS.RELEASE_DATE LIKE %?%", nativeQuery = true)
    List<Content> findContentByYear(String search);

    @Query(value = "SELECT * FROM CONTENTS WHERE CONTENTS.ID IN (:ids)", nativeQuery = true)
    List<Content> findAllContentsById(List<BigInteger> ids);

    Page<Content> findAllByTitleContainingIgnoreCase(String search, Pageable pageable);
    Page<Content> findAllByReleaseDateContainingIgnoreCase(String year, Pageable pageable);
    Page<Content> findAllByIsAgeRestrictedEquals(Boolean isAgeRestricted, Pageable pageable);
    Page<Content> findAllBySpokenLanguageContainingIgnoreCase(String language, Pageable pageable);
    @Query(value = "SELECT * FROM CONTENTS WHERE LOWER(CONTENTS.CONTENT_TYPE) LIKE LOWER(CONCAT('%', :contentType, '%'))", nativeQuery = true)
    Page<Content> findAllByContentType(String contentType, Pageable pageable);
    @Query(value = "SELECT DISTINCT(CONTENTS.ID), CONTENTS.TITLE, CONTENTS.DESCRIPTION, " +
            "CONTENTS.SPOKEN_LANGUAGE, CONTENTS.RELEASE_DATE, CONTENTS.IMAGE_URL, CONTENTS.TRAILER_URL, " +
            "CONTENTS.IS_AGE_RESTRICTED, CONTENTS.CONTENT_TYPE, CONTENTS.RUNTIME " +
            "FROM CONTENTS INNER JOIN GENRES ON GENRES.CONTENT_ID= CONTENTS.ID GROUP BY GENRES.CONTENT_ID, GENRES.NAME HAVING GENRES.NAME IN (:genres)",
            countQuery = "SELECT COUNT(*) FROM CONTENTS",
            nativeQuery = true)
    Page<Content> findContentsByGenres(String[] genres, Pageable pageable);

    @Query(value = "SELECT DISTINCT(CONTENTS.ID), CONTENTS.TITLE, CONTENTS.DESCRIPTION, " +
            "CONTENTS.SPOKEN_LANGUAGE, CONTENTS.RELEASE_DATE, CONTENTS.IMAGE_URL, CONTENTS.TRAILER_URL, " +
            "CONTENTS.IS_AGE_RESTRICTED, CONTENTS.CONTENT_TYPE, CONTENTS.RUNTIME " +
            "FROM CONTENTS INNER JOIN GENRES ON GENRES.CONTENT_ID= CONTENTS.ID GROUP BY GENRES.CONTENT_ID, GENRES.NAME " +
            "HAVING LOWER(CONTENTS.TITLE) LIKE LOWER(CONCAT('%', :search, '%')) AND GENRES.NAME IN (:genres) AND CONTENTS.RELEASE_DATE LIKE  %:year% " +
            "AND CONTENTS.IS_AGE_RESTRICTED = :isAgeRestricted " +
            "AND LOWER(CONTENTS.SPOKEN_LANGUAGE) LIKE LOWER(CONCAT('%', :language, '%')) "+
            "AND LOWER(CONTENTS.CONTENT_TYPE) LIKE LOWER(CONCAT('%', :contentType, '%'))",
            countQuery = "SELECT COUNT(*) FROM CONTENTS",
            nativeQuery = true)
    Page<Content> findContentsByEverything(String search, String[] genres, String year, Boolean isAgeRestricted, String language, String contentType, Pageable pageable);
}
