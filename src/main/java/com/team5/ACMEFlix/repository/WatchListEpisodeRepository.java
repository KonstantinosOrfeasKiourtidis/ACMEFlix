package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.WatchedListEpisode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface WatchListEpisodeRepository extends JpaRepository<WatchedListEpisode, Long> {

    @Query(value = "SELECT * FROM WATCHED_LIST_EPISODES WHERE WATCHED_LIST_EPISODES.EPISODE_ID = ?1 AND WATCHED_LIST_EPISODES.PROFILE_ID= ?2", nativeQuery = true)
    Optional<WatchedListEpisode> findWatchedListEpisodeByEpisodeIdAndProfileId(Long episodetId, Long profileId);
}
