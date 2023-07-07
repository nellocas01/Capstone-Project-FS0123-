package com.example.CapstoneProject.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Table(name = "campo")
@Data
@NoArgsConstructor

public class Campo {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String indirizzo;

	@OneToMany(mappedBy = "campo")
	private List<Prenotazione> prenotazioni;

	public Campo(String nome, String indirizzo) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
	}

}
