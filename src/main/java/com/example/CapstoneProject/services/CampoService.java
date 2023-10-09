package com.example.CapstoneProject.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.CapstoneProject.entities.Campo;
import com.example.CapstoneProject.exceptions.NotFoundException;
import com.example.CapstoneProject.repository.CampoRepository;

@Service
public class CampoService {

	@Autowired
	private CampoRepository campoRepo;

	public Campo createCampo(Campo campo) {
		Campo newCampo = new Campo(campo.getNome(), campo.getIndirizzo());
		return campoRepo.save(newCampo);
	}

	// ***** READ *****
	public Page<Campo> getAllCampi(int page, int size, String sortBy) {
		if (size < 0)
			size = 0;
		if (size > 100)
			size = 100;

		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return campoRepo.findAll(pageable);
	}

	// read by Id
	public Campo getCampoById(UUID id) throws NotFoundException {
		return campoRepo.findById(id).orElseThrow(() -> new NotFoundException("Campo non trovato"));
	}

	public Campo updateCampo(UUID id, Campo campo) throws NotFoundException {
		Campo campoFound = this.getCampoById(id);

		campoFound.setId(id);
		campoFound.setNome(campo.getNome());
		campoFound.setIndirizzo(campo.getIndirizzo());
		// campoFound.setDimensioni(campo.getDimensioni());

		return campoRepo.save(campoFound);
	}

	public void deleteCampo(UUID id) throws NotFoundException {

		Campo campoFound = this.getCampoById(id);
		campoRepo.delete(campoFound);
	}
}
