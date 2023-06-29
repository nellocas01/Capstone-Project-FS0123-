//package com.example.CapstoneProject;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Locale;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.example.CapstoneProject.entities.Squadra;
//import com.example.CapstoneProject.entities.Stato;
//import com.example.CapstoneProject.entities.User;
//import com.example.CapstoneProject.repository.SquadraRepository;
//import com.example.CapstoneProject.repository.UsersRepository;
//import com.github.javafaker.Faker;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Component
////order
//public class SquadraRunner implements CommandLineRunner {
//
//	@Autowired
//	private SquadraRepository squadraRepo;
//	@Autowired
//	private UsersRepository utenteRepo;
//
//	@Override
//	public void run(String... args) throws Exception {
//		Faker faker = new Faker(new Locale("it"));
//		List<Squadra> squadraDb = squadraRepo.findAll();
//		List<User> userDb = utenteRepo.findAll();
//
////		int numberOfSquadreToGenerate = 10; // Numero desiderato di squadre da generare
////
////		if (squadraDb.size() < numberOfSquadreToGenerate) {
////			int squadreToGenerate = numberOfSquadreToGenerate - squadraDb.size();
////
////			for (int i = 0; i < squadreToGenerate; i++) { cosi facendo neanche 1 squadra genera
//
//		if (squadraDb.size() == 0) {
//			for (int i = 0; i < 20; i++) {// cosi facendo mi genera 1 sola squadra
//				try {
//
//					String nome = faker.funnyName().name();
//					Stato stato = faker.options().option(Stato.class);
//					// List<User> randomUser = faker.random().elements(userDb,
//					// faker.number().numberBetween(1, 5));
////					List<User> randomUsers = new ArrayList<>();
////					int numPlayers = faker.random().numberBetween(1, 5);
////					for (int j = 0; j < numPlayers; j++) {
////						int randomIndex = faker.random().nextInt(userDb.size());
////						User randomUser = userDb.get(randomIndex);
////						randomUsers.add(randomUser);
////					}
//					// int numPlayers = faker.random().nextInt(1, 6); // Genera un numero casuale
//					// tra 1 e 5 (inclusi)
////					List<User> randomUsers = faker.random().elements(userDb, numPlayers);
//
//					int numPlayers = faker.random().nextInt(1, 6); // Genera un numero casuale tra 1 e 5 (inclusi)
//					List<User> randomUsers = new ArrayList<>(userDb); // Crea una copia della lista userDb
//					Collections.shuffle(randomUsers); // Mescola la lista randomUsers in modo casuale
//					randomUsers = randomUsers.subList(0, numPlayers); // Seleziona i primi numPlayers elementi
//
//					Squadra newSquadra = new Squadra(nome, stato, randomUsers);
//					squadraRepo.save(newSquadra);
//
//				} catch (Exception e) {
//					System.out.println(e);
//				}
//			}
//		}
//
//	}
//
//}
