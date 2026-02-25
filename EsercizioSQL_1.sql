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