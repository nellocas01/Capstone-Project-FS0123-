//package com.example.CapstoneProject.entities;
//
//import java.util.Date;
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
//@Table(name = "prenotazione")
//@Data
//@NoArgsConstructor
//
//public class Prenotazione {
//	@Id
//	@GeneratedValue
//	private UUID id;
//	private Date data;
//
//	@ManyToOne
//	private Campo campo;
//
//	@ManyToOne
//	private User utente;
//
//	public Prenotazione(Date data, Campo campo, User utente) {
//		super();
//		this.data = data;
//		this.campo = campo;
//		this.utente = utente;
//	}
//
//}
