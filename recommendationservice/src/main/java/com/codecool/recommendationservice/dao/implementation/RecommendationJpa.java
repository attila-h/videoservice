package com.codecool.recommendationservice.dao.implementation;

import com.codecool.recommendationservice.dao.interfaces.RecommendationDao;
import com.codecool.recommendationservice.entity.Recommendation;
import com.codecool.recommendationservice.repository.RecommendationRepository;

import java.util.List;

public class RecommendationJpa implements RecommendationDao {

    private final RecommendationRepository recommendationRepository;

    public RecommendationJpa(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public List<Recommendation> getAllRecommendationByVideoId(Long videoId) {
        return recommendationRepository.findAllByVideoId(videoId);
    }

    @Override
    public void updateRecommendation(Recommendation recommendation) {
        recommendationRepository.updateRecommendation(
                recommendation.getComment(),
                recommendation.getRating(),
                recommendation.getId()
        );
    }

}
