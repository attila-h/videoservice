package com.codecool.recommendationservice.dao.interfaces;

import com.codecool.recommendationservice.entity.Recommendation;

import java.util.List;

public interface RecommendationDao {

    List<Recommendation> getAllRecommendationByVideoId(Long videoId);
    void updateRecommendation(Recommendation recommendation);

}
