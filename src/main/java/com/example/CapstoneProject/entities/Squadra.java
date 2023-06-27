//package com.example.CapstoneProject.entities;
//
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
//import jakarta.persistence.Table;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "squadra")
//@Data
//@NoArgsConstructor
//
//public class Squadra {
//	@Id
//	@GeneratedValue
//	private UUID id;
//	private String nome;
//	@Enumerated(EnumType.STRING)
//	private Livello livello;
//
//	@ManyToMany
//	@JoinTable(name = "squadra_giocatore", joinColumns = @JoinColumn(name = "squadra_id"), inverseJoinColumns = @JoinColumn(name = "giocatore_id"))
//	private List<User> giocatori;
//
//	@ManyToMany(mappedBy = "squadre")
//	private List<Partita> partite;
//
//	public Squadra(String nome, Livello livello, List<User> giocatori) {
//		super();
//		this.nome = nome;
//		this.livello = livello;
//		this.giocatori = giocatori;
//	}
//
//}
