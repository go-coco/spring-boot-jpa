package com.see0gan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.see0gan.file.StorageProperties;

@SpringBootApplication //(scanBasePackages = {"com.see0gan"})
@EnableConfigurationProperties(StorageProperties.class)
public class MyProjectUsingMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectUsingMysqlApplication.class, args);
	}

}
