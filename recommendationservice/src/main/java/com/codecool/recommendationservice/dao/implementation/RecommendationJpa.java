package com.codecool.recommendationservice.dao.implementation;

import com.codecool.recommendationservice.dao.interfaces.RecommendationDao;
import com.codecool.recommendationservice.entity.Recommendation;
import com.codecool.recommendationservice.repository.RecommendationRepository;

import java.util.List;

public class RecommendationJpa implements RecommendationDao {

    public static final int MIN_RATING = 0;
    public static final int MAX_RATING = 5;
    private final RecommendationRepository recommendationRepository;

    public RecommendationJpa(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public List<Recommendation> getAllRecommendationByVideoId(Long videoId) {
        return recommendationRepository.findAllByVideoId(videoId);
    }

    @Override
    public void addNewRecommendation(Recommendation recommendation) {
        if (isFalseRating(recommendation.getRating())) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        recommendationRepository.save(recommendation);
    }

    @Override
    public void updateRecommendation(Recommendation recommendation) {
        if (isFalseRating(recommendation.getRating())) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        recommendationRepository.updateRecommendation(
                recommendation.getComment(),
                recommendation.getRating(),
                recommendation.getId()
        );
    }

    private boolean isFalseRating(Integer rating) {
        return rating < MIN_RATING || rating > MAX_RATING;
    }

}
