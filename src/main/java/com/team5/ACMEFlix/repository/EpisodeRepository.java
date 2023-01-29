package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    List<Episode> findEpisodesBySeason_Id(Long id);
    List<Episode> findEpisodesByTitleContainingIgnoreCase(String search);
}
