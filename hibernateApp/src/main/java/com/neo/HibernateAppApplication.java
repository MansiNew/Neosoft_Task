package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.neo.model"})
public class HibernateAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAppApplication.class, args);
	}

}
