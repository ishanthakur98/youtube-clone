package com.mytude.repository;

import com.mytude.entity.Video;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;


public interface VideoRepository extends MongoRepository<Video , String> {
}
