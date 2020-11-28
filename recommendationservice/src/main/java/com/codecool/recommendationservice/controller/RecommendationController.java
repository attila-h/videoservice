package com.codecool.recommendationservice.controller;

import com.codecool.recommendationservice.dao.interfaces.RecommendationDao;
import com.codecool.recommendationservice.entity.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class RecommendationController {

    private final RecommendationDao recommendationDao;

    @Autowired
    public RecommendationController(RecommendationDao recommendationDao) {
        this.recommendationDao = recommendationDao;
    }

    @GetMapping(value = "/recommendations")
    private ResponseEntity<Object> getRecommendationsForVideo(Long videoId) {
        if (videoId == null) return ResponseEntity.badRequest()
                .body("Missing parameter: video ID");
        return ResponseEntity.ok(recommendationDao.getAllRecommendationByVideoId(videoId));
    }

    @PostMapping(value = "/recommendation")
    private ResponseEntity<Object> addNewRecommendation(Recommendation recommendation) {
        try {
            recommendationDao.addNewRecommendation(recommendation);
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error while saving recommendation: " + e.getMessage());
        }
    }

    @PutMapping(value = "/recommendation")
    private ResponseEntity<Object> updateRecommendation(Recommendation recommendation) {
        try {
            recommendationDao.updateRecommendation(recommendation);
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error while updating recommendation: " + e.getMessage());
        }
    }

}
