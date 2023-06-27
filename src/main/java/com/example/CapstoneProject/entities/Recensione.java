//package com.example.CapstoneProject.entities;
//
//import java.util.UUID;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "recensione")
//@Data
//@NoArgsConstructor
//
//public class Recensione {
//	@Id
//	@GeneratedValue
//	private UUID id;
//	private int valutazione;
//
//	@ManyToOne
//	private Partita partita;
//
//	@ManyToOne
//	private User utente;
//
//	public Recensione(int valutazione, Partita partita, User utente) {
//		super();
//		this.valutazione = valutazione;
//		this.partita = partita;
//		this.utente = utente;
//	}
//
//}
