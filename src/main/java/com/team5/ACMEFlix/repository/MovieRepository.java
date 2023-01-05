package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT * FROM MOVIES WHERE CONTENT_ID = ?", nativeQuery = true)
    Optional<Movie> findMovieByContentId(Long id);

    @Query(value = "SELECT * FROM CONTENTS INNER JOIN MOVIES ON CONTENTS.ID=MOVIES.CONTENT_ID WHERE CONTENTS.IS_AGE_RESTRICTED = 0", nativeQuery = true)
    List<Movie> findMoviesByFamilyFriendly();
    @Query(value = "SELECT * FROM CONTENTS INNER JOIN MOVIES ON CONTENTS.ID=MOVIES.CONTENT_ID WHERE CONTENTS.TITLE LIKE %?%", nativeQuery = true)
    List<Movie> findMoviesByName(String search);

    @Query(value = "SELECT MOVIES.ID, MOVIES.CONTENT_ID, GROUP_CONCAT(DIRECTORS.FULLNAME), GROUP_CONCAT(DIRECTORS.IMAGE_URL) FROM MOVIES INNER JOIN DIRECTORS ON MOVIES.ID=DIRECTORS.MOVIE_ID WHERE DIRECTORS.FULLNAME IN (:search)", nativeQuery = true)
    List<Movie> findMoviesByDirector(String[] search);

    @Query(value = "SELECT MOVIES.ID, MOVIES.CONTENT_ID, GROUP_CONCAT(WRITERS.FULLNAME), GROUP_CONCAT(WRITERS.IMAGE_URL) FROM MOVIES INNER JOIN WRITERS ON MOVIES.ID=WRITERS.MOVIE_ID WHERE WRITERS.FULLNAME IN (:search)", nativeQuery = true)
    List<Movie> findMoviesByWriter(String[] search);
}
