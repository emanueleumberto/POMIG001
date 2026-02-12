package Esercizio2;

public class GestioneBiblioteca {
    public static void main(String[] args) {
        Libro l1 = new Libro("Follia", "Patrick McGrath", "9788845926983");
        Libro l2 = new Libro("La banalità del male", "Hannah Arendt", "9788807897450");
        Libro l3 = new Libro("Un giorno questo dolore ti sarà utile", "Peter Cameron", "9788845925023");
        Libro l4 = new Libro("La vegetariana", "Han Kang", "9788845934018");
        Libro l5 = new Libro("Fattoria degli animali", "George Orwell", "9788807903793");

        Utente u1 = new Utente("Mario", "Rossi");
        Utente u2 = new Utente("Giuseppe", "Verdi");
        Utente u3 = new Utente("Francesca", "Neri");

        Biblioteca b1 = new Biblioteca("New Biblio");

        b1.aggiungiLibro(l1);
        b1.aggiungiLibro(l2);
        b1.aggiungiLibro(l1); // Libro già presente
        b1.aggiungiLibro(l3);
        b1.aggiungiLibro(l4);
        b1.aggiungiLibro(l5);

        b1.registraUtente(u1);
        b1.registraUtente(u2);
        b1.registraUtente(u1); // Utente già presente
        b1.registraUtente(u3);

        b1.mostraCatalogo();
        b1.mostraUtentiRegistrati();

        b1.prestitoLibro("U0002", "9788845934018");
        b1.prestitoLibro("U0002", "9788807903793");
        b1.prestitoLibro("U0002", "9788807897450");
        b1.prestitoLibro("U0002", "9788845926983");

        b1.restituzioneLibro("U0002", "9788807903793");

        u2.mostraLibriInPrestito();


//        System.out.println(l1.getDettagli());
//        System.out.println(l2.getDettagli());
//        System.out.println(l3.getDettagli());
//
//        u2.prendereInPrestito(l3);
//
//        u1.prendereInPrestito(l2);
//        u1.prendereInPrestito(l3); // Libro non disponibile
//        u1.prendereInPrestito(l1);
//        u1.prendereInPrestito(l4);
//        u1.prendereInPrestito(l5); // Ho già 3 prestiti
//
//        u1.restituireLibro(l3); // Libro non è presente tra i prestiti
//        u1.restituireLibro(l1);
//
//        u1.mostraLibriInPrestito();
//        u2.mostraLibriInPrestito();

    }
}
