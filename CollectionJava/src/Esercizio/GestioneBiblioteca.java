package Esercizio;

import Esercizio.classes.Biblioteca;
import Esercizio.classes.Lettore;
import Esercizio.classes.Libro;
import Esercizio.exceptions.LettoreException;
import Esercizio.exceptions.LibroException;
import com.github.javafaker.Faker;
import generics.Utente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Locale;

public class GestioneBiblioteca {

    private static Biblioteca biblio = new Biblioteca("MyBiblio");
    private static Logger log = LoggerFactory.getLogger(Biblioteca.class);
    private static Faker fake = new Faker(new Locale("it-IT"));

    public static void main(String[] args) {

        try {

//            Libro l1 = new Libro("9788807900129", "Cime tempestose", "Emily Brontë", 2014);
//            Libro l2 = new Libro("9788845926983", "Follia", "Patrick McGrath", 2012);
//            Libro l3 = new Libro("9788845934599", "I baffi", "Emmanuel Carrère", 2020);
//
//            Lettore u1 = new Lettore("Mario Rossi", "m.rossi@example.com");
//            Lettore u2 = new Lettore("Giuseppe Verdi", "g.verdi@example.com");
//
//            biblio.aggiungiLibro(l1);
//            biblio.aggiungiLibro(l2);
//            biblio.aggiungiLibro(l3);
//            biblio.registraLettore(u1);
//            biblio.registraLettore(u2);

//             biblio.prestaLibro(u1, "9788807900129"); // Tutto OK
//             biblio.prestaLibro(u1, "9788845926983"); // ISBN non registrato
//             biblio.prestaLibro(u2, "9788807900129"); // Lettore non registrato

//            biblio.prestaLibro(u1, "9788845926983");
//            biblio.prestaLibro(u2,"9788845934599");

//            log.info("Libri presi in prestito da {}", u1.getNome());
//            for (Libro libro : biblio.getLibriInPrestito(u1)) {
//                log.info("   - {}", libro.getTitolo());
//            }

//            biblio.restituisciLibro(u1, "9788845926983");
//


            creaLettoriFake(10) ;
            creaLibriFake(25);

//            Lettore u1 = biblio.trovaLettoreDaId(3);
//            Libro l1 = biblio.getLibriDisponibili().get(14);

            biblio.prestaLibro(
                    biblio.trovaLettoreDaId(3),
                    biblio.getLibriDisponibili().get(14).getIsbn());
            biblio.prestaLibro(
                    biblio.trovaLettoreDaId(6),
                    biblio.getLibriDisponibili().get(3).getIsbn());
            biblio.prestaLibro(
                    biblio.trovaLettoreDaId(5),
                    biblio.getLibriDisponibili().get(20).getIsbn());
            biblio.prestaLibro(
                    biblio.trovaLettoreDaId(3),
                    biblio.getLibriDisponibili().get(1).getIsbn());

            Libro l = biblio.getLibriDisponibili().get(14);
            biblio.prestaLibro(
                    biblio.trovaLettoreDaId(9),
                    l.getIsbn()
                    );
            biblio.prestaLibro(
                    biblio.trovaLettoreDaId(7),
                    biblio.getLibriDisponibili().get(2).getIsbn());
            biblio.prestaLibro(
                    biblio.trovaLettoreDaId(5),
                    biblio.getLibriDisponibili().get(7).getIsbn());

            biblio.restituisciLibro(biblio.trovaLettoreDaId(9), l.getIsbn());

//            for (Libro libro : biblio.getLibriDisponibili()) {
//                System.out.println(libro);
//            }
//
//            for (Lettore lettore : biblio.getUtentiRegistrati()) {
//                System.out.println(lettore);
//            }

            biblio.stampaPrestiti();

        } catch (LettoreException e) {
            log.error(e.getMessage());
        } catch (LibroException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public static void creaLettoriFake(int num) throws LettoreException {
        for (int i = 0; i < num; i++) {
            biblio.registraLettore(new Lettore(fake.name().fullName(), fake.internet().emailAddress()));
        }
    }

    public static void creaLibriFake(int num) {
        for (int i = 0; i < num; i++) {
            biblio.aggiungiLibro(new Libro(fake.number().digits(10), fake.book().title(), fake.book().author(), fake.number().numberBetween(1900, 2026)));
        }
    }

}
