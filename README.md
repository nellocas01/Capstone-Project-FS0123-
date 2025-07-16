# ⚽ StonksBall – Backend

Questo è il repository **Backend** del progetto _StonksBall_, un'applicazione web sviluppata come progetto finale del corso Full Stack Developer EPICODE.  
Il progetto mira a facilitare l'organizzazione di partite di calcetto in modo semplice, dinamico e sicuro.

🔗 **Frontend repository**:  
[https://github.com/nellocas01/Capstone-Project-FS0123-FrontEnd](https://github.com/nellocas01/Capstone-Project-FS0123-FrontEnd)

---

## 🎯 Obiettivi del progetto

- Fornire una piattaforma per la gestione delle partite di calcetto: creazione, partecipazione, visualizzazione.
- Proteggere i dati degli utenti tramite autenticazione sicura (JWT).
- Offrire API RESTful complete per frontend, admin e gestione database.
- Implementare logiche business modulari e scalabili tramite Spring Boot.

---

## ✅ Funzionalità implementate

- **Creazione di partite** con data, ora e luogo
- **Partecipazione a partite** esistenti tramite stato di disponibilità
- **Autenticazione e registrazione** sicura con JWT
- **Ruoli utente (User/Admin)** con permessi differenziati
- **Gestione delle partite** da parte degli admin
- **Integrazione Stripe** (mock) per future funzionalità di pagamento
- **Popolamento dati automatico** tramite Java Faker
- **Import/export CSV** con OpenCSV

---

## 🛠️ Tecnologie & Dipendenze

| Strumento                | Descrizione                               |
|--------------------------|-------------------------------------------|
| **Java 17**              | Linguaggio principale                     |
| **Spring Boot 3.1.1**    | Framework per applicazioni web            |
| **Spring Security**      | Autenticazione e autorizzazione           |
| **Spring Data JPA**      | ORM con Hibernate                         |
| **PostgreSQL**           | Motore di database relazionale            |
| **JWT (jjwt)**           | Token di autenticazione                   |
| **Stripe SDK**           | Integrazione pagamenti (mock)             |
| **OpenCSV**              | Lettura/scrittura file CSV                |
| **Java Faker**           | Generazione dati fittizi per testing      |
| **Lombok**               | Riduzione boilerplate code                |
| **JUnit & Spring Test**  | Testing unitario e di integrazione        |

---


---

## ⚙️ Setup e avvio del progetto

### 1. Clonazione del repository

```bash
git clone https://github.com/nellocas01/Capstone-Project-FS0123-.git
cd Capstone-Project-FS0123-
```

### 2. Installazione PostgreSQL e pgAdmin

Scarica e installa:

PostgreSQL: https://www.postgresql.org/download/

pgAdmin: https://www.pgadmin.org/download/

### 3. Creazione del database

Apri pgAdmin

Connettiti al server PostgreSQL locale

Crea un nuovo database chiamato ad es. DatabaseProgettoClonato

Assicurati che le credenziali corrispondano a quelle specificate nel file env.properties

Avvia il database

###4. Configura il file application.properties o env.properties

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/DatabaseProgettoClonato
spring.datasource.username=tuo_username
spring.datasource.password=tuo_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=stringasegreta
```

### 5. Avvio del progetto (con Maven Wrapper)

```bash
./mvnw spring-boot:run
```

⚠️ Assicurati che la porta 8080 sia libera.


📌 Note aggiuntive

- Tutti gli endpoint sono documentati tramite annotazioni @RestController

- Il progetto è pronto per integrazione con frontend React (vedi repo frontend)

- L’uso di Java Faker consente di popolare dati realistici al boot

- La struttura è pensata per scalabilità e testabilità

# 👨‍💻 Autore
**Aniello Casolla**
- 📧 nellocasolla446@gmail.com
- 📆 Ultimo aggiornamento: Luglio 2023
