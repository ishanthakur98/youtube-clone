package com.mytude.service.impl;

import com.mytude.dto.UploadVideoResponse;
import com.mytude.dto.VideoDTO;
import com.mytude.entity.Video;
import com.mytude.repository.VideoRepository;
import com.mytude.service.FileService;
import com.mytude.service.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final FileService fileService;

    private final VideoRepository videoRepository;

    @Override
    public UploadVideoResponse uploadVideo(MultipartFile file) {

        var videoUrl = fileService.uploadFile(file);
        var video = new Video();
        video.setVideoUrl(videoUrl);
        Video video1 = videoRepository.save(video);
        log.info("video saved {}",video1);
        return new UploadVideoResponse(video1.getId() , videoUrl);
    }

    @Override
    public VideoDTO editMetaData(VideoDTO videoDTO) {

        var video = videoRepository.findById(videoDTO.getId()).orElseThrow( () -> new IllegalArgumentException("No video found with this id"));
        video.setTitle(videoDTO.getTitle());
        video.setDescription(videoDTO.getDescription());
        video.setTags(videoDTO.getTags());
        video.setThumbnailUrl(videoDTO.getThumbnailUrl());
        video.setVideoStatus(videoDTO.getVideoStatus());

        videoRepository.save(video);
        return videoDTO;
    }

    @Override
    public String uploadThumbnail(MultipartFile file, String videoId) {
        var video = videoRepository.findById(videoId).orElseThrow( () -> new IllegalArgumentException("No video found with this id"));

        var url = fileService.uploadFile(file);
        video.setThumbnailUrl(url);
        videoRepository.save(video);
        return url;

    }

    @Override
    public Video fetchVideoById(String videoId) {
         Video video = videoRepository.findById(videoId).orElseThrow(() ->  new IllegalArgumentException("No video found with this id"));
         return video;
    }


}
