package com.example.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class EhcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhcacheApplication.class, args);
	}

}
