package com.mytude.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.context.config.annotation.EnableContextCredentials;
import org.springframework.cloud.aws.context.config.annotation.EnableContextResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.cloud.aws.context.support.io.Re;

@Configuration
@EnableContextResourceLoader
@EnableContextCredentials
public class AmazonS3Config {

//    private static final String AWS_ACCESS_KEY_ID = System.getenv("cloud.aws.credentials.accessKey");
//
//    private static final String AWS_SECRET_ACCESS_KEY = System.getenv("cloud.aws.credentials.secretKey");

//    @Value("${aws_accessKey}")
//    private String ACCESS_KEY;
//
//    @Value("${aws_secretKey}")
//    private String SECRET_KEY;

    @Value("${AWS_ACCESS_KEY_ID}")
    private String AWS_ACCESS_KEY_ID;

    @Value("${AWS_SECRET_ACCESS_KEY}")
    private String AWS_SECRET_ACCESS_KEY;

    @Bean
    @Primary
    public AmazonS3Client amazonS3Client() {
//        System.out.println("hii"+AWS_ACCESS_KEY_ID);
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                AWS_ACCESS_KEY_ID,
                AWS_SECRET_ACCESS_KEY
        );

        return (AmazonS3Client) AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.US_EAST_1).build();
    }
}
