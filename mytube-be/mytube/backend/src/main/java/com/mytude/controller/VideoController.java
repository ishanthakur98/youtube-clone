package com.mytude.controller;

import com.mytude.dto.UploadVideoResponse;
import com.mytude.dto.VideoDTO;
import com.mytude.entity.Video;
import com.mytude.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public UploadVideoResponse uploadVideo(@RequestParam("file") MultipartFile file){

        return videoService.uploadVideo(file);

    }

    @PutMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    public VideoDTO editMetaData(@RequestBody VideoDTO videoDTO){
        return videoService.editMetaData(videoDTO);
    }

    @PutMapping("/uploadVideo")
    @ResponseStatus(HttpStatus.OK)
    public String uploadThumbnail(@RequestParam("file") MultipartFile file , @RequestParam("videoId") String videoId){
        return videoService.uploadThumbnail(file , videoId);
    }

    @GetMapping("/fetchVideo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Video fetchVideo(@PathVariable("id") String id){
        return videoService.fetchVideoById(id);
    }
}
