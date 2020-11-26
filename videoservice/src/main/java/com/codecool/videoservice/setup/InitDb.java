package com.codecool.videoservice.setup;

import com.codecool.videoservice.dao.interfaces.VideoDao;
import com.codecool.videoservice.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitDb {

    private final VideoDao videoDao;

    @Autowired
    public InitDb(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

    @PostConstruct
    private void fillDb() {
        videoDao.add(Video.builder()
            .title("Quicksort algorithm")
            .url("https://www.youtube.com/watch?v=7h1s2SojIRw")
            .build()
        );
        videoDao.add(Video.builder()
            .title("Time Complexity #1")
            .url("https://www.youtube.com/watch?v=9TlHvipP5yA")
            .build()
        );
    }
}
