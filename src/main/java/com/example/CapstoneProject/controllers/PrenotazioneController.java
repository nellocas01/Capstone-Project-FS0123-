package com.example.CapstoneProject.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.CapstoneProject.entities.Prenotazione;
import com.example.CapstoneProject.services.PrenotazioneService;

@RestController
@RequestMapping("/prenotazioni")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
public class PrenotazioneController {

	@Autowired
	PrenotazioneService prenotazioneService;

	@GetMapping("")
	public Page<Prenotazione> getAllPrenotazioni(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return prenotazioneService.getAllPrenotazioni(page, size, sortBy);
	}

	@GetMapping("/{id}")
	public Prenotazione getPrenotazioneById(@PathVariable UUID id) throws Exception {
		return prenotazioneService.getPrenotazioneById(id);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Prenotazione createPrenotazione(@RequestBody @Validated Prenotazione prenotazione) {
		return prenotazioneService.createPrenotazione(prenotazione);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Prenotazione updatePrenotazione(@PathVariable UUID id, @RequestBody Prenotazione prenotazione)
			throws Exception {
		return prenotazioneService.updatePrenotazione(id, prenotazione);

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ADMIN')")
	public void deletePrenotazione(@PathVariable UUID id) throws Exception {
		prenotazioneService.deletePrenotazione(id);
	}
}
