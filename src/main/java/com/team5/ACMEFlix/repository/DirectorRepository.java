package com.team5.ACMEFlix.repository;


import com.team5.ACMEFlix.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
    List<Director> findDirectorsByMovie_Id(Long id);
}
