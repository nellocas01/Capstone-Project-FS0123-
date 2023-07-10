package com.example.CapstoneProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CapstoneProject.auth.StripeConfig;
import com.example.CapstoneProject.controllers.stripe.PaymentRequest;
import com.example.CapstoneProject.controllers.stripe.PaymentResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@RestController
public class PaymentController {
	@Autowired
	private StripeConfig stripeConfig;

	@PostMapping("/crea-pagamento")
	public PaymentResponse createPaymentIntent(@RequestBody PaymentRequest paymentRequest) throws StripeException {
		Stripe.apiKey = stripeConfig.getStripePrivateKey();

		PaymentIntentCreateParams params = new PaymentIntentCreateParams.Builder().setAmount(paymentRequest.getAmount())
				.setCurrency(paymentRequest.getCurrency()).build();

		PaymentIntent paymentIntent = PaymentIntent.create(params);

		return new PaymentResponse(paymentIntent.getClientSecret());
	}
}
