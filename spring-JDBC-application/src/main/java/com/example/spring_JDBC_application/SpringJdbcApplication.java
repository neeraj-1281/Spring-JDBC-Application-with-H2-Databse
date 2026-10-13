package com.example.spring_JDBC_application;

import com.example.spring_JDBC_application.model.Alien;
import com.example.spring_JDBC_application.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(1);
		alien1.setName("Neeraj");
		alien1.setTech("SpringBoot");

		AlienRepo alienRepo = context.getBean(AlienRepo.class);
		alienRepo.save(alien1);

		System.out.println(alienRepo.findAll());
	}

}
