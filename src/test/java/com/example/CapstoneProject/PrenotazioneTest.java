package com.example.CapstoneProject;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.CapstoneProject.entities.Campo;
import com.example.CapstoneProject.entities.Prenotazione;
import com.example.CapstoneProject.entities.Stato;
import com.example.CapstoneProject.entities.User;

public class PrenotazioneTest {

	@Test
	public void testPrenotazioneConstructor() {
		// Crea un oggetto Campo per la relazione ManyToOne
		Campo campo = new Campo("Campo 1", "Via Campo 123");

		// Crea un oggetto User per la relazione ManyToOne
		User utente = new User("Nome", "Cognome", "username", "email@example.com", "password");

		// Crea un oggetto Prenotazione utilizzando il costruttore con i parametri data
		// e stato
		LocalDateTime data = LocalDateTime.now();
		Stato stato = Stato.CONFERMATA;
		Prenotazione prenotazione = new Prenotazione(data, stato);
		prenotazione.setId(UUID.randomUUID());
		prenotazione.setCampo(campo);
		prenotazione.setUtente(utente);

		// Verifica che gli attributi data e stato siano impostati correttamente
		Assertions.assertEquals(data, prenotazione.getData());
		Assertions.assertEquals(stato, prenotazione.getStato());
	}

	@Test
	public void testPrenotazioneSettersAndGetters() {
		// Crea un oggetto Prenotazione
		Prenotazione prenotazione = new Prenotazione();

		// Imposta i valori degli attributi utilizzando i metodi setter
		LocalDateTime data = LocalDateTime.now();
		Stato stato = Stato.IN_ATTESA;
		prenotazione.setData(data);
		prenotazione.setStato(stato);

		// Verifica che gli attributi siano impostati correttamente utilizzando i metodi
		// getter
		Assertions.assertEquals(data, prenotazione.getData());
		Assertions.assertEquals(stato, prenotazione.getStato());
	}
}
