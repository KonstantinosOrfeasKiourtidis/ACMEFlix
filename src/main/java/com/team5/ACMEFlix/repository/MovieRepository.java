package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT * FROM MOVIES WHERE MOVIES.CONTENT_ID = ?", nativeQuery = true)
    Optional<Movie> findMovieByContentId(Long id);

    @Query(value = "SELECT * FROM CONTENTS INNER JOIN MOVIES ON CONTENTS.ID=MOVIES.CONTENT_ID WHERE CONTENTS.IS_AGE_RESTRICTED = FALSE", nativeQuery = true)
    List<Movie> findMoviesByFamilyFriendly();
    @Query(value = "SELECT * FROM CONTENTS INNER JOIN MOVIES ON CONTENTS.ID=MOVIES.CONTENT_ID WHERE LOWER(CONTENTS.TITLE) LIKE LOWER(CONCAT('%', :search, '%'))", nativeQuery = true)
    List<Movie> findMoviesByName(String search);

    @Query(value = "SELECT * FROM MOVIES WHERE MOVIES.ID IN (:ids)", nativeQuery = true)
    List<Movie> findAllMoviesById(List<BigInteger> ids);
}
