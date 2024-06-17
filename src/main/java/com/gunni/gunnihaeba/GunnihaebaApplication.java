package com.gunni.gunnihaeba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GunnihaebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GunnihaebaApplication.class, args);
	}

}
