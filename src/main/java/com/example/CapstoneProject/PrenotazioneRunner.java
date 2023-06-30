package com.example.CapstoneProject;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
//order
public class PrenotazioneRunner implements CommandLineRunner {

	@Autowired
	private PrenotazioneRepository prenotazioneRepo;
	@Autowired
	private CampoRepository campoRepo;
	@Autowired
	private UsersRepository utenteRepo;

	@Override
	public void run(String... args) throws Exception {

		Calendar calendar = new GregorianCalendar();
		for (int i = 0; i < 5; i++) {
			calendar.add(Calendar.DAY_OF_MONTH, 31);
			Date dataPrenotazione = calendar.getTime();

			Prenotazione prenotazione = new Prenotazione(dataPrenotazione);

			prenotazioneRepo.save(prenotazione);

		}
	}
}
