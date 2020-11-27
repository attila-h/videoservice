package com.codecool.videoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VideoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoserviceApplication.class, args);
	}

}
