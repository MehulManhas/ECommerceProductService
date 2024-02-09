package com.ecommerceproject.ECommProject;

import com.ecommerceproject.ECommProject.Service.InitService;
import com.ecommerceproject.ECommProject.Service.InitServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommProjectApplication implements CommandLineRunner {

	private InitServiceImpl initService;

	public ECommProjectApplication(InitServiceImpl initService) {
		this.initService = initService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ECommProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		initService.initialise();
	}
}
