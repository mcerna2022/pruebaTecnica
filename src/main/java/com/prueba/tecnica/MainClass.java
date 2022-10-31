package com.prueba.tecnica;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import org.springframework.web.bind.annotation.CrossOrigin;

@EnableCaching

@SpringBootApplication
@CrossOrigin(origins = "*")
@EnableResourceServer
@EnableFeignClients
public class MainClass {

	public static void main(String[] args) {
		SpringApplication.run(MainClass.class, args);
	}
        
        
         @PostConstruct
	public void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/El Salvador"));
	}

}
