package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Query(value = "SELECT * FROM PROFILES WHERE ACCOUNT_ID = ?", nativeQuery = true)
    List<Profile> findProfileByByAccountId(Long id);

}
