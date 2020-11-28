package com.codecool.recommendationservice.controller;

import com.codecool.recommendationservice.dao.interfaces.RecommendationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RecommendationController {

    private final RecommendationDao recommendationDao;

    @Autowired
    public RecommendationController(RecommendationDao recommendationDao) {
        this.recommendationDao = recommendationDao;
    }

    @GetMapping("/recommendations")
    private ResponseEntity<Object> getRecommendationsForVideo(Long videoId) {
        if (videoId == null) return ResponseEntity.badRequest()
                .body("Missing parameter: video ID");
        return ResponseEntity.ok(recommendationDao.getAllRecommendationByVideoId(videoId));
    }


}
