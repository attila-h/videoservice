package com.codecool.videoservice.dao.interfaces;

import com.codecool.videoservice.entity.Video;
import java.util.List;

public interface VideoDao {

    void add(Video video);
    List<Video> getAll();

}
