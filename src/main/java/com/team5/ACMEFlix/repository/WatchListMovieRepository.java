package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.WatchedListMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchListMovieRepository extends JpaRepository<WatchedListMovie, Long> {
}
