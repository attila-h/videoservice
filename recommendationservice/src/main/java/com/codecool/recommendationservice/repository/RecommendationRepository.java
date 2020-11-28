package com.codecool.recommendationservice.repository;

import com.codecool.recommendationservice.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    List<Recommendation> findAllByVideoId(Long videoId);

    @Transactional
    @Modifying
    @Query("UPDATE Recommendation rec SET rec.comment = :comment, rec.rating = :rating WHERE rec.id = :id")
    void updateRecommendation(
            @Param("comment") String comment,
            @Param("rating") Integer rating,
            @Param("id") Long id
    );

    boolean existsRecommendationById(Long id);

}
