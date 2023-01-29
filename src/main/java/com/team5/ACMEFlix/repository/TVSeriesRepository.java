package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.TVSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TVSeriesRepository extends JpaRepository<TVSeries, Long> {

}