package com.example.CapstoneProject;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.CapstoneProject.entities.Campo;
import com.example.CapstoneProject.entities.Prenotazione;
import com.example.CapstoneProject.entities.User;
import com.example.CapstoneProject.repository.CampoRepository;
import com.example.CapstoneProject.repository.PrenotazioneRepository;
import com.example.CapstoneProject.repository.UsersRepository;
import com.github.javafaker.Faker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
//order
public class PrenotazioneRunner implements CommandLineRunner {

	@Autowired
	private PrenotazioneRepository prenotazioneRepo;
	@Autowired
	private UsersRepository utenteRepo;
	@Autowired
	private CampoRepository campoRepo;

	@Override
	public void run(String... args) throws Exception {
		// Esempio di creazione di una prenotazione
		Faker faker = new Faker(new Locale("it"));
		List<Prenotazione> prenotazioneDb = prenotazioneRepo.findAll();
		List<User> userDb = utenteRepo.findAll();
		List<Campo> campoDb = campoRepo.findAll();

		if (prenotazioneDb.size() == 0) {
			for (int i = 0; i < 20; i++) {
				try {

					Date data = faker.date().future(31, TimeUnit.DAYS);// gestione orari specifici
					Campo randomCampo = campoDb.get(faker.random().nextInt(campoDb.size()));
					User randomUser = userDb.get(faker.random().nextInt(userDb.size()));

					Prenotazione newPrenotazione = new Prenotazione(data, randomCampo, randomUser);
					prenotazioneRepo.save(newPrenotazione);

				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

//		// Recupera un utente dal repository degli utenti
//		User utente = utenteRepo.findById(1L).orElse(null);
//
//		if (utente != null) {
//			// Crea una nuova prenotazione
//			Prenotazione prenotazione = new Prenotazione();
//			prenotazione.setData(LocalDateTime.now());
//			prenotazione.setCampo(campo);
//			prenotazione.setUtente(utente);
//
//			// Salva la prenotazione nel repository delle prenotazioni
//			prenotazioneRepo.save(prenotazione);
//
//			System.out.println("Prenotazione creata con successo: " + prenotazione);
//		} else {
//			System.out.println("Utente non trovato.");
//		}
//
//		// Esempio di recupero di tutte le prenotazioni
//		List<Prenotazione> prenotazioni = prenotazioneRepo.findAll();
//		System.out.println("Elenco di tutte le prenotazioni:");
//		for (Prenotazione prenotazione : prenotazioni) {
//			System.out.println(prenotazione);
//		}
	}
}
