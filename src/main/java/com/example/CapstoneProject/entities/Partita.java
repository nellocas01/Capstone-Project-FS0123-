//package com.example.CapstoneProject.entities;
//
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "partita")
//@Data
//@NoArgsConstructor
//public class Partita {
//	@Id
//	@GeneratedValue
//	private UUID id;
//	private Date data;
//	private String durata;
//	private int numPartecipanti;
//	@Enumerated(EnumType.STRING)
//	private Livello livello;
//	@Enumerated(EnumType.STRING)
//	private Stato stato;
//
//	@OneToMany(mappedBy = "partita")
//	private List<Recensione> recensioni;
//
//	@ManyToMany
//	@JoinTable(name = "partita_utenti", joinColumns = @JoinColumn(name = "partita_id"), inverseJoinColumns = @JoinColumn(name = "utente_id"))
//	private List<User> utenti;
//
//	@ManyToOne
//	private Campo campo;
//
//	@ManyToMany(mappedBy = "partite")
//	private Squadra squadra;
//
//	public Partita(Date data, String durata, int numPartecipanti, Livello livello, Stato stato) {
//		super();
//		this.data = data;
//		this.durata = durata;
//		this.numPartecipanti = numPartecipanti;
//		this.livello = livello;
//		this.stato = stato;
//	}
//
//}
