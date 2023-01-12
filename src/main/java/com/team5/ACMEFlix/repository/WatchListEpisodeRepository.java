package com.team5.ACMEFlix.repository;


import com.team5.ACMEFlix.domain.WatchedListEpisode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface WatchListEpisodeRepository extends JpaRepository<WatchedListEpisode, Long> {



}
