package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.domain.Actor;
import com.team5.ACMEFlix.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
    @Query(value = "SELECT * FROM DIRECTORS WHERE MOVIE_ID = ?", nativeQuery = true)
    List<Director> findDirectorByByMovieId(Long id);
}
