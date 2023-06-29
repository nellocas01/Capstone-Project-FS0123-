//package com.example.CapstoneProject.services;
//
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import com.example.CapstoneProject.entities.Squadra;
//import com.example.CapstoneProject.exceptions.NotFoundException;
//import com.example.CapstoneProject.repository.SquadraRepository;
//
//@Service
//public class SquadraService {
//	@Autowired
//	private SquadraRepository squadraRepo;
//
//	public Squadra createSquadra(Squadra s) {
//		Squadra newSquadra = new Squadra(s.getNome(), s.getStato(), s.getGiocatori());
//		return squadraRepo.save(newSquadra);
//	}
//
//	public Page<Squadra> getAllSquadre(int page, int size, String sortBy) {
//		if (size < 0)
//			size = 0;
//		if (size > 100)
//			size = 100;
//
//		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
//
//		return squadraRepo.findAll(pageable);
//	}
//
//	public Squadra getSquadraById(UUID id) throws NotFoundException {
//		return squadraRepo.getSquadraById(id);
//	}
//
//	public Squadra updateSquadra(UUID id, Squadra s) throws NotFoundException {
//		Squadra squadraFound = this.getSquadraById(id);
//
//		squadraFound.setId(id);
//		squadraFound.setNome(s.getNome());
//		squadraFound.setStato(s.getStato());
//		squadraFound.setGiocatori(s.getGiocatori());
//
//		return squadraRepo.save(squadraFound);
//	}
//
//	public void deleteSquadra(UUID id) throws NotFoundException {
//		Squadra squadraFound = this.getSquadraById(id);
//		squadraRepo.delete(squadraFound);
//	}
//
//}
