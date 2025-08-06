package com.example.cld;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.rds.AmazonRDS;
import com.amazonaws.services.rds.AmazonRDSClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    @Value("${aws.region}")
    private String awsRegion;

    @Bean
    public AmazonS3 amazonS3(){
        return AmazonS3ClientBuilder.standard().withRegion(awsRegion).build();
    }
    @Bean
    public AmazonEC2 amazonEC2(){
        return AmazonEC2ClientBuilder.standard().withRegion(awsRegion).build();
    }
    @Bean
    public AmazonSNS amazonSNS(){
        return AmazonSNSClientBuilder.standard().withRegion(awsRegion).build();
    }
    @Bean
    public AWSLambda awsLambda(){
        return AWSLambdaClientBuilder.standard().withRegion(awsRegion).build();
    }
    @Bean
    public AmazonRDS amazonRDS(){
        return AmazonRDSClientBuilder.standard().withRegion(awsRegion).build();
    }
    @Bean
    public AmazonSQS amazonSQS(){
        return AmazonSQSClientBuilder.standard().withRegion(awsRegion).build();
    }
}
