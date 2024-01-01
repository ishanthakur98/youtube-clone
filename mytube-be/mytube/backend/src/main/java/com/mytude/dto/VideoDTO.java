package com.mytude.dto;

import com.mytude.entity.Comments;
import com.mytude.entity.VideoStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDTO {

    private String id;

    private String title;

    private String description;

    private String userId;

    private Integer likes;

    private Integer disLikes;

    private Set<String> tags;

    private String videoUrl;

    private String thumbnailUrl;

    private VideoStatus videoStatus;

}
