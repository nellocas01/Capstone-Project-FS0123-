package com.example.CapstoneProject.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CapstoneProject.entities.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {

//	@Query("UPDATE prenotazione SET campo_id = (SELECT id FROM campo)")
//	void updateIdCampo();
//	public Page<Prenotazione> findByUserAndDataPrenotata(User user, LocalDate dataPrenotata, Pageable pageable);
//
//	public Page<Campo> findByUser(User user, Pageable pageable);

}