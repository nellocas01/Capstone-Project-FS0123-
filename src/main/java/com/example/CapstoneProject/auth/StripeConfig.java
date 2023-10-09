package com.example.CapstoneProject.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {

	@Value("${PRIVATE_KEY_STRIPE}")
	private String stripePrivateKey;

	public String getStripePrivateKey() {
		return stripePrivateKey;
	}

	@Value("${PUBLIC_KEY_STRIPE}")
	private String stripePublicKey;

	public String getStripePublicKey() {
		return stripePublicKey;
	}

}
