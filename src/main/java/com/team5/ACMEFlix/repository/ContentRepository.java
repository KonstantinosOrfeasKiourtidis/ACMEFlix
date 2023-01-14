package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.*;
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
public interface ContentRepository extends JpaRepository<Content, Long> {
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
}
