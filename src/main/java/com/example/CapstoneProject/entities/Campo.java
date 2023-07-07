package com.example.CapstoneProject.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

	public Campo(String nome, String indirizzo) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
	}

}
