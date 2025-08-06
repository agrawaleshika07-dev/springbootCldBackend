package com.example.cld;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;


@Configuration
public class AwsConfig {

    @Value("${aws.region}")
    private String awsRegion;

    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3ClientBuilder.standard()
                .withRegion(awsRegion)
                .withCredentials(DefaultCredentialsProvider.create())
                .build();
    }

    @Bean
    public AmazonEC2 amazonEC2() {
        return AmazonEC2ClientBuilder.standard()
                .withRegion(awsRegion)
                .withCredentials(DefaultCredentialsProvider.create())
                .build();
    }

    @Bean
    public AmazonSQS amazonSQS() {
        return AmazonSQSClientBuilder.standard()
                .withRegion(awsRegion)
                .withCredentials(DefaultCredentialsProvider.create())
                .build();
    }
}
