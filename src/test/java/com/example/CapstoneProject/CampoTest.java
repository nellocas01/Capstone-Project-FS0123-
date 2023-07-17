package com.example.CapstoneProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.CapstoneProject.entities.Campo;

public class CampoTest {

	@Test
	public void testCampoConstructor() {
		// Crea un oggetto Campo utilizzando il costruttore con i parametri nome e
		// indirizzo
		String nome = "Campo 1";
		String indirizzo = "Via Campo 123";
		Campo campo = new Campo(nome, indirizzo);

		// Verifica che gli attributi nome e indirizzo siano impostati correttamente
		assertEquals(nome, campo.getNome());
		assertEquals(indirizzo, campo.getIndirizzo());
	}

	@Test
	public void testCampoSettersAndGetters() {
		// Crea un oggetto Campo
		Campo campo = new Campo();

		// Imposta i valori degli attributi utilizzando i metodi setter
		String nome = "Campo 2";
		String indirizzo = "Via Campo 456";
		campo.setNome(nome);
		campo.setIndirizzo(indirizzo);

		// Verifica che gli attributi siano impostati correttamente utilizzando i metodi
		// getter
		assertEquals(nome, campo.getNome());
		assertEquals(indirizzo, campo.getIndirizzo());
	}

	@Test
	public void testCampoIdGeneration() {
		// Crea un oggetto Campo
		Campo campo = new Campo();

		// Verifica che l'ID generato non sia nullo dopo la generazione
		assertNotNull(campo.getId());
	}
}
