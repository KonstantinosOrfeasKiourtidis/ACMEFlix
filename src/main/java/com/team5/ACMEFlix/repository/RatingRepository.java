package com.team5.ACMEFlix.repository;


import com.team5.ACMEFlix.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;




@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

}
