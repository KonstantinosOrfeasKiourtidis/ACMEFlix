package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query(value = "SELECT * FROM RATINGS WHERE PROFILE_ID = ?1 AND CONTENT_ID = ?2", nativeQuery = true)
    Optional<Rating> findRatingByProfileIdAndContentId(Long profileId, Long contentId);

    @Query(value = "SELECT * FROM RATINGS WHERE CONTENT_ID = ?", nativeQuery = true)
    List<Rating> findRatingByContentId(Long contentId);

    @Query(value = "SELECT RATINGS.CONTENT_ID FROM RATINGS GROUP BY RATINGS.CONTENT_ID ORDER BY AVG(RATINGS.RATING) DESC LIMIT 10", nativeQuery = true)
    List<Long> findContent10HighestRated();
    @Query(value = "SELECT * FROM RATINGS WHERE PROFILE_ID = ?", nativeQuery = true)

    List<Rating> findRatingsByProfileId(Long id);
    @Modifying
    @Query(value = "DELETE FROM RATINGS WHERE PROFILE_ID = ?", nativeQuery = true)
    void deleteAllByProfileId(Long id);

    @Modifying
    @Query(value = "DELETE FROM RATINGS WHERE PROFILE_ID IN (:id)", nativeQuery = true)
    void deleteAllByProfileIds(List<Long> id);
}
