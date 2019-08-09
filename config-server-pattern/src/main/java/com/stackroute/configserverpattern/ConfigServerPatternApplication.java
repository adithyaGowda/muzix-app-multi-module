package com.stackroute.configserverpattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerPatternApplication.class, args);
	}

}
