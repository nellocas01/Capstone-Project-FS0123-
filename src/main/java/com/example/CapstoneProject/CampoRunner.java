package com.example.CapstoneProject;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.CapstoneProject.entities.Campo;
import com.example.CapstoneProject.repository.CampoRepository;
import com.github.javafaker.Faker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CampoRunner implements CommandLineRunner {

	@Autowired
	private CampoRepository campoRepo;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker(new Locale("it"));
		List<Campo> campoDb = campoRepo.findAll();
		if (campoDb.size() == 0) {
			for (int i = 0; i < 5; i++) {
				try {

					String[] fieldPrefixes = { "Green", "Sunny", "Golden", "Victory", "Elite", "Dynamic", "Star",
							"Royal" };
					String[] fieldSuffixes = { "Field", "Stadium", "Grounds", "Park" };
					String nome = faker.options().option(fieldPrefixes) + " " + faker.options().option(fieldSuffixes);
					String indirizzo = faker.address().streetName() + ", Napoli";

					Campo newCampo = new Campo(nome, indirizzo);
					campoRepo.save(newCampo);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

	}
}
