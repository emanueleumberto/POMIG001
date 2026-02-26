/*
Traccia Esercizio DDL + DML

Progettazione e gestione completa di un database
Realizzare un database relazionale completo utilizzando istruzioni SQL DDL e DML, applicando correttamente:
-> creazione e modifica dello schema
-> definizione di vincoli
-> relazioni One-to-One, One-to-Many e Many-to-Many
-> inserimento e gestione dei dati di esempio

Si vuole sviluppare un database per la gestione di una piattaforma di corsi online.
La piattaforma deve gestire:
- utenti iscritti
- profili utente
- corsi disponibili
- lezioni dei corsi
- iscrizioni ai corsi

Tabella users
Contiene gli utenti della piattaforma.
Campi: id (PK) - nome - cognome - email (UNIQUE) - data_registrazione

Tabella profiles
Ogni utente possiede un solo profilo.
Campi: id (PK) - user_id (FK UNIQUE) - bio - avatar_url

Tabella courses
Elenco corsi disponibili.
Campi: id (PK) - titolo - descrizione - prezzo - docente

Alter Table -> livello ['Base', 'Intermedio', 'Avanzato'] Default 'Base'

Tabella lessons
Un corso contiene più lezioni.
Campi: id (PK) - course_id (FK) - titolo - durata_minuti - ordine

Tabella enrollments
Un utente può iscriversi a più corsi e un corso può avere più utenti.
Campi: user_id (FK) - course_id (FK) - data_iscrizione

Operazioni DML richieste
Inserimento dati
Inserire almeno:
- 5 utenti
- 5 profili
- 3 corsi
- 10 lezioni totali
- iscrizioni multiple utenti-corsi

Manipolazione dati

Eseguire:
- aggiornamento email di un utente (UPDATE)
- modifica prezzo di un corso
- cancellazione di una iscrizione (DELETE)

*/

CREATE DATABASE IF NOT EXISTS online_courses;
USE online_courses;

-- id (PK) - nome - cognome - email (UNIQUE) - data_registrazione
CREATE TABLE IF NOT EXISTS online_courses.users (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    data_registrazione DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- id (PK) - user_id (FK UNIQUE) - bio - avatar_url
CREATE TABLE IF NOT EXISTS online_courses.profiles (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    bio TEXT,
    avatar_url VARCHAR(255),
    user_id INT NOT NULL UNIQUE,
    CONSTRAINT fk_profile_user 
		FOREIGN KEY(user_id) 
        REFERENCES online_courses.users(id) 
        ON UPDATE CASCADE 
        ON DELETE CASCADE 
);

-- id (PK) - titolo - descrizione - prezzo - docente
CREATE TABLE IF NOT EXISTS online_courses.courses (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titolo VARCHAR(100) NOT NULL,
    descrizione TEXT,
    prezzo DECIMAL(8,2) NOT NULL,
    docente VARCHAR(100) NOT NULL
);

-- livello ['Base', 'Intermedio', 'Avanzato'] Default 'Base'
ALTER TABLE online_courses.courses 
	ADD COLUMN livello ENUM('Base', 'Intermedio', 'Avanzato') DEFAULT 'Base';
    
-- id (PK) - course_id (FK) - titolo - durata_minuti - ordine
CREATE TABLE IF NOT EXISTS online_courses.lessons (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titolo VARCHAR(100) NOT NULL,
    durata_minuti INT NOT NULL,
    ordine INT NOT NULL,
	course_id INT NOT NULL,
    CONSTRAINT fk_lesson_course 
		FOREIGN KEY(course_id) 
        REFERENCES online_courses.courses(id) 
        ON UPDATE CASCADE 
        ON DELETE CASCADE 
);

-- user_id (FK) - course_id (FK) - data_iscrizione
CREATE TABLE IF NOT EXISTS online_courses.enrollments (
    user_id INT NOT NULL,
    course_id INT NOT NULL,
    data_iscrizione DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_user_course PRIMARY KEY(user_id, course_id), -- impedisce doppie iscrizioni allo stesso corso da parte dello stesso utente

	CONSTRAINT fk_enroll_user 
		FOREIGN KEY(user_id) 
        REFERENCES online_courses.users(id) 
        ON UPDATE CASCADE 
        ON DELETE CASCADE,
	CONSTRAINT fk_enroll_course
		FOREIGN KEY(course_id) 
        REFERENCES online_courses.courses(id) 
        ON UPDATE CASCADE 
        ON DELETE CASCADE
);


INSERT INTO online_courses.users (nome, cognome, email) VALUES
('Mario','Rossi','mario@email.com'),
('Luca','Bianchi','luca@email.com'),
('Anna','Verdi','anna@email.com'),
('Giulia','Neri','giulia@email.com'),
('Paolo','Gialli','paolo@email.com');

INSERT INTO online_courses.users (nome, cognome, email) VALUES
('Francesca','Viola','francesca@email.com');

INSERT INTO online_courses.profiles (user_id, bio, avatar_url) VALUES
(1,'Sviluppatore backend','avatar1.png'),
(2,'Frontend developer','avatar2.png'),
(3,'Data analyst','avatar3.png'),
(4,'Studentessa informatica','avatar4.png'),
(5,'DevOps engineer','avatar5.png');

INSERT INTO online_courses.courses (titolo, descrizione, prezzo, docente, livello) VALUES
('MySQL Base','Introduzione ai database',49.99,'Marco Dev','Base'),
('Java Spring','Backend avanzato',89.99,'Laura Code','Intermedio'),
('React Completo','Frontend moderno',79.99,'Gianni Web','Avanzato'),
('Javascript','Frontend classico',59.99,'Gianni Web','Intermedio');

INSERT INTO online_courses.lessons (course_id, titolo, durata_minuti, ordine) VALUES
(1,'Introduzione DB',20,1),(1,'SELECT base',30,2),(1,'JOIN',40,3),
(2,'Spring Intro',25,1),(2,'Dependency Injection',35,2),(2,'REST API',45,3),
(3,'React Intro',20,1),(3,'Componenti',30,2),(3,'Hooks',35,3),(3,'Routing',40,4);

INSERT INTO online_courses.enrollments (user_id, course_id) VALUES
(1,1),(1,2),(2,1),(3,3),(4,2),(5,1),(5,3);

-- Query sul database online_courses
/*

1 - Elenco utenti registrati: 
Visualizzare nome, cognome ed email di tutti gli utenti.
Ordinare per cognome in ordine alfabetico.

2 - Corsi con prezzo superiore a 60€
Mostrare titolo e prezzo dei corsi con prezzo maggiore di 60.
Ordinare dal più costoso al meno costoso.

3 - Lezioni di durata superiore a 30 minuti
Visualizzare titolo lezione e durata.
Ordinare per durata decrescente.

4 Numero totale di utenti registrati
Restituire il conteggio totale degli utenti.

5 Prezzo medio dei corsi
Calcolare il prezzo medio dei corsi presenti.

6 Numero di lezioni per ogni corso
Mostrare id corso e numero lezioni associate.

7 Utenti con informazioni del profilo
Mostrare nome utente e bio del profilo.

8 Elenco lezioni con titolo del corso
Visualizzare: titolo corso, titolo lezione, ordine lezione

9 Utenti iscritti ai corsi
Mostrare: nome utente, titolo corso, data iscrizione

10 Numero iscritti per corso
Mostrare titolo corso e numero totale iscritti.
Includere anche corsi senza iscritti.

11 Utenti con numero di corsi frequentati
Mostrare nome utente e totale corsi frequentati.
Ordinare dal più attivo al meno attivo.

12 Durata totale delle lezioni per ogni corso
Calcolare la somma dei minuti di tutte le lezioni appartenenti allo stesso corso.

13 Corsi con prezzo superiore alla media
Mostrare i corsi il cui prezzo è maggiore del prezzo medio di tutti i corsi.

14 Utenti iscritti ad almeno un corso avanzato
Usare una subquery per filtrare gli utenti.
Non usare JOIN diretti nella query principale.

15 Utente/i iscritti al maggior numero di corsi
Restituire l’utente (o utenti) con il massimo numero di iscrizioni.
*/


-- 1 - Elenco utenti registrati: 
-- Visualizzare nome, cognome ed email di tutti gli utenti.
-- Ordinare per cognome in ordine alfabetico.
SELECT nome, cognome,email FROM online_courses.users ORDER BY cognome ASC;

-- 2 - Corsi con prezzo superiore a 60€
-- Mostrare titolo e prezzo dei corsi con prezzo maggiore di 60.
-- Ordinare dal più costoso al meno costoso.
SELECT titolo, prezzo FROM online_courses.courses WHERE prezzo > 60 ORDER BY prezzo DESC;

-- 3 - Lezioni di durata superiore a 30 minuti
-- Visualizzare titolo lezione e durata.
-- Ordinare per durata decrescente.
SELECT titolo, durata_minuti FROM online_courses.lessons WHERE durata_minuti > 30 ORDER BY durata_minuti DESC;

-- 4 Numero totale di utenti registrati
-- Restituire il conteggio totale degli utenti.
SELECT COUNT(*) AS totale_utenti FROM online_courses.users;

-- 5 Prezzo medio dei corsi
-- Calcolare il prezzo medio dei corsi presenti.
SELECT AVG(prezzo) AS prezzo_medio FROM online_courses.courses;

-- 6 Numero di lezioni per ogni corso
-- Mostrare id corso e numero lezioni associate.
SELECT course_id, COUNT(*) FROM online_courses.lessons GROUP BY course_id;

-- 7 Utenti con informazioni del profilo
-- Mostrare nome utente e bio del profilo.
SELECT u.nome, u.cognome, p.bio 
	FROM online_courses.users AS u
    JOIN online_courses.profiles AS p
    ON u.id = p.user_id;

-- 8 Elenco lezioni con titolo del corso
-- Visualizzare: titolo corso, titolo lezione, ordine lezione
SELECT c.titolo AS titolo_corso, l.titolo AS titolo_lezione , l.ordine
	FROM online_courses.courses AS c
	JOIN online_courses.lessons AS l
    ON c.id = l.course_id
    ORDER BY c.titolo, l.ordine;

-- 9 Utenti iscritti ai corsi
-- Mostrare: nome utente, titolo corso, data iscrizione
SELECT u.nome, u.cognome, c.titolo, e.data_iscrizione 
	FROM online_courses.users AS u
    JOIN online_courses.enrollments AS e ON e.user_id = u.id
    JOIN online_courses.courses AS c ON e.course_id = c.id;

-- 10 Numero iscritti per corso
-- Mostrare titolo corso e numero totale iscritti.
-- Includere anche corsi senza iscritti.
SELECT c.titolo, COUNT(e.user_id) AS numero_iscritti
	FROM online_courses.courses AS c
    LEFT JOIN online_courses.enrollments AS e ON c.id = e.course_id
    GROUP BY c.titolo;

-- 11 Utenti con numero di corsi frequentati
-- Mostrare nome utente e totale corsi frequentati.
-- Ordinare dal più attivo al meno attivo.
SELECT u.nome, u.cognome, COUNT(e.course_id) AS corsi_frequentati
	FROM online_courses.users AS u
    LEFT JOIN online_courses.enrollments AS e ON e.user_id = u.id
    GROUP BY u.id
    ORDER BY corsi_frequentati DESC;

-- 12 Durata totale delle lezioni per ogni corso
-- Calcolare la somma dei minuti di tutte le lezioni appartenenti allo stesso corso.
SELECT c.titolo, SUM(l.durata_minuti) AS durata_totale
	FROM online_courses.courses AS c
    LEFT JOIN online_courses.lessons AS l ON l.course_id = c.id
    GROUP BY c.id;

-- 13 Corsi con prezzo superiore alla media
-- Mostrare i corsi il cui prezzo è maggiore del prezzo medio di tutti i corsi.
SELECT c.titolo, c.prezzo
	FROM online_courses.courses AS c 
    WHERE c.prezzo > (SELECT AVG(prezzo) 
						FROM online_courses.courses);

-- 14 Utenti iscritti ad almeno un corso avanzato
-- Usare una subquery per filtrare gli utenti.
-- Non usare JOIN diretti nella query principale.

-- Calcolo i corsi 'avanzati'
SELECT user_id 
	FROM online_courses.courses AS c 
    JOIN online_courses.enrollments AS e ON e.course_id = c.id 
    WHERE c.livello = 'Avanzato';
    
-- Soluzione con SubQuery
SELECT u.nome, u.cognome 
	FROM online_courses.users AS u 
    WHERE u.id IN (
			SELECT user_id 
			FROM online_courses.courses AS c 
			JOIN online_courses.enrollments AS e ON e.course_id = c.id 
			WHERE c.livello = 'Avanzato'
	);
    
-- Soluzione con il JOIN
SELECT u.nome, u.cognome 
	FROM online_courses.courses AS c 
    JOIN online_courses.enrollments AS e ON e.course_id = c.id 
    JOIN online_courses.users AS u ON e.user_id = u.id
    WHERE c.livello = 'Avanzato';

-- 15 Utente/i iscritti al maggior numero di corsi
-- Restituire l’utente (o utenti) con il massimo numero di iscrizioni.

-- Calcolo il numero di iscrizioni per ogni utente
SELECT COUNT(*) AS totale FROM online_courses.enrollments AS e GROUP BY e.user_id;
-- Calcolo il numero maggiore di iscrizioni
SELECT MAX(totale) 
	FROM (
		SELECT COUNT(*) AS totale 
        FROM online_courses.enrollments AS e 
        GROUP BY e.user_id
	) AS sub;

-- Calcolo gli utenti iscritti al maggior numero di corsi
SELECT u.nome, u.cognome, COUNT(*) AS totale_corsi
	FROM online_courses.users AS u
	JOIN online_courses.enrollments AS e ON e.user_id = u.id
    GROUP BY e.user_id
    HAVING COUNT(*) = (SELECT MAX(totale) 
						FROM (
							SELECT COUNT(*) AS totale 
							FROM online_courses.enrollments AS e 
							GROUP BY e.user_id
							) AS sub
						);



