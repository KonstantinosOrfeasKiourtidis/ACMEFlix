package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long>, PagingAndSortingRepository<Content, Long> {

    @Query(value = "SELECT * FROM CONTENTS WHERE IS_AGE_RESTRICTED = FALSE", nativeQuery = true)
    List<Content> findAllContentsByFamilyFriendly();

    @Query(value = "SELECT * FROM CONTENTS WHERE LOWER(CONTENTS.TITLE) LIKE LOWER(CONCAT('%', :search, '%'))", nativeQuery = true)
    List<Content> findContentByName(String search);

    @Query(value = "SELECT * FROM CONTENTS WHERE LOWER(CONTENTS.SPOKEN_LANGUAGE) LIKE LOWER(CONCAT('%', :search, '%'))", nativeQuery = true)
    List<Content> findContentByLanguage(String search);

    @Query(value = "SELECT * FROM CONTENTS WHERE CONTENTS.RELEASE_DATE LIKE %?%", nativeQuery = true)
    List<Content> findContentByYear(String search);

    @Query(value = "SELECT * FROM CONTENTS WHERE CONTENTS.ID IN (:ids)", nativeQuery = true)
    List<Content> findAllContentsById(List<BigInteger> ids);

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

    @Query(value = "SELECT DISTINCT(CONTENTS.ID), CONTENTS.TITLE, CONTENTS.DESCRIPTION, " +
            "CONTENTS.SPOKEN_LANGUAGE, CONTENTS.RELEASE_DATE, CONTENTS.IMAGE_URL, CONTENTS.TRAILER_URL, " +
            "CONTENTS.IS_AGE_RESTRICTED, CONTENTS.CONTENT_TYPE, CONTENTS.RUNTIME " +
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
            "CONTENTS.IS_AGE_RESTRICTED, CONTENTS.CONTENT_TYPE, CONTENTS.RUNTIME " +
            "FROM CONTENTS INNER JOIN GENRES ON GENRES.CONTENT_ID= CONTENTS.ID GROUP BY GENRES.CONTENT_ID, GENRES.NAME " +
            "HAVING LOWER(CONTENTS.TITLE) LIKE LOWER(CONCAT('%', :search, '%')) AND GENRES.NAME IN (:genres) AND CONTENTS.RELEASE_DATE LIKE  %:year% " +
            "AND LOWER(CONTENTS.SPOKEN_LANGUAGE) LIKE LOWER(CONCAT('%', :language, '%')) "+
            "AND LOWER(CONTENTS.CONTENT_TYPE) LIKE LOWER(CONCAT('%', :contentType, '%'))",
            countQuery = "SELECT COUNT(*) FROM CONTENTS",
            nativeQuery = true)
    Page<Content> findContentsByEverythingNoIsAgeRestricted(String search, String[] genres, String year, String language, String contentType, Pageable pageable);

    @Query(value = "SELECT DISTINCT(CONTENTS.ID), CONTENTS.TITLE, CONTENTS.DESCRIPTION, " +
            "CONTENTS.SPOKEN_LANGUAGE, CONTENTS.RELEASE_DATE, CONTENTS.IMAGE_URL, CONTENTS.TRAILER_URL, " +
            "CONTENTS.IS_AGE_RESTRICTED, CONTENTS.CONTENT_TYPE, CONTENTS.RUNTIME " +
            "FROM CONTENTS INNER JOIN GENRES ON GENRES.CONTENT_ID= CONTENTS.ID GROUP BY GENRES.CONTENT_ID, GENRES.NAME " +
            "HAVING LOWER(CONTENTS.TITLE) LIKE LOWER(CONCAT('%', :search, '%')) AND CONTENTS.RELEASE_DATE LIKE  %:year% " +
            "AND LOWER(CONTENTS.SPOKEN_LANGUAGE) LIKE LOWER(CONCAT('%', :language, '%')) "+
            "AND LOWER(CONTENTS.CONTENT_TYPE) LIKE LOWER(CONCAT('%', :contentType, '%'))",
            countQuery = "SELECT COUNT(*) FROM CONTENTS",
            nativeQuery = true)
    Page<Content> findContentsByEverythingNoGenresAndNoIsAgeRestricted(String search, String year, String language, String contentType, Pageable pageable);
}
