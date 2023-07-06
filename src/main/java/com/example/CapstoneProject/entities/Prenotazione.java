package com.example.CapstoneProject.entities;

import java.time.LocalDate;
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
	private LocalDate data;

//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // oppure relazionarlo col nome
//	@JoinColumn(name = "campo_id")
	@OneToOne
	@NonNull
	private Campo campo;

//	@OneToMany(mappedBy = "prenotazione")
//	private List<Squadra> squadre;

//	@ManyToOne(fetch = FetchType.LAZY) // oppure relazionarlo col nome
//	@JoinColumn(name = "utente_id")
	@ManyToOne
	@NonNull
	private User utente;

//	@Enumerated(EnumType.STRING)
//	private Stato stato;

	public Prenotazione(LocalDate data) {
		super();
		this.data = data;
//		this.campo = campo;
//		this.utente = utente;
	}

}
