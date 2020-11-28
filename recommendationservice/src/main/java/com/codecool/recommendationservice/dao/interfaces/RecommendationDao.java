package com.codecool.recommendationservice.dao.interfaces;

import com.codecool.recommendationservice.entity.Recommendation;
import org.springframework.stereotype.Component;

import java.util.List;

public interface RecommendationDao {

    List<Recommendation> getAllRecommendationByVideoId(Long videoId);
    void addNewRecommendation(Recommendation recommendation);
    void updateRecommendation(Recommendation recommendation);

}
