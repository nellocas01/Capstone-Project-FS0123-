package com.example.CapstoneProject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.CapstoneProject.entities.Prenotazione;
import com.example.CapstoneProject.repository.CampoRepository;
import com.example.CapstoneProject.repository.PrenotazioneRepository;
import com.example.CapstoneProject.repository.UsersRepository;

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
		LocalDate data = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		for (int i = 0; i < 5; i++) {
			data = data.plusDays(2);
			LocalDate dataPrenotata = data;

			String dataFormat = dataPrenotata.format(formatter);

			Prenotazione prenotazione = new Prenotazione(dataPrenotata);

			prenotazioneRepo.save(prenotazione);

		}
	}
}
