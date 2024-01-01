package com.mytude.service;

import com.mytude.dto.UploadVideoResponse;
import com.mytude.dto.VideoDTO;
import com.mytude.entity.Video;
import org.springframework.web.multipart.MultipartFile;

public interface VideoService {

    UploadVideoResponse uploadVideo(MultipartFile file);

    VideoDTO editMetaData(VideoDTO videoDTO);

    String uploadThumbnail(MultipartFile file , String videoId);

    Video fetchVideoById(String videoId);
}
