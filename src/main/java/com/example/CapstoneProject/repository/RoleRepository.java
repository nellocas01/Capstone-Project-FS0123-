package com.example.CapstoneProject.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CapstoneProject.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

	Optional<Role> findByNome(String nome);

}
