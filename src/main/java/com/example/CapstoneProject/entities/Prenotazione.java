package com.example.CapstoneProject.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prenotazione")
@Data
@NoArgsConstructor

public class Prenotazione {
	@Id
	@GeneratedValue
	private UUID id;
	private Date data;
	@OneToOne
	@JoinColumn(name = "campo_id")
	private Campo campo;

//	@OneToMany(mappedBy = "prenotazione")
//	private List<Squadra> squadre;

	@ManyToOne
	@JoinColumn(name = "utente_id")
	private User utente;

//	@Enumerated(EnumType.STRING)
//	private Stato stato;

	public Prenotazione(Date data) {
		super();
		this.data = data;
//		this.campo = campo;
//		this.utente = utente;
	}

}
