package com.example.CapstoneProject.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.CapstoneProject.entities.Campo;
import com.example.CapstoneProject.services.CampoService;

@RestController
@RequestMapping("/campi")
public class CampoController {

	@Autowired
	CampoService campoService;

	@GetMapping("")
	public Page<Campo> getAllCampi(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return campoService.getAllCampi(page, size, sortBy);
	}

	@GetMapping("/{id}")
	public Campo getCampoById(@PathVariable UUID id) throws Exception {
		return campoService.getCampoById(id);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Campo createCampo(@RequestBody @Validated Campo campo) {
		return campoService.createCampo(campo);
	}

	@PutMapping("/{id}")
	public Campo updateCampo(@PathVariable UUID id, @RequestBody Campo campo) throws Exception {
		return campoService.updateCampo(id, campo);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCampo(@PathVariable UUID id) throws Exception {
		campoService.deleteCampo(id);
	}
}
