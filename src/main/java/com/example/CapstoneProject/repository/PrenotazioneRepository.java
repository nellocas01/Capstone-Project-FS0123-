package com.example.CapstoneProject.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CapstoneProject.entities.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {

	// Qui puoi definire metodi personalizzati per eseguire query specifiche, se
	// necessario
}