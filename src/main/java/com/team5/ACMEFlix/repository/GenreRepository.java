package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{
    @Query(value = "SELECT * FROM GENRES WHERE CONTENT_ID = ?", nativeQuery = true)
    List<Genre> findGenreByContentId(Long id);
}
