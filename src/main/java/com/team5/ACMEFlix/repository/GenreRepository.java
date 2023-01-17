package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{
    List<Genre> findGenreByContentId(Long id);
}
