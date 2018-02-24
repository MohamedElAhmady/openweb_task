package com.openweb.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.openweb" })
public class WebAppLauncher {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebAppLauncher.class, args);
	}
	
}

