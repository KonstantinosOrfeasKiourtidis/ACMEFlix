package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    @Query(value = "SELECT m.ID FROM MOVIES m INNER JOIN CONTENTS cs ON m.CONTENT_ID = cs.ID WHERE cs.IS_AGE_RESTRICTED = 0", nativeQuery = true)
    List<Long> findMoviesIDsByFamilyFriendly();

    @Query(value = "SELECT tv.ID FROM TV_SERIES tv INNER JOIN CONTENTS cs ON tv.CONTENT_ID = cs.ID WHERE cs.IS_AGE_RESTRICTED = 0", nativeQuery = true)
    List<Long> findTVSeriesIDsByFamilyFriendly();

    @Query(value = "SELECT * FROM CONTENTS WHERE IS_AGE_RESTRICTED = 0", nativeQuery = true)
    List<Content> findAllContentsByFamilyFriendly();

    @Query(value = "SELECT * FROM CONTENTS WHERE CONTENTS.TITLE LIKE %?%", nativeQuery = true)
    List<Content> findContentByName(String search);

    @Query(value = "SELECT CONTENTS.ID , CONTENTS.CONTENT_TYPE, CONTENTS.DESCRIPTION, CONTENTS.IMAGE_URL, CONTENTS.TRAILER_URL, CONTENTS.IS_AGE_RESTRICTED, CONTENTS.RELEASE_DATE, CONTENTS.RUNTIME, CONTENTS.SPOKEN_LANGUAGE, CONTENTS.TITLE, GROUP_CONCAT(GENRES.NAME) AS GENRE_NAME FROM CONTENTS INNER JOIN GENRES ON CONTENTS.ID=GENRES.CONTENT_ID WHERE GENRES.NAME IN (:search) GROUP BY CONTENTS.ID", nativeQuery = true)
    List<Content> findContentByGenre(String[] search);

    @Query(value = "SELECT CONTENTS.ID, CONTENTS.CONTENT_TYPE, CONTENTS.DESCRIPTION, CONTENTS.IMAGE_URL, CONTENTS.TRAILER_URL, CONTENTS.IS_AGE_RESTRICTED, CONTENTS.RELEASE_DATE, CONTENTS.RUNTIME, CONTENTS.SPOKEN_LANGUAGE, CONTENTS.TITLE, GROUP_CONCAT(ACTORS.FULLNAME) AS ACTOR_FULLNAME, GROUP_CONCAT(ACTORS.IMAGE_URL) FROM CONTENTS INNER JOIN ACTORS ON CONTENTS.ID=ACTORS.CONTENT_ID WHERE ACTORS.FULLNAME IN (:search) GROUP BY CONTENTS.ID", nativeQuery = true)
    List<Content> findContentByActor(String[] search);

    @Query(value = "SELECT * FROM CONTENTS WHERE CONTENTS.SPOKEN_LANGUAGE LIKE %?%", nativeQuery = true)
    List<Content> findContentByLanguage(String search);

    @Query(value = "SELECT * FROM CONTENTS WHERE CONTENTS.RELEASE_DATE LIKE %?%", nativeQuery = true)
    List<Content> findContentByYear(String search);

}
