package com.ryana;

import com.ryana.configurations.RSAKeyPair;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RSAKeyPair.class)
@SpringBootApplication
public class JwtSignInOffLatestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSignInOffLatestApplication.class, args);
	}

}
