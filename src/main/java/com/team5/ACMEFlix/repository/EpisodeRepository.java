package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    @Query(value = "SELECT * FROM EPISODES WHERE SEASON_ID = ?", nativeQuery = true)
    List<Episode> findEpisodeBySeasonId(Long id);

    @Query(value = "SELECT * FROM EPISODES WHERE EPISODES.TITLE LIKE %?%", nativeQuery = true)
    List<Episode> findEpisodesByName(String search);
}
