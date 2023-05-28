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
	private static final String SECRET_KEY = "secrete";

	@Bean
	public AmazonS3 amazonConfig() {
		
		BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
		return AmazonS3ClientBuilder
				.standard()
				.withRegion(Regions.DEFAULT_REGION)
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
				.build();
		
	}
}
