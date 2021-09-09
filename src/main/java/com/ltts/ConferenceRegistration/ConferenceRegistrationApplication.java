package com.ltts.ConferenceRegistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.reactive.ReactiveOAuth2ClientAutoConfiguration;

@SpringBootApplication()
public class ConferenceRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceRegistrationApplication.class, args);
	}

}
