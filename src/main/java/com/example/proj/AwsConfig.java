package com.example.proj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.rds.RdsClient;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class AwsConfig {

    @Value("${aws.region}")
    private String awsRegion;

    @Bean
    public S3Client s3Client() {
        return S3Client.builder().region(Region.of(awsRegion)).credentialsProvider(DefaultCredentialsProvider.create()).build();
    }

    @Bean
    public SnsClient snsClient() {
        return SnsClient.builder().region(Region.of(awsRegion)).credentialsProvider(DefaultCredentialsProvider.create()).build();
    }

    @Bean
    public Ec2Client ec2Client() {
        return Ec2Client.builder().region(Region.of(awsRegion)).credentialsProvider(DefaultCredentialsProvider.create()).build();
    }

    @Bean
    public LambdaClient lambdaClient() {
        return LambdaClient.builder().region(Region.of(awsRegion)).credentialsProvider(DefaultCredentialsProvider.create()).build();
    }

    @Bean
    public RdsClient rdsClient() {
        return RdsClient.builder().region(Region.of(awsRegion)).credentialsProvider(DefaultCredentialsProvider.create()).build();
    }

    @Bean
    public SqsClient sqsClient() {
        return SqsClient.builder().region(Region.of(awsRegion)).credentialsProvider(DefaultCredentialsProvider.create()).build();
    }
}
