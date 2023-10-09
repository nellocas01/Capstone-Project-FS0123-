package com.example.CapstoneProject.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.CapstoneProject.entities.Role;
import com.example.CapstoneProject.entities.User;
import com.example.CapstoneProject.exceptions.BadRequestException;
import com.example.CapstoneProject.exceptions.NotFoundException;
import com.example.CapstoneProject.repository.RoleRepository;
import com.example.CapstoneProject.repository.UsersRepository;
import com.example.CapstoneProject.users.payload.UserCreatePayload;

@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepo;

	@Autowired
	private RoleRepository roleRepo;

	public User create(UserCreatePayload u) {
		usersRepo.findByEmail(u.getEmail()).ifPresent(user -> {
			throw new BadRequestException("Email " + user.getEmail() + " already in use!");
		});
		User newUser = new User(u.getName(), u.getSurname(), u.getUsername(), u.getEmail(), u.getPassword());

		Role roleDefault = roleRepo.findByNome("USER")
				.orElseThrow(() -> new NotFoundException("Ruolo USER non esiste!!"));
		newUser.getRoles().add(roleDefault);

		return usersRepo.save(newUser);
	}

	public Page<User> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return usersRepo.findAll(pageable);
	}

	public User findById(UUID id) throws NotFoundException {
		return usersRepo.findById(id).orElseThrow(() -> new NotFoundException("Utete con Id:" + id + "non trovato!!"));
	}

	public User findByEmail(String email) throws NotFoundException {
		return usersRepo.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("Utete con email:" + email + "non trovato!!"));
	}

	public User findByUsername(String username) throws NotFoundException {
		return usersRepo.findByUsername(username)
				.orElseThrow(() -> new NotFoundException("Utete:" + username + "non trovato!!"));
	}

	public User findByIdAndUpdate(UUID id, UserCreatePayload u) throws NotFoundException {
		User found = this.findById(id);

		found.setId(id);
		found.setName(u.getName());
		found.setSurname(u.getSurname());
		found.setEmail(u.getEmail());

		return usersRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		User found = this.findById(id);
		usersRepo.delete(found);
	}

}
