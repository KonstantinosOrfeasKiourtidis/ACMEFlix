package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{
    List<Genre> findGenreByContentId(Long id);

    @Query(value = "SELECT GENRES.NAME " +
            "FROM VIEWS " +
            "INNER JOIN GENRES ON GENRES.CONTENT_ID =VIEWS.CONTENT_ID " +
            "GROUP BY GENRES.NAME " +
            "ORDER BY  SUM(VIEWS.TIME_WATCHED_IN_MINUTES) DESC " +
            "LIMIT 5", nativeQuery = true)
    List<String> findTop5MostPopularGenres();
}
