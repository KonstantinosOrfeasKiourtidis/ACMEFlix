package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Director;
import com.team5.ACMEFlix.domain.TVSeries;
import com.team5.ACMEFlix.domain.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {
    @Query(value = "SELECT * FROM WRITERS WHERE MOVIE_ID = ?", nativeQuery = true)
    List<Writer> findWriterByByMovieId(Long id);
}