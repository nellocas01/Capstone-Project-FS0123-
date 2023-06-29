//package com.example.CapstoneProject.controllers;
//
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.CapstoneProject.entities.Squadra;
//import com.example.CapstoneProject.services.SquadraService;
//
//@RestController
//@RequestMapping("/squadra")
//@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
//public class SquadraController {
//
//	@Autowired
//	SquadraService squadraService;
//
//	@GetMapping("")
//	public Page<Squadra> getAllSquadre(@RequestParam(defaultValue = "0") int page,
//			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
//		return squadraService.getAllSquadre(page, size, sortBy);
//	}
//
//	@GetMapping("/{id}")
//	public Squadra getSquadraById(@PathVariable UUID id) throws Exception {
//		return squadraService.getSquadraById(id);
//	}
//
//	@PostMapping("")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Squadra createSquadra(@RequestBody @Validated Squadra squadra) {
//		return squadraService.createSquadra(squadra);
//	}
//
//	@PutMapping("/{id}")
//	public Squadra updateSquadra(@PathVariable UUID id, @RequestBody Squadra squadra) throws Exception {
//		return squadraService.updateSquadra(id, squadra);
//	}
//
//	@DeleteMapping("/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void deleteSquadra(@PathVariable UUID id) throws Exception {
//		squadraService.deleteSquadra(id);
//	}
//}
