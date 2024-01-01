package com.mytude.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(value = "User")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String fullName;

    private String emailAddress;

    private Set<String> subscriptions;

    private Set<String> subscribers;

    private List<String> history;

    private Set<String> likedVideos;

    private Set<String> disLikedVideos;
}
