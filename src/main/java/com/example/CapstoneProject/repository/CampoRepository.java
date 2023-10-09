package com.example.CapstoneProject.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CapstoneProject.entities.Campo;

@Repository
public interface CampoRepository extends JpaRepository<Campo, UUID> {
	List<Campo> findByNome(String nome);

	Campo getCampoById(UUID id);

}
