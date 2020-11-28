package com.codecool.recommendationservice.setup;

import com.codecool.recommendationservice.dao.interfaces.RecommendationDao;
import com.codecool.recommendationservice.entity.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitDb {

    private final RecommendationDao recommendationDao;

    @Autowired
    public InitDb(RecommendationDao recommendationDao) {
        this.recommendationDao = recommendationDao;
    }

    @PostConstruct
    private void fillDb() {
        recommendationDao.addNewRecommendation(
                Recommendation.builder()
                .comment("Very good explanation. Thanks!")
                .rating(5)
                .videoId(1L)
                .build()
        );
    }
}
