package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Query(value = "SELECT * FROM ACTORS WHERE CONTENT_ID = ?", nativeQuery = true)
    List<Actor> findActorByContentId(Long id);
}
