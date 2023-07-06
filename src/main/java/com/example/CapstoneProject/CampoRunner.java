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
		// Creazione di alcuni esempi di campi
//		Campo campo1 = new Campo("Campo A", "Indirizzo Campo A");
//		Campo campo2 = new Campo("Campo B", "Indirizzo Campo B");
//		Campo campo3 = new Campo("Campo C", "Indirizzo Campo C");
//
//		campoRepo.save(campo1);
//		campoRepo.save(campo2);
//		campoRepo.save(campo3);

		Faker faker = new Faker(new Locale("it"));
		List<Campo> campoDb = campoRepo.findAll();
		if (campoDb.size() == 0) {
			for (int i = 0; i < 10; i++) {
				try {

					String[] fieldPrefixes = { "Green", "Sunny", "Golden", "Victory", "Elite", "Dynamic", "Star",
							"Royal" };
					String[] fieldSuffixes = { "Field", "Stadium", "Grounds", "Park" };
					String nome = faker.options().option(fieldPrefixes) + " " + faker.options().option(fieldSuffixes);
					String indirizzo = "via " + faker.address().city();

					Campo newCampo = new Campo(nome, indirizzo);
					campoRepo.save(newCampo);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

	}
}
