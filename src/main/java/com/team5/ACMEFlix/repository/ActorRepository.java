package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> findActorByContentId(Long id);
}
