package com.mytude.entity;

import lombok.*;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

    @Id
    private String id;

    private String text;

    private String authorId;

    private Integer likes;

    private Integer disLikes;
}
