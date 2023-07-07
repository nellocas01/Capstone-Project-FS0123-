package com.example.CapstoneProject.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prenotazione")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prenotazione {
	@Id
	@GeneratedValue
	private UUID id;
	private LocalDateTime data;
	@Enumerated(EnumType.STRING)
	private Stato stato;

	@OneToOne
	private Campo campo;

	@ManyToOne
	private User utente;

	public Prenotazione(LocalDateTime data, Stato stato) {
		super();
		this.data = data;
		this.stato = stato;
	}

}
