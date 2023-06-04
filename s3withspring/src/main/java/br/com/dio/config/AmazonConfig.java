package br.com.dio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfig {
	
	private static final String ACCESS_KEY = "accesskey";
	private static final String SECRET_KEY = "secretkey";

	public static final String BUCKET_NAME = "curso-aws-dio-e-alura";
	
	@Bean
	public AmazonS3 getAmazonConfig() {
		
		BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
		return AmazonS3ClientBuilder
				.standard()
				.withRegion(Regions.SA_EAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
				.build();
		
	}
}
