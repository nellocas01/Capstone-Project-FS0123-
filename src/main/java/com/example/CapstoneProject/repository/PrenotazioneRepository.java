package com.example.CapstoneProject.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CapstoneProject.entities.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {

//	@Query("INSERT INTO Prenotazione (campo, data, stato, utente, id) " + "SELECT c, :data, :stato, u, :id "
//			+ "FROM Campo c, User u " + "WHERE c.id = :campoId "
//			+ "AND NOT EXISTS (SELECT 1 FROM Prenotazione p WHERE p.campo.id = :campoId)")
//	void insertCampo(@Param("campoId") UUID campoId, @Param("data") LocalDateTime data, @Param("stato") Stato stato,
//			@Param("id") UUID id);

}