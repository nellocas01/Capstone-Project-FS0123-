package com.example.CapstoneProject.controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CapstoneProject.auth.StripeConfig;
import com.example.CapstoneProject.controllers.stripe.PaymentRequest;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@RestController
@RequestMapping("/")
public class PaymentController {
	@Autowired
	private StripeConfig stripeConfig;
	@Autowired
	private ResourceLoader resourceLoader;

	@GetMapping("/")
	public String index() throws IOException {
		Resource resource = resourceLoader.getResource("classpath:path/to/index.html");
		Path indexPath = resource.getFile().toPath();
		String content = StreamUtils.copyToString(Files.newInputStream(indexPath), StandardCharsets.UTF_8);
		return content;
	}

//	@GetMapping("/")
//	public String index() {
//		// Restituisci il percorso del file index.html
//		String path = "path/to/index.html";
//		return path;
//	}

	@GetMapping("/config")
	public String getStripePublicKey() {
		// Restituisci la chiave pubblica di Stripe
		return stripeConfig.getStripePublicKey();
	}

	@PostMapping("/crea-pagamento")
	public String createPaymentIntent(@RequestBody PaymentRequest paymentRequest) throws StripeException {
		Stripe.apiKey = stripeConfig.getStripePrivateKey();

		PaymentIntentCreateParams params = new PaymentIntentCreateParams.Builder().setAmount(paymentRequest.getAmount())
				.setCurrency(paymentRequest.getCurrency()).build();

		PaymentIntent paymentIntent = PaymentIntent.create(params);

		return paymentIntent.getClientSecret();
	}
}
