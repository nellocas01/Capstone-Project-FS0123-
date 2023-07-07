package com.example.CapstoneProject.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
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

	@OneToOne
	@NonNull
	private Campo campo;

	@ManyToOne
	@NonNull
	private User utente;

	public Prenotazione(LocalDateTime data) {
		super();
		this.data = data;
	}

}
