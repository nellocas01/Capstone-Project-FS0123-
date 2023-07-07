package com.example.CapstoneProject;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.CapstoneProject.entities.Prenotazione;
import com.example.CapstoneProject.entities.Stato;
import com.example.CapstoneProject.repository.CampoRepository;
import com.example.CapstoneProject.repository.PrenotazioneRepository;
import com.example.CapstoneProject.repository.UsersRepository;
import com.github.javafaker.Faker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PrenotazioneRunner implements CommandLineRunner {

	@Autowired
	private PrenotazioneRepository prenotazioneRepo;
	@Autowired
	private CampoRepository campoRepo;
	@Autowired
	private UsersRepository utenteRepo;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker(new Locale("it"));
		LocalDateTime data = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalTime starTime = LocalTime.of(16, 0);
		LocalTime endTime = LocalTime.of(23, 0);

//		List<Campo> campoDb = campoRepo.findAll();
//		List<User> userDb = utenteRepo.findAll();

		for (int i = 0; i < 5; i++) {
			data = data.plusDays(2).truncatedTo(ChronoUnit.MINUTES);
			LocalTime randTime = getRandomTime(starTime, endTime);

			LocalDateTime dataPrenotata = data.with(randTime);

			String dataFormat = dataPrenotata.format(formatter);
			Stato stato = faker.options().option(Stato.class);
//			Campo randomCampo = campoDb.get(faker.random().nextInt(campoDb.size()));
//			User randUser = userDb.get(faker.random().nextInt(userDb.size()));

			Prenotazione prenotazione = new Prenotazione(dataPrenotata, stato);

			prenotazioneRepo.save(prenotazione);

			// Incrementa l'orario di inizio e di fine di 30 minuti
			starTime = starTime.plusMinutes(30);
			endTime = endTime.plusMinutes(30);

		}
	}

	private LocalTime getRandomTime(LocalTime starTime, LocalTime endTime) {
		int startMinutes = starTime.getHour() * 60 + starTime.getMinute();
		int endMinutes = endTime.getHour() * 60 + endTime.getMinute();

		int range = (endMinutes - startMinutes) / 30;
		if (range <= 0) {
			range = 1; // Imposta un limite minimo di 1 se l'intervallo è negativo o zero
		}

		int randomRange = ThreadLocalRandom.current().nextInt(range);
		int randomMinutes = startMinutes + (randomRange * 30);

		int hours = randomMinutes / 60;
		int minutes = randomMinutes % 60;

		return LocalTime.of(hours % 24, minutes);
	}
}
