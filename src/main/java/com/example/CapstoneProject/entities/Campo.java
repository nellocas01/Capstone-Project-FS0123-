//package com.example.CapstoneProject.entities;
//
//import java.util.List;
//import java.util.UUID;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "campo")
//@Data
//@NoArgsConstructor
//
//public class Campo {
//	@Id
//	@GeneratedValue
//	private UUID id;
//	private String nome;
//	private String citta;
//	private String indirizzo;
//	private int dimensioni;
//
//	@OneToMany(mappedBy = "campo")
//	private List<Partita> partite;
//
//	@OneToMany(mappedBy = "campo")
//	private List<Prenotazione> prenotazioni;
//
//	public Campo(String nome, String citta, String indirizzo, int dimensioni, User utente) {
//		super();
//		this.nome = nome;
//		this.citta = citta;
//		this.indirizzo = indirizzo;
//		this.dimensioni = dimensioni;
//	}
//
//}