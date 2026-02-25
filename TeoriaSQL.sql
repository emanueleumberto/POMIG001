-- Commenti a singola riga
/*
	Commenti
    multi riga
*/

/*
	SQL ha diverse categorie di istruzioni
    DDL -> Data Definition Language
		- Definisce tutte le istruzioni SQL 
          per la creazione e la gestione di un DB
	DML -> Data Manipulation Language
		- Definisce tutte le istruzioni SQL
          per la creazione e gestione delle tabelle
          contenute in un DB
	DQL -> Data Query Language
		- Definisce tutte le istruzioni SQL
          per la lettura dei dati contenuti in un DB
	DCL -> Data Control Language
		- Definisce tutte le istruzioni SQL
          per la gestione e i permessi di un DB
*/		
        
-- DDL -> Data Definition Language
-- Definisce tutte le istruzioni SQL per la creazione e la gestione di un DB

-- CREATE | USE | ALTER (Deprecata) | DROP | SHOW

-- DB --> CREATE | USE | DROP | SHOW
-- CREATE DATABASE [IF NOT EXISTS] db_name;
-- SHOW DATABASES;
-- USE db_name;
-- DROP DATABASE [IF EXISTS] db_name;
-- RENAME DATABASE old_db_name TO new_db_name; (Deprecata)
-- ALTER DATABASE old_db_name MODIFY NAME = new_db_name; (Deprecata)

DROP DATABASE IF EXISTS pomig001;
CREATE DATABASE IF NOT EXISTS pomig001;
-- SHOW DATABASES;
USE pomig001;

-- TABLE --> CREATE | ALTER | DROP
/* CREATE TABLE [IF NOT EXISTS] db_name.table_name (
	column_name1 datatype column_constraints,
    column_name2 datatype column_constraints,
    ...
    column_nameN datatype column_constraints,
    [constraint_name] table_constraints
	);
*/
-- DROP TABLE IF EXISTS db_name.table_name [CASCADE | RESTRICT];
-- ALTER TABLE db_name.table_name ADD COLUMN column_name datatype column_constraints;
-- ALTER TABLE db_name.table_name DROP COLUMN column_name [CASCADE | RESTRICT];
-- ALTER TABLE db_name.table_name RENAME COLUMN old_column_name TO new_column_name;
-- ALTER TABLE db_name.table_name MODIFY column_name datatype;
-- ALTER TABLE db_name.table_name ADD CONSTRAINT [constraint_name] table_constraints;
-- ALTER TABLE db_name.table_name DROP CONSTRAINT table_constraints;

-- RELAZIONI TABELLE --> OneToOne | OneToMany-ManyToOne | ManyToMany

-- DROP TABLE IF EXISTS napol011_test.utenti;
CREATE TABLE IF NOT EXISTS pomig001.utenti (
	id_utente INT NOT NULL AUTO_INCREMENT, -- [PRIMARY KEY]
    nome VARCHAR(25) NOT NULL,
    cognome VARCHAR(25) NOT NULL,
    citta VARCHAR(25) NULL,
    eta INT UNSIGNED NULL,
    email VARCHAR(50) NOT NULL, -- [UNIQUE]
    CONSTRAINT pk_utente PRIMARY KEY(id_utente),
    CONSTRAINT uk_email UNIQUE(email)
);

ALTER TABLE pomig001.utenti ADD COLUMN codice_fiscale CHAR(16) NOT NULL UNIQUE;
ALTER TABLE pomig001.utenti MODIFY citta VARCHAR(50);
-- ALTER TABLE pomig001.utenti RENAME COLUMN id_utente TO id_utente;
-- ALTER TABLE pomig001.utenti DROP COLUMN email;

-- Relazione OneToOne
CREATE TABLE IF NOT EXISTS pomig001.passaporti (
	id_passaporto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numero_passaporto INT UNSIGNED NOT NULL UNIQUE,
    data_rilascio DATE NOT NULL,
    id_utente INT NOT NULL UNIQUE,
    CONSTRAINT fk_passaporti_utenti 
		FOREIGN KEY(id_utente) 
        REFERENCES pomig001.utenti(id_utente)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS pomig001.passaporti (
	id_passaporto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numero_passaporto INT UNSIGNED NOT NULL UNIQUE,
    data_rilascio DATE NOT NULL,
    CONSTRAINT fk_passaporti_utenti 
		FOREIGN KEY(id_passaporto) 
        REFERENCES pomig001.utenti(id_utente)
);

-- Relazione OneToMany|ManyToOne
CREATE TABLE IF NOT EXISTS pomig001.automobili (
	id_automobile INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(25) NOT NULL,
    modello VARCHAR(25) NOT NULL,
    targa CHAR(7) NOT NULL UNIQUE,
    id_utente INT NULL,
    CONSTRAINT fk_automobili_utenti 
		FOREIGN KEY(id_utente) 
        REFERENCES pomig001.utenti(id_utente)
);

-- Relazione ManyToMany
CREATE TABLE IF NOT EXISTS pomig001.corsi (
	id_corso INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    ore INT NULL DEFAULT 250
);

CREATE TABLE IF NOT EXISTS pomig001.utenti_corsi (
	utente_id INT NOT NULL,
    corso_id INT NOT NULL,
    CONSTRAINT fk_utenti_corsi1
		FOREIGN KEY(utente_id) 
        REFERENCES pomig001.utenti(id_utente),
	CONSTRAINT fk_utenti_corsi2
		FOREIGN KEY(corso_id) 
        REFERENCES pomig001.corsi(id_corso)  
);


-- DML -> Data Manipulation Language
-- Definisce tutte le istruzioni SQL per l'inserimento e gestione di dati nelle tabelle

-- INSERT | UPDATE | DELETE

-- INSERT INTO db_name.table_name (column_name1, column_name2, ..., column_nameN)
-- 						   VALUES (value1, value2, ..., valueN);

-- UPDATE db_name.table_name 
-- 				SET column_name1=newValue1, column_name2=newValue2, ..., column_nameN=newValueN
-- 				WHERE column_name = value;

-- DELETE FROM db_name.table_name WHERE column_name = value;

-- utenti --> id_utente(pk),nome(NotNull),cognome(NotNull),citta(Null),
-- 				eta(Uns/Null),email(NotNull/Unq),codice_fiscale(NotNull/Unq)

INSERT INTO pomig001.utenti (nome, cognome, citta, eta, email, codice_fiscale)
	VALUES  ("Mario", "Rossi", "Roma", 25, "m.rossi@example.com", "ABCDEF123AB12ABD"),
			("Giuseppe", "Verdi", "Milano", 31, "g.verdi@example.com", "DEFABC123AB12ABD"),
            ("Francesca", "Neri", "Napoli", 28, "f.neri@example.com", "FABDEC123AB12ABD");
INSERT INTO pomig001.utenti (nome, cognome, email, codice_fiscale)
	VALUES  ("Antonio", "Bianchi", "a.bianchi@example.com", "BDEFAC123AB12ABD");
INSERT INTO pomig001.utenti (nome, cognome, email, citta, codice_fiscale)
	VALUES  ("Maria", "Viola", "m.viola@example.com", "Torino", "BFADEC123AB12");

UPDATE pomig001.utenti SET codice_fiscale="GGG000GGG000G00G" WHERE id_utente = 3;
UPDATE pomig001.utenti SET citta="Roma", eta=20 WHERE id_utente = 2;

-- DELETE FROM pomig001.utenti WHERE id_utente = 1;

INSERT INTO pomig001.passaporti (numero_passaporto, data_rilascio, id_utente) 
						  VALUES(1, "2026-02-25", 2),
								(2, "2026-01-13", 4),
                                (3, "2026-02-08", 1);
                                
DELETE FROM pomig001.utenti WHERE id_utente = 1;
