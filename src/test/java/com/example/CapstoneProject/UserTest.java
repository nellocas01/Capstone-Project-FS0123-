package com.example.CapstoneProject;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.CapstoneProject.entities.Role;
import com.example.CapstoneProject.entities.User;

public class UserTest {

	@Test
	public void testUserConstructor() {
		// Crea un oggetto User utilizzando il costruttore con i parametri name,
		// surname, username, email e password
		String name = "John";
		String surname = "Doe";
		String username = "johndoe";
		String email = "johndoe@example.com";
		String password = "password123";
		User user = new User(name, surname, username, email, password);
		user.setId(UUID.randomUUID());

		// Verifica che gli attributi name, surname, username, email e password siano
		// impostati correttamente
		Assertions.assertEquals(name, user.getName());
		Assertions.assertEquals(surname, user.getSurname());
		Assertions.assertEquals(username, user.getUsername());
		Assertions.assertEquals(email, user.getEmail());
		Assertions.assertEquals(password, user.getPassword());
	}

	@Test
	public void testUserRoles() {
		// Crea un oggetto User
		User user = new User();

		// Crea un set di ruoli
		Set<Role> roles = new HashSet<>();
		Role role1 = new Role("ROLE_ADMIN");
		Role role2 = new Role("ROLE_USER");
		roles.add(role1);
		roles.add(role2);

		// Imposta i ruoli utilizzando il metodo setter
		user.setRoles(roles);

		// Verifica che i ruoli siano impostati correttamente utilizzando il metodo
		// getter
		Assertions.assertEquals(roles, user.getRoles());
	}
}
