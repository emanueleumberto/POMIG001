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

-- DQL -> Data Query Language
-- Definisce tutte le istruzioni SQL per la lettura dei dati contenuti in un DB

-- SELECT 	-> Definisce un elenco di campi o tutto(*) da restituire in un resultset di dati
-- FROM 	-> Indica la sorgente di dati da cui leggere le informazioni (la/le tabelle)
-- WHERE	-> Search Condition, applica un filtro sulle righe della tabella indicata nel FROM
-- GROUP BY	-> Aggrega dei dati rispetto alla combinazione univoca data dalla group list
-- HAVING	-> Search Condition, applica un filtro sulle righe della tabella filtrata ed aggregata dal GROUP BY
-- ORDER BY	-> Consente di definire un ordinamento ben preciso
-- LIMIT	-> Consente di selezionare un numero definito di record

/*
	SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN |*| aggregate_function(expression)
		FROM db_name.table_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
*/

/*
	Operatori di confronto della Search Condition
    = (uguale)
    > (maggiore di)
    < (minore di)
    >= (maggiore o uguale)
    <= (minore o uguale)
    <>|!= (diverso da) 
    !< (non minore di)
    !> (non maggiore di)
    
    Operatori logici della Search Condition
    AND (restituisce TRUE se entrambe le condizioni sono vere)
    OR (restituisce TRUE se almeno una delle condizioni è vera)
    
    LIKE (contiene -> caratteri jolly -> _ %)
    BETWEEN (restituisce tutti i valori compresi tra >= AND <= del range specificato)
    IN | NOT IN (Di un elenco di dati in cui individuare una corrispondenza)
*/

/*
	INNER JOIN | LEFT JOIN | RIGHT JOIN | CROSS JOIN
    
    SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN |*| aggregate_function(expression)
		FROM db_name.table_name1 AS tb1
        INNER JOIN db_name.table_name2 AS tb2
        ON tb1.column_name = tb2.column_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
    
    SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN |*| aggregate_function(expression)
		FROM db_name.table_name1 AS tb1
        LEFT JOIN db_name.table_name2 AS tb2
        ON tb1.column_name = tb2.column_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
        
	SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN |*| aggregate_function(expression)
		FROM db_name.table_name1 AS tb1
        RIGHT JOIN db_name.table_name2 AS tb2
        ON tb1.column_name = tb2.column_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
	
    SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN |*| aggregate_function(expression)
		FROM db_name.table_name1 AS tb1
        CROSS JOIN db_name.table_name2 AS tb2
        ON tb1.column_name = tb2.column_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
    
*/

/*

	SubQuery o Inner Query -> Sono query inserite in altre query, 
    una query annidata dipende dalla query esterna
    
    SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN | * | aggregate_function(expression)
	FROM (
		SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN ) 
			FROM table_name
            [WHERE search condition]
	)
    [WHERE search condition]
    
    SELECT (
		SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN ) 
			FROM table_name
            [WHERE search condition]
	)
	FROM table_name
    [WHERE search condition]
    
    SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN | * | aggregate_function(expression)
	FROM table_name
    WHERE (
		SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN ) 
			FROM table_name
            [WHERE search condition]
	)

*/

/* 
    String function
    https://dev.mysql.com/doc/refman/8.4/en/string-functions.html
    CONCAT(column_name1, " - ", column_name2) -> Funzione che permette di concatenare due o più valori
    UPPER('String' | column_name) -> Funzione che permette di trasformare un valore testuale in Uppercase
    LOWER('String' | column_name) -> Funzione che permette di trasformare un valore testuale in Lowercase
    LENGTH('String' | column_name) -> Funzione che restituisce la lunghezza di una stringa o di un valore letto dal db
    TRIM('String' | column_name) -> Funzione che restituisce un valore testuale senza spazi vuoti prima o dopo il testo
    
    Numeric Function
    https://dev.mysql.com/doc/refman/8.4/en/numeric-functions.html
    COUNT(* | DISTINCT column_name) -> Funzione che restituisce il numero di record di una query
    FORMAT(number | column_name, 2) -> Funzione che restituisce un numero decimale formattato
    TRUNCATE(number | column_name, 2) -> Funzione che restituisce un numero decimale troncato
    ABS(number | column_name) -> Funzione che restituisce un valore assoluto (senza segno -)
    AVG(column_name) -> Funzione che restituisce la media dei valori numerici di una colonna
    CEIL(column_name) -> Funzione che restituisce un valore arrotondato per eccesso
    FLOOR(column_name) -> Funzione che restituisce un valore arrotondato per difetto
    ROUND(column_name) -> Funzione che restituisce un valore arrotondato per il numero intero più vicino
    RAND() -> Funzione che restituisce un valore casuale da 0 a 1
    MAX(column_name) -> Funzione che restituisce il valore massimo presente in una colonna
    MIN(column_name) -> Funzione che restituisce il valore minimo presente in una colonna
    SUM(column_name) -> Funzione che restituisce la somma dei valori presenti in una colonna
	
    Date Function
    https://dev.mysql.com/doc/refman/8.4/en/date-and-time-functions.html
    ADDDATE(data, n) -> Funzione che aggiunge n ad una data
    ADDTIME(time, n) -> Funzione che aggiunge n ad un valore orario
    CURRENT_DATE() -> Funzione che restituisce una data in formato YYYY-MM-DD (String)
    CURRENT_TIME() -> Funzione che restituisce un orario in formato HH-MM-SS (String)
    CURRENT_TIMESTAMP() -> Funzione che restituisce data e ora del momento
    DATADIFF(data1, data2) -> Funzione che calcola la differenza di giorni tra due date
    DAY(data) -> Funzione che restituisce il giorno da una data completa
    MONTH(data) -> Funzione che restituisce il mese da una data completa
    YEAR(data) -> Funzione che restituisce l'anno da una data completa
    HOUR(data) -> Funzione che restituisce l'ora da una data completa
    MINUTE(data) -> Funzione che restituisce i minuti da una data completa
    SECOND(data) -> Funzione che restituisce i secondi da una data completa
    
    Advanced Function
    ISNULL(column_name) -> Funzione che restituisce 1 o 0 in base al valore NULL contenuto in una colonna
    LAST_INSERT_ID() -> Funzione che restituisce l'ultimo valore intero inserito nel campo ID della PK
    
*/

SELECT * FROM pomig001.utenti WHERE citta = "Roma";
SELECT * FROM pomig001.passaporti;

-- View
-- Una vista è una tabella virtuale basta sul risultato di una SELECT
/*
	CREATE [OR REPLACE] VIEW view_name AS
		SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN |*| aggregate_function(expression)
		FROM db_name.table_name1 AS tb1
        INNER JOIN db_name.table_name2 AS tb2
        ON tb1.column_name = tb2.column_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
*/


CREATE OR REPLACE VIEW view_passaporti_utenti AS
	SELECT u.id_utente, u.nome, u.cognome, u.citta, u.eta, u.email, u.codice_fiscale, p.numero_passaporto, p.data_rilascio 
		FROM pomig001.utenti AS u 
        JOIN pomig001.passaporti AS p 
        ON u.id_utente = p.id_utente;
        
SELECT * FROM pomig001.view_passaporti_utenti;

-- Store Procedure
/*
	DELIMITER &&
    
    CREATE PROCEDURE procedure_name [IN | OUT | INOUT parameter_name datatype... ]
    BEGIN
		procedure declaretion
    END &&
    DELIMITER;
*/

DELIMITER &&
	CREATE PROCEDURE getAllUsers()
		BEGIN
			SELECT u.id_utente, u.nome AS firstname, u.cognome AS lastname, 
				u.citta AS city, u.eta AS age, u.email, u.codice_fiscale AS fiscal_code, 
                p.numero_passaporto AS number_passport, p.data_rilascio AS passport_date 
			FROM pomig001.utenti AS u 
			JOIN pomig001.passaporti AS p 
			ON u.id_utente = p.id_utente;
		END &&
DELIMITER ;

DELIMITER &&
	CREATE PROCEDURE getUser(IN userId INT)
		BEGIN
			SELECT u.id_utente, u.nome AS firstname, u.cognome AS lastname, 
				u.citta AS city, u.eta AS age, u.email, u.codice_fiscale AS fiscal_code, 
                p.numero_passaporto AS number_passport, p.data_rilascio AS passport_date 
			FROM pomig001.utenti AS u 
			JOIN pomig001.passaporti AS p 
			ON u.id_utente = p.id_utente WHERE u.id_utente = userId;
		END &&
DELIMITER ;            

DELIMITER &&
	CREATE PROCEDURE countUsers(OUT totalUser INT)
		BEGIN
			SELECT COUNT(*) INTO totalUser
			FROM pomig001.utenti;
		END &&
DELIMITER ;  

DELIMITER &&
	CREATE PROCEDURE countUsersByCity(IN city VARCHAR(50), OUT totalUser INT)
		BEGIN
			SELECT COUNT(*) INTO totalUser
			FROM pomig001.utenti WHERE citta = city;
		END &&
DELIMITER ;

DELIMITER &&
	CREATE PROCEDURE insert_passport(IN numPassport INT, IN user INT, IN passportDate DATE, OUT resp VARCHAR(50) )
		BEGIN
			DECLARE already_exists INT;
        
			SELECT COUNT(*) INTO already_exists
			FROM pomig001.utenti AS u 
			JOIN pomig001.passaporti AS p 
			ON u.id_utente = p.id_utente WHERE p.numero_passaporto = numPassport;
            
            IF already_exists = 0 THEN 
				INSERT INTO pomig001.passaporti (numero_passaporto, data_rilascio, id_utente) 
						  VALUES(numPassport, passportDate, user);
				SET resp = "Passaporto inserito";
			ELSE 
				SET resp = "Passaporto già presente";
			END IF;
            
		END &&
DELIMITER ;


CALL pomig001.getAllUsers();
CALL pomig001.getUser(2);
CALL pomig001.countUsers(@tot);
SELECT @tot;
CALL pomig001.countUsersByCity("Roma", @tot);
SELECT "Roma" AS city, @tot AS total_user;
-- Function
/*
	
*/
