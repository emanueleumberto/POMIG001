package Esercizio;

import Esercizio.classes.Biblioteca;
import Esercizio.classes.Lettore;
import Esercizio.classes.Libro;
import Esercizio.exceptions.LettoreException;
import Esercizio.exceptions.LibroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GestioneBiblioteca {

    private static Biblioteca biblio = new Biblioteca("MyBiblio");
    private static Logger log = LoggerFactory.getLogger(Biblioteca.class);

    public static void main(String[] args) {

        try {

            Libro l1 = new Libro("9788807900129", "Cime tempestose", "Emily Brontë", 2014);
            Libro l2 = new Libro("9788845926983", "Follia", "Patrick McGrath", 2012);
            Libro l3 = new Libro("9788845934599", "I baffi", "Emmanuel Carrère", 2020);

            Lettore u1 = new Lettore("Mario Rossi", "m.rossi@example.com");
            Lettore u2 = new Lettore("Giuseppe Verdi", "g.verdi@example.com");

            biblio.aggiungiLibro(l1);
            biblio.aggiungiLibro(l2);
            biblio.aggiungiLibro(l3);
            biblio.registraLettore(u1);
            biblio.registraLettore(u2);

            biblio.prestaLibro(u1, "9788807900129"); // Tutto OK
            // biblio.prestaLibro(u1, "9788845926983"); // ISBN non registrato
            // biblio.prestaLibro(u2, "9788807900129"); // Lettore non registrato

            biblio.prestaLibro(u1, "9788845926983");
            biblio.prestaLibro(u2,"9788845934599");

//            log.info("Libri presi in prestito da {}", u1.getNome());
//            for (Libro libro : biblio.getLibriInPrestito(u1)) {
//                log.info("   - {}", libro.getTitolo());
//            }

            biblio.restituisciLibro(u1, "9788845926983");

            biblio.stampaPrestiti();

        } catch (LettoreException e) {
            log.error(e.getMessage());
        } catch (LibroException e) {
            log.error(e.getMessage());
        }
    }
}
