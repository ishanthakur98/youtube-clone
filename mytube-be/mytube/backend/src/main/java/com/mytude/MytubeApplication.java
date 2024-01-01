package com.mytude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;


@SpringBootApplication
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class MytubeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MytubeApplication.class, args);

//		System.out.println(System.getenv());
    }

}
