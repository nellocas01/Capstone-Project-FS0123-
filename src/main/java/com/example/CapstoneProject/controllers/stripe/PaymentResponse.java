package com.example.CapstoneProject.controllers.stripe;

public class PaymentResponse {
	private String clientSecret;

	public PaymentResponse(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getClientSecret() {
		return clientSecret;
	}
}
