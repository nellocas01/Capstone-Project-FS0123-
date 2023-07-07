package com.example.CapstoneProject.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.CapstoneProject.entities.Prenotazione;
import com.example.CapstoneProject.exceptions.NotFoundException;
import com.example.CapstoneProject.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {
	@Autowired
	private PrenotazioneRepository prenotazioneRepo;

	public Prenotazione createPrenotazione(Prenotazione prenotazione) {
		Prenotazione newPrenotazione = new Prenotazione(prenotazione.getData(), prenotazione.getStato());
		newPrenotazione.setCampo(prenotazione.getCampo());
		newPrenotazione.setUtente(prenotazione.getUtente());

		return prenotazioneRepo.save(newPrenotazione);
	}

	// ***** READ *****
	public Page<Prenotazione> getAllPrenotazioni(int page, int size, String sortBy) {
		if (size < 0)
			size = 0;
		if (size > 100)
			size = 100;

		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return prenotazioneRepo.findAll(pageable);
	}

	// read by Id
	public Prenotazione getPrenotazioneById(UUID prenotazioneId) throws NotFoundException {
		return prenotazioneRepo.findById(prenotazioneId)
				.orElseThrow(() -> new NotFoundException("Prenotazione non trovata!"));

	}

	public Prenotazione updatePrenotazione(UUID id, Prenotazione prenotazione) throws NotFoundException {
		Prenotazione prenotazioneFound = this.getPrenotazioneById(id);

		prenotazioneFound.setId(id);
		prenotazioneFound.setData(prenotazione.getData());
		// prenotazioneFound.setCampo(prenotazione.getCampo());
		// prenotazioneFound.setUtente(prenotazione.getUtente());
		return prenotazioneRepo.save(prenotazioneFound);
	}

	public void deletePrenotazione(UUID prenotazioneId) throws NotFoundException {
		Prenotazione prenotazioneFound = this.getPrenotazioneById(prenotazioneId);

		prenotazioneRepo.delete(prenotazioneFound);

	}
}
